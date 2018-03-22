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

    public List<UserGroup> getGroupList() {
        List<UserGroup> result = new ArrayList<>();
        try {
            String sql = "SELECT UserTypeId, TypeName FROM UserTypes";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserGroup tmp = new UserGroup();
                tmp.setGroupId(rs.getInt(1));
                tmp.setGroupName(rs.getString(2));
                tmp = permDao.getGroupPerms(tmp);
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
}
