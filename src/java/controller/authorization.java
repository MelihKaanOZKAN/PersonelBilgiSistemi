/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.Authoration;
import entity.LoginUserInfo;
import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@ManagedBean(name="auth")
@SessionScoped
public class authorization implements Serializable {

    public LoginUserInfo getInfo() {
        return info;
    }
   
   private LoginUserInfo info;    
   private boolean WrongPass=false;
   private Authoration auth = new Authoration();
    public authorization(){
        info = new LoginUserInfo();
    }
    
   
    // if auth result isnt success, PersonInfo etc. wont defined.
    public String getAuthorized(){
        String result = "index";
        info = auth.getAuthorize(info);
        if(info.isAuthStatus())
        {
            result = "main";
        }
        else {
                WrongPass=!info.isAuthStatus();
             }
                
        return result;
    }
    public String Logout()
    {
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         info = new LoginUserInfo();
         return  "/index?faces-redirect=true";
    }
    public boolean isWrongPass() {
        return WrongPass;
    }

}
