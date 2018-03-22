/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AdminPanel_Perms;
import entity.Perms_Perm;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "AdminPage_Perms")
@SessionScoped
public class PermController implements Serializable {

    private Perms_Perm currentPerm = new Perms_Perm();
    private List<Perms_Perm> permList;
    private AdminPanel_Perms permDao = new AdminPanel_Perms();
    private String ScreenCode = "AYI";

    public String getScreenCode() {
        return ScreenCode;
    }

    public void setScreenCode(String ScreenCode) {
        this.ScreenCode = ScreenCode;
    }

    public List<Perms_Perm> getPermList() {
        permList = permDao.getPermList();
        return permList;
    }

    public Perms_Perm getCurrentPerm() {
        return currentPerm;
    }

    public void setCurrentPerm(Perms_Perm currentPerm) {
        this.currentPerm = currentPerm;
    }

    public void UpdatePerm() {
        if (currentPerm.PermId != 0) {
            permDao.UpdatePerm(currentPerm);
        } else {
            permDao.AddPerm(currentPerm);
        }
        currentPerm = new Perms_Perm();
    }

    public void DeletePerm() {
        permDao.DeletePerm(currentPerm);
        currentPerm = new Perms_Perm();
    }
}
