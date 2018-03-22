/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Authoration;
import entity.LoginUserInfo;
import entity.Perms;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
    public boolean isAuthorized2Visual(String ScreenCode)
    {
        boolean result = false;
        List<Perms> tmp = info.getUser().getUserType().getGroupPerms();
        for(int i = 0; i < tmp.size(); i++)
        {
            if(tmp.get(i).getPerm().ScreenCode.equalsIgnoreCase(ScreenCode))
            {
                result= tmp.get(i).isPermVisual();
            }
        }
       return result;  
    }
    public boolean isAuthorized2Set(String ScreenCode)
    {
        boolean result = false;
        List<Perms> tmp = info.getUser().getUserType().getGroupPerms();
        for(int i = 0; i < tmp.size(); i++)
        {
            if(tmp.get(i).getPerm().ScreenCode.equalsIgnoreCase(ScreenCode))
            {
                result= tmp.get(i).isPermSet();
            }
        }
       return result;  
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
    public String getCurrentRowStyle(String current)
    {
        String viewId = ((HttpServletRequest) FacesContext.getCurrentInstance() 
 .getExternalContext().getRequest()).getRequestURI(); 
        String tmp[] = viewId.split("/");
        current =   "/" + tmp[1] + "/" + tmp[2] + current +".xhtml";
        /*System.out.println(current +"-" + viewId);
        System.out.println(current.equalsIgnoreCase(viewId));*/
        if(current.equalsIgnoreCase(viewId))
        {
            return  "background-color:#9999ff";
        }
        else{
              return "";
        }
    }
}
