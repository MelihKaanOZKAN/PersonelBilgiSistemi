/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.LoginUserInfo;
import java.sql.ResultSet;

/**
 *
 * @author Casper
 */
public class Authoration {
    
    authUserPerms permDao = new authUserPerms();
    public LoginUserInfo getAuthorize(LoginUserInfo info){

          try{
             ConnectionClass connect = new ConnectionClass();
            PreparedStatement  stm = (PreparedStatement) connect.connection.prepareStatement("SELECT UserType, UserId, PersonId, EName, ESurname, CitizensShipNumber FROM Users U "
                    + "inner join PErsonalInfo PI on PI.PInfoId = U.PersonId "
                    + " WHERE Username=? AND Password=?");
            stm.setString(1,info.username);
            stm.setString(2,info.password);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                    stm.clearParameters();
                    info.authStatus = true;
                    info.UserType = rs.getInt(1);
                    info.UserId = rs.getInt(2);
                    info.PersonInfoId = rs.getInt(3);
                    info.Name = rs.getString(4);
                    info.Surname = rs.getString(5);
                    info.CitizenNumber = rs.getString(6);
                    info.setUserPerms(permDao.getUserPerms(info));
            }
        } catch (Exception ex)
        {
           ex.printStackTrace();
        }
        
        return info;
    }
}
