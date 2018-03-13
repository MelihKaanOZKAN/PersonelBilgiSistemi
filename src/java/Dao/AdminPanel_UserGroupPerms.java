/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.Perms;
import entity.Perms_Perm;
import entity.Perms_PermGroup;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class AdminPanel_UserGroupPerms {
     ConnectionClass connect = new ConnectionClass();

     public void addPerm2Group(Perms perm)
     { try{
            String sql = "SELECT PermId, PermName , PermLink FROM Perms";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
           
            }catch (Exception ex) {
            ex.printStackTrace();
        }
         
     }
     
     
     
    public List<Perms> getPermList(int GroupId) {
        List<Perms> result = new ArrayList<Perms>();
        try {
            String sql = "SELECT PermId, PermName , PermLink FROM Perms P\n" +
            "left join UserPerms UP on p.PermId = UP.permissionid\n" +
            "where UP.UserTypeId != ?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, GroupId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
               tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<Perms> getGroupPerms(int GroupId) {
        List<Perms> result = new ArrayList<Perms>();
        try {
            String sql = "select PermissionId, pr.PermName, PermVisual, PermSet from UserPerms UP\n" +
            "inner join Perms pr on pr.PermId = UP.PermissionId\n" +
            "where UP.UserTypeId=?;";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, GroupId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms tmp = new Perms();
                tmp.setPerm(new Perms_Perm());
                tmp.getPerm().setPermId(rs.getInt(1));
                tmp.getPerm().setPermName(rs.getString(2));
                tmp.setPermVisual(rs.getBoolean(3));
                tmp.setPermSet(rs.getBoolean(4));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
