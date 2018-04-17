/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.UserGroup;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;
import util.Pagination;

/**
 *
 * @author Casper
 */
public class AdminPanel_UserGroup {
    
     ConnectionClass connect = new ConnectionClass();
            AdminPanel_UserGroupPerms permDao = new AdminPanel_UserGroupPerms();
            
    public void AddGroup(UserGroup group) {
        try {
            String sql = "INSERT INTO UserTypes (TypeName) VALUES(?)";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, group.getGroupName());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateGroup(UserGroup group) {
        try {
            String sql = "UPDATE UserTypes SET TypeName = ? WHERE UserTypeId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, group.getGroupName());
            st.setInt(3, group.getGroupId());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteGroup(UserGroup group) {
        try {
            String sql = "DELETE FROM UserTypes WHERE UserTypeId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public int getCount(){
        int result=0;
        try {
            String sql = "SELECT COUNT(UserTypeId) FROM UserTypes";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<UserGroup> getGroupList(Pagination page) {
        List<UserGroup> result = new ArrayList<>();
        try {
            String sql = "SELECT UserTypeId, TypeName FROM UserTypes LIMIT ?,?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, page.from());
            st.setInt(2, page.to());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGroup tmp = new UserGroup();
                tmp.setGroupId(rs.getInt(1));
                tmp.setGroupName(rs.getString(2));
                tmp = permDao.getGroupPerms(tmp, null);
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
}
