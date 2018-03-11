/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Casper
 */
public class Perms {
    String permName;
    String permLink;
    boolean permVisual, permSet;

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermLink() {
        return permLink;
    }
    public String redirectPermLink() {
           return permLink;
       }

    public void setPermLink(String permLink) {
        this.permLink = permLink;
    }

    public boolean isPermVisual() {
        return permVisual;
    }

    public void setPermVisual(boolean permVisual) {
        this.permVisual = permVisual;
    }

    public boolean isPermSet() {
        return permSet;
    }

    public void setPermSet(boolean permSet) {
        this.permSet = permSet;
    }
}
