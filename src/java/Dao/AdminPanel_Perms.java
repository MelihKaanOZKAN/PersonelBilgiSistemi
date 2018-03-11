/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.Perms_Perm;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Syste
 */
public class AdminPanel_Perms {

    ConnectionClass connect = new ConnectionClass();

    public void AddPerm(Perms_Perm perm) {
        try {
            String sql = "INSERT INTO Perms (PermName, PermLink) VALUES(?,?)";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, perm.permName);
            st.setString(2, perm.PermLink);
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void UpdatePerm(Perms_Perm perm) {
        try {
            String sql = "UPDATE Perms SET PermName=? , PermLink=? WHERE PermId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setString(1, perm.permName);
            st.setString(2, perm.PermLink);
            st.setInt(3, perm.PermId);
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

    public List<Perms_Perm> getPermList() {
        List<Perms_Perm> result = new ArrayList<Perms_Perm>();
        try {
            String sql = "SELECT PermId, PermName , PermLink FROM Perms";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perms_Perm tmp = new Perms_Perm();
                tmp.setPermId(rs.getInt(1));
                tmp.setPermName(rs.getString(2));
                tmp.setPermLink(rs.getString(3));
                result.add(tmp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
