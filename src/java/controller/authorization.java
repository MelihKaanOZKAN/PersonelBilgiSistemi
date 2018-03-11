/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.LoginUserInfo;
import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@ManagedBean(name="auth")
@SessionScoped
public class authorization {

    public LoginUserInfo getInfo() {
        return info;
    }
   
   public LoginUserInfo info;    
   public ViewController view;
   
    public authorization(){
        info = new LoginUserInfo();
        view = new ViewController();
        info.username="";
        info.password="";
    }

   
    // if auth result isnt success, PersonInfo etc. wont defined.
    public String getAuthorized(){
        String result = "index";
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
                    stm = (PreparedStatement) connect.connection.prepareStatement("SELECT P.PermName, P.PermLink, PermVisual, PermSet FROM UserPerms UP  " 
                            + "INNER JOIN Perms P ON P.PermId = UP.PermissionId "
                            + "INNER JOIN Users U ON U.UserType=UP.UserTypeId AND U.PersonId=?");
                    stm.setInt(1, info.PersonInfoId);
                    info.UserPerms = stm.executeQuery();
                    result =  "Sablon";
                    view.view(info);
            }
        } catch (Exception ex)
        {
           ex.printStackTrace();
        }
        return result;
    }

    public ViewController getView() {
        return view;
    }

}
