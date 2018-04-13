/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "authUserInfo")
@SessionScoped
public class LoginUserInfo {

    private boolean authStatus = false;
    private User user;

    private String getLink(Perms p,  String Context)
    {
        return Context+"/faces" +p.perm.getPermLink();
    }
    public boolean hasPerm(String url, String Context) {
        boolean result = false;
        for (int i = 0; i < user.getUserType().getGroupPerms(false).size(); i++) {
            String permLink = this.getLink(user.getUserType().getGroupPerms(false).get(i), Context);
                    
            if (url.equals(permLink)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public LoginUserInfo() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }

}
