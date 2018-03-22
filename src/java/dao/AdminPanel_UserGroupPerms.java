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
     
    public List<Perms> getPermList(UserGroup group) {
        List<Perms> result = new ArrayList<>();
        try {
            String sql = "SELECT PermId, PermName , PermLink, ScreenCode FROM Perms P " +
"            left join UserPerms UP on p.PermId = UP.permissionid " +
"            and UP.UserTypeId = ? " +
"            where UP.UserTypeId is null ";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
               tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                tmp.getPerm().setPermLink(rs.getString(3));
                tmp.getPerm().setScreenCode(rs.getString(4));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public UserGroup getGroupPerms(UserGroup group) {
  
        try {
            List<Perms> result = new ArrayList<>();
            String sql = "select PermissionId, pr.PermName, pr.PermLink, pr.ScreenCode, PermVisual, PermSet from UserPerms UP\n" +
            "inner join Perms pr on pr.PermId = UP.PermissionId\n" +
            "where UP.UserTypeId=?;";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
                tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                tmp.getPerm().setPermLink(rs.getString(3));
                tmp.getPerm().setScreenCode(rs.getString(4));
                tmp.setPermVisual(rs.getBoolean(5));
                tmp.setPermSet(rs.getBoolean(6));
                result.add(tmp);
            }
            group.setGroupPerms(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return group;
    }
}
