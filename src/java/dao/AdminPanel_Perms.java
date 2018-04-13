/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.Perms_Perm;
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
public class AdminPanel_Perms {

    ConnectionClass connect = new ConnectionClass();

    public void AddPerm(Perms_Perm perm) {
        try {
            String sql = "INSERT INTO Perms (PermName, PermLink, ScreenCode, ViewMenu) VALUES(?,?,?,?)";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, perm.getPermName());
            st.setString(2, perm.getPermLink());
            st.setString(3, perm.getScreenCode());
            st.setBoolean(4, perm.isViewMenu());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdatePerm(Perms_Perm perm) {
        try {
            String sql = "UPDATE Perms SET PermName=? , PermLink=?, ScreenCode=?, ViewMenu=? WHERE PermId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, perm.getPermName());
            st.setString(2, perm.getPermLink());
            st.setString(3, perm.getScreenCode());
            st.setBoolean(4, perm.isViewMenu());
            st.setInt(5, perm.PermId);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DeletePerm(Perms_Perm perm) {
        try {
            String sql = "DELETE FROM Perms WHERE PermId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, perm.PermId);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Perms_Perm> getPermList(Pagination page) {
        List<Perms_Perm> result = new ArrayList<Perms_Perm>();
        try {
            String sql = "SELECT PermId, PermName , PermLink, ScreenCode, ViewMenu FROM Perms LIMIT ?,?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, page.from());
            st.setInt(2, page.to());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms_Perm tmp = new Perms_Perm();
                tmp.setPermId(rs.getInt(1));
                tmp.setPermName(rs.getString(2));
                tmp.setPermLink(rs.getString(3));
                tmp.setScreenCode(rs.getString(4));
                tmp.setViewMenu(rs.getBoolean(5));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int getRowCount() {
        int result = 0;

        try {
            String sql = "SELECT COUNT(PermId) FROM Perms";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

