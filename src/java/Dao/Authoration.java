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
            stm.setString(1,info.getUser().getUserName());
            stm.setString(2,info.getUser().getPassword());
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                    stm.clearParameters();
                    info.setAuthStatus(true);
                    info.getUser().getUserType().setGroupId(rs.getInt(1));
                    info.getUser().setUserId(rs.getInt(2));
                    info.getUser().getuserinfo().setPInfoId(rs.getInt(2));
                    info.getUser().getuserinfo().setEName(rs.getString(4));
                    info.getUser().getuserinfo().setESurname(rs.getString(5));
                    info.getUser().getuserinfo().setCitizensShipNumber(rs.getString(6));
                    info.getUser().getUserType().setGroupPerms(permDao.getUserPerms(info));
            }
        } catch (Exception ex)
        {
           ex.printStackTrace();
        }
        
        return info;
    }
}
