/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AdminPanel_PermGroup;
import Dao.AdminPanel_UserGroupPerms;
import entity.Perms;
import entity.Perms_PermGroup;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Casper
 */
@ManagedBean(name="AdminPage_UserGroupPerms")
@SessionScoped
public class UserGroupPermController implements Serializable {
    Perms current = new Perms();
    List<Perms> UserGroupList;
    List<Perms> PermList;
    AdminPanel_UserGroupPerms UserGroupPermDao = new AdminPanel_UserGroupPerms();
    Perms_PermGroup selectedGroup;

    public Perms_PermGroup getSelectedGroup() {
        return selectedGroup;
    }


    public void setSelectedGroup(Perms_PermGroup selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public Perms getCurrent() {
        return current;
    }
    
    public List<Perms> getPermList(Perms_PermGroup grp) {
        selectedGroup = grp;
        PermList = UserGroupPermDao.getPermList(selectedGroup.getGroupId());
        return PermList;
    }

    public void setPermList(List<Perms> PermList) {
        this.PermList = PermList;
    }

    public void setCurrent(Perms current) {
        this.current = current;
    }

    public List<Perms> getUserGroupList() {
        return UserGroupList;
    }

    public void setUserGroupList(List<Perms> UserGroupList) {
        this.UserGroupList = UserGroupList;
    }
    
    
}
