/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import util.ConnectionClass;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import entity.personalinfo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HakanBey
 */
public class personalinfoDAO {
    ConnectionClass db = new ConnectionClass();
        Connection c = db.connection;
    public personalinfo getPersonalInfobyCTNumber(personalinfo info) {

       PreparedStatement st;

        try {
            String sql = "SELECT PInfoId, EName, ESurname FROM PersonalInfo WHERE CitizensShipNumber=? ";
            st = (PreparedStatement) c.prepareStatement(sql);
            st.setString(1, info.getCitizensShipNumber());
            ResultSet rs = st.executeQuery();
            rs.next();
            info.setPInfoId(rs.getInt(1));
            info.setEName(rs.getString(2));
            info.setESurname(rs.getString(3));
            st.close();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return info;
    }
}
