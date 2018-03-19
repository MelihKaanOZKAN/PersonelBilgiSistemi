/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Syste
 */
public class Perms_Perm {
    public String permName, PermLink, ScreenCode;

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

    public void setPermLink(String PermLink) {
        this.PermLink = PermLink;
    }
}
