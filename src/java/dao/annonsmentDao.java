/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Annons;
import entity.UserGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;

/**
 *
 * @author Casper
 */
public class annonsmentDao {

    ConnectionClass connect = new ConnectionClass();

     public void deleteAnnons(Annons ans) {
        try {
            String sql = "DELETE FROM announcements WHERE RecordId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, ans.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     public void updateAnnons(Annons ans) {
        try {
            String sql = "UPDATE announcements SET UserGroupId=?, Text=?, Active=? WHERE RecordId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, ans.getGroup().getGroupId());
            st.setString(2, ans.getText());
            st.setBoolean(3, ans.isActive());
            st.setInt(4, ans.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addAnnons(Annons ans) {
        try {
            String sql = "INSERT INTO announcements (UserGroupId, Text, Active) VALUES (?,?,?)";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, ans.getGroup().getGroupId());
            st.setString(2, ans.getText());
            st.setBoolean(3, ans.isActive());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Annons> getAllAnnons(UserGroup Group) {
        List<Annons> result = new ArrayList<>();
        try {
            String sql = "SELECT RecordId, Text, Active FROM announcements WHERE UserGroupId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, Group.getGroupId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Annons tmp = new Annons();
                tmp.setId(rs.getInt("RecordId"));
                tmp.setGroup(Group);
                tmp.setText(rs.getString("Text"));
                tmp.setActive(rs.getBoolean("Active"));
                result.add(tmp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<Annons> getAnnons(UserGroup Group) {
        List<Annons> result = new ArrayList<>();
        try {
            String sql = "SELECT RecordId, Text FROM announcements WHERE UserGroupId=? AND Active=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, Group.getGroupId());
            st.setBoolean(2, true);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Annons tmp = new Annons();
                tmp.setId(rs.getInt("RecordId"));
                tmp.setGroup(Group);
                tmp.setText(rs.getString("Text"));
                tmp.setActive(true);
                result.add(tmp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
