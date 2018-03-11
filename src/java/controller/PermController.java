/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Dao.AdminPanel_Perms;
import entity.Perms_Perm;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Syste
 */
@ManagedBean(name="AdminPage_Perms")
@SessionScoped
public class PermController {
    Perms_Perm currentPerm;
    List<Perms_Perm> permList;
    AdminPanel_Perms permDao = new AdminPanel_Perms();
    
    public List<Perms_Perm> getPermList() {
        permList = permDao.getPermList();
        return permList;
    }
    public Perms_Perm getCurrentPerm() {
        return currentPerm;
    }

    public void setCurrentPerm(Perms_Perm currentPerm) {
        this.currentPerm = currentPerm;
        System.out.println(currentPerm.PermId);
    }
    
    
}