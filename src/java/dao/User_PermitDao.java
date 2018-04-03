/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User_PermitTypes;
import entity.User_Permits;
import util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.personalinfo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class User_PermitDao {

    ConnectionClass connect = new ConnectionClass();

    public List<User_PermitTypes> getPermitTypes() {
        List<User_PermitTypes> result = new ArrayList<>();

        try {
            String sql = "Select PermitName, PermitTypeId from PermitTypes";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                User_PermitTypes tmp = new User_PermitTypes();
                tmp.setPermitName(rs.getString(1));
                tmp.setPermitTypeId(rs.getInt(2));
                result.add(tmp);
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }

        return result;
    }

    public List<User_Permits> getPermits(personalinfo person) {
        List<User_Permits> result = new ArrayList<>();
        System.out.println("daoPermit " + person.getCitizensShipNumber() + " " + person.getPInfoId());
        
        try {
            String sql = "Select PermitId, PTP.PermitName, PermitComment, Date,PTP.PermitTypeId from permits PT " +
"                    inner join PermitTypes PTP on PTP.PermitTypeId = PT.PermitType  " +
"                    WHERE PT.PersonId=?";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, person.getPInfoId());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                User_Permits tmp = new User_Permits();
                tmp.setPermitId(rs.getInt(1));
                tmp.setPerson(person);
                User_PermitTypes tmp2 = new User_PermitTypes();
                tmp2.setPermitName(rs.getString(2));
                tmp2.setPermitTypeId(rs.getInt(5));
                tmp.setPermitType(tmp2);
                tmp.setPermitComment(rs.getString(3));
                tmp.setDate(rs.getDate(4));
                result.add(tmp);
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }

        return result;
    }

    public void insert(User_Permits permit) {
        try {
            String sql = "insert into PermitTable(PersonId,PermitType,PermitComment,Date)"
                    + "valurs(?,?,?,?)";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
            st.setInt(1, permit.getPerson().getPInfoId());
            st.setInt(2, permit.getPermitType().getPermitTypeId());
            st.setString(3, permit.getPermitComment());
            st.setDate(4, (Date) permit.getDate());

            st.executeUpdate();

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    public void update(User_Permits permit) {

        try {
            String sgl = "UPDATE permits SET PermitType=? PermitComment=? Date=? WHERE PermitId=? ";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sgl);
            st.setInt(1, permit.getPermitType().getPermitTypeId());
            st.setString(2, permit.getPermitComment());
            st.setDate(3, permit.getDate());
            st.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Hata Var Burada :" + e.toString());
        }

    }

    public void delete(User_Permits permit) {

        try {
            String sgl = "DELETE FROM permits WHERE PermitId=? ";
            PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sgl);
            st.setInt(1, permit.getPermitId());

            st.executeUpdate();

        } catch (Exception e) {
            System.err.println("Hata Var Burada :" + e.toString());

        }

    }

}
