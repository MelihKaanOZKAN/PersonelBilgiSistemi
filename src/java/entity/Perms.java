/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Casper
 */
public class Perms {
    Perms_Perm perm ;
    boolean permVisual, permSet;
    public Perms_Perm getPerm() {
        return perm;
    }

    public void setPerm(Perms_Perm perm) {
        this.perm = perm;
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
