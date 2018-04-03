/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.ConnectionClass;
import entity.communicationinfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class communicationinfoDao {

    public void addCommunication(communicationinfo com) {
        ConnectionClass connection = new ConnectionClass();
        PreparedStatement ps;
        String sorgu;
        try {
            sorgu = "INSERT INTO communicationinfo (PhoneNumber,Email) values (?,?)";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, com.getPhoneNumber());
            ps.setString(2, com.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCommunication(communicationinfo com) {
        ConnectionClass connection = new ConnectionClass();
        PreparedStatement ps;
        String sorgu;
        try {
            sorgu = "UPDATE communicationinfo SET PhoneNumber=?,Email=? WHERE CommId=?";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, com.getPhoneNumber());
            ps.setString(2, com.getEmail());
            ps.setInt(3, com.getCommId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteCommunication(communicationinfo com) {
        ConnectionClass connection = new ConnectionClass();
        PreparedStatement ps;
        String sorgu;
        try {
            sorgu = "DELETE FROM communicationinfo WHERE CommId=?";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setInt(1, com.getCommId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public communicationinfo findCommunication(communicationinfo com) {
        ConnectionClass connection = new ConnectionClass();
        PreparedStatement ps;
        String sorgu;
        try {
            sorgu = "SELECT PhoneNumber,Email WHERE CommId=?";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setInt(1, com.getCommId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            com.setPhoneNumber(rs.getString("PhoneNumber"));
            com.setEmail(rs.getString("Email"));
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return com;
    }

    public List<communicationinfo> getCommunication() {
        ConnectionClass connection = new ConnectionClass();
        PreparedStatement ps;
        String sorgu;
        List<communicationinfo> clist = new ArrayList<>();
        try {
            sorgu = "SELECT CommId,PhoneNumber,Email from communicationinfo";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                communicationinfo com = new communicationinfo();
                com.setCommId(rs.getInt("CommId"));
                com.setPhoneNumber(rs.getString("PhoneNumber"));
                com.setEmail(rs.getString("Email"));
                clist.add(com);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clist;
    }
}
