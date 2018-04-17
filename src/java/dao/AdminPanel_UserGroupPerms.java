/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.Perms;
import entity.Perms_Perm;
import entity.UserGroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Pagination;

/**
 *
 * @author Casper
 */
public class AdminPanel_UserGroupPerms {
     ConnectionClass connect = new ConnectionClass();

     public void addPerm2Group(Perms perm, UserGroup grp)
     { try{
            String sql = "INSERT INTO userPerms (PermissionId, UserTypeId, PermVisual, PermSet) "
                    + "VALUES (?, ?, ?, ?);";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, perm.getPerm().getPermId());
            st.setInt(2, grp.getGroupId());
            st.setBoolean(3, perm.isPermVisual());
            st.setBoolean(4, perm.isPermSet());
            st.executeUpdate();
            }catch (SQLException ex) {
            ex.printStackTrace();
        }
         
     }
     
     public void deletePermFromGroup (Perms perm, UserGroup grp)
     { try{
            String sql = "DELETE FROM userPerms WHERE PermissionId = ? AND UserTypeId = ?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, perm.getPerm().getPermId());
            st.setInt(2, grp.getGroupId());
            st.executeUpdate();
            }catch (Exception ex) {
            ex.printStackTrace();
        }
         
     }
     
     public int getCountPermList(UserGroup group)
     {
         int result=0;
          try {
            String sql = "SELECT COUNT(PermId) FROM Perms P " +
"            left join UserPerms UP on p.PermId = UP.permissionid " +
"            and UP.UserTypeId = ? " +
"            where UP.UserTypeId is null ";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            ResultSet rs = st.executeQuery();
            rs.next();
            result = rs.getInt(1);
           } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
     }
    public List<Perms> getPermList(UserGroup group, Pagination page) {
        List<Perms> result = new ArrayList<>();
        try {
            String sql = "SELECT PermId, PermName , PermLink, ScreenCode, ViewMenu FROM Perms P " +
"            left join UserPerms UP on p.PermId = UP.permissionid " +
"            and UP.UserTypeId = ? " +
"            where UP.UserTypeId is null LIMIT ?,? ";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            st.setInt(2, page.from());
            st.setInt(3, page.to());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
               tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                tmp.getPerm().setPermLink(rs.getString(3));
                tmp.getPerm().setScreenCode(rs.getString(4));
                tmp.getPerm().setViewMenu(rs.getBoolean(5));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public int getCountGroupPerms(UserGroup group)
     {
         int result=0;
          try {
            String sql = "select COUNT(PermissionId) from UserPerms UP " +
            "inner join Perms pr on pr.PermId = UP.PermissionId " +
            "where UP.UserTypeId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            ResultSet rs = st.executeQuery();
            rs.next();
            result = rs.getInt(1);
           } catch (Exception ex) {
            ex.printStackTrace();
        }
         return result;
     }
    
    public UserGroup getGroupPerms(UserGroup group, Pagination page) {
  
        try {
            List<Perms> result = new ArrayList<>();
            PreparedStatement st;
            if(page != null){
            String sql = "select PermissionId, pr.PermName, pr.PermLink, pr.ScreenCode, pr.ViewMenu, PermVisual, PermSet from UserPerms UP " +
            "inner join Perms pr on pr.PermId = UP.PermissionId " +
            "where UP.UserTypeId=?"
                    + " ORDER BY pr.PermName ASC LIMIT ?,?;";
             st =(PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            st.setInt(2, page.from());
            st.setInt(3, page.to());
            }
            else{
                String sql = "select PermissionId, pr.PermName, pr.PermLink, pr.ScreenCode, pr.ViewMenu, PermVisual, PermSet from UserPerms UP " +
            "inner join Perms pr on pr.PermId = UP.PermissionId " +
            "where UP.UserTypeId=?"
                    + " ORDER BY pr.PermName ASC;";
             st =(PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
                tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                tmp.getPerm().setPermLink(rs.getString(3));
                tmp.getPerm().setScreenCode(rs.getString(4));
                tmp.getPerm().setViewMenu(rs.getBoolean(5));
                tmp.setPermVisual(rs.getBoolean(6));
                tmp.setPermSet(rs.getBoolean(7));
                result.add(tmp);
            }
            group.setGroupPerms(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return group;
    }
}
