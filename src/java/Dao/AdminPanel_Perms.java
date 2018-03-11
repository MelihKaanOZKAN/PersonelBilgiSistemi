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
     
     public List<Perms_Perm> getPermList(){
         List<Perms_Perm> result = new ArrayList<Perms_Perm>();
         try{
             String sql = "SELECT PermId, PermName , PermLink FROM Perms";
             PreparedStatement st = (PreparedStatement) connect.connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next())
             {
               Perms_Perm tmp = new Perms_Perm();
               tmp.setPermId(rs.getInt(1));
               tmp.setPermName(rs.getString(2));
               tmp.setPermLink(rs.getString(3));
               result.add(tmp);
             }
             
         }catch (Exception ex)
        {
           ex.printStackTrace();
        }
         return result;
     }
}
