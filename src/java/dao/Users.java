/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import entity.User;
import entity.UserGroup;
import entity.personalinfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;
import util.Pagination;

/**
 *
 * @author Casper
 */
public class Users {

    ConnectionClass connect = new ConnectionClass();

    public int getCount(UserGroup group)
    {
          int result=0;
        try {
             String sql = "SELECT COUNT(UserId) FROM Users "
                    + "inner join PersonalInfo PI on PI.PInfoId = PersonId "
                    + " WHERE UserType=?";

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
    public List<User> getUserList(UserGroup group, Pagination page) {
        List<User> result = new ArrayList<>();

        try {
            String sql = "SELECT UserId, Username, Password,  PI.EName, PI.ESurname, PI.CitizensShipNumber, PI.PInfoId FROM Users "
                    + "inner join PersonalInfo PI on PI.PInfoId = PersonId "
                    + " WHERE UserType=? LIMIT ?,?";

            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, group.getGroupId());
             st.setInt(2, page.from());
            st.setInt(3, page.to());
           
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setUserType(group);
                personalinfo person = new personalinfo();
                person.setPInfoId(rs.getInt(7));
                person.setEName(rs.getString(4));
                person.setESurname(rs.getString(5));
                person.setCitizensShipNumber(rs.getString(6));
                user.setuserinfo(person);
                result.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public boolean addUser(User user) {
        try {
            String sql = "INSERT INTO Users (UserName, Password, userType, PersonId) VALUES (?,?,?,?);";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getUserType().getGroupId());
            st.setInt(4, user.getuserinfo().getPInfoId());
            st.executeUpdate();
            return true;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void updateUser(User user) {
        try {
            String sql = "UPDATE Users SET UserName=?, Password=?, userType=?, PersonId=? WHERE UserId = ?;";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getUserType().getGroupId());
            st.setInt(4, user.getuserinfo().getPInfoId());
            st.setInt(5, user.getUserId());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            String sql = "DELETE FROM Users WHERE UserId = ?;";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, user.getUserId());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
