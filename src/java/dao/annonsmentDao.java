/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Annons;
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
   public List<Annons> getAnnons(int GroupId)
   {
       List<Annons> result = new ArrayList<>();
       try{
        String sql = "SELECT RecordId, Text FROM announcements WHERE UserGroupId=? AND Active=?";
        PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
        st.setInt(1, GroupId);
        st.setBoolean(2, true);
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            Annons tmp = new Annons();
            tmp.setId(rs.getInt("RecordId"));
            tmp.setGroupId(GroupId);
            tmp.setText(rs.getString("Text"));
            tmp.setActive(true);
            result.add(tmp);
        }
       }
         catch (Exception ex) {
            ex.printStackTrace();
        }
       return result;
   }
}
