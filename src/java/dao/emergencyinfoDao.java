
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.EmployeeInfo;
import entity.emergencyinfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;

/**
 *
 * @author Ozan
 */
public class emergencyinfoDao {
    
    public List<emergencyinfo> getEmergencyinfo(EmployeeInfo info)
    {
        List<emergencyinfo> clist = new ArrayList<>();
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu="SELECT RecordId,InfoId,NameSurname,Phone from emergencyinfo where InfoId=?";
            PreparedStatement st = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            st.setInt(1, info.getPinfo().getPInfoId());
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                emergencyinfo tmp = new emergencyinfo();
                tmp.setRecordId(rs.getInt("RecordId"));
                tmp.setInfoId(rs.getInt("InfoId"));
                tmp.setNameSurname(rs.getString("NameSurname"));
                tmp.setPhone(rs.getString("Phone"));
                clist.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clist;
    }
    
}
