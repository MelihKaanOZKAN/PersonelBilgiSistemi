/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.faces.context.FacesContext;

/**
 *
 * @author Syste
 */
public class Perms_Perm {
    private String permName, PermLink, ScreenCode;
    private boolean ViewMenu;

    public boolean isViewMenu() {
        return ViewMenu;
    }

    public void setViewMenu(boolean ViewMenu) {
        this.ViewMenu = ViewMenu;
    }
    
    public String getScreenCode() {
        return ScreenCode;
    }

    public void setScreenCode(String ScreenCode) {
        this.ScreenCode = ScreenCode;
    }
    public int PermId;

    public int getPermId() {
        return PermId;
    }

    public void setPermId(int PermId) {
        this.PermId = PermId;
    }
    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermLink() {
        return PermLink;
    }
    public String Redirect() {
        return PermLink + "?faces-redirect=true";
    }
    public void setPermLink(String PermLink) {
        this.PermLink = PermLink;
    }
}
