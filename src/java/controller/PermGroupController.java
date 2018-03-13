/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AdminPanel_PermGroup;
import entity.Perms_PermGroup;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Casper
 */
@ManagedBean(name="AdminPage_UserGroups")
@SessionScoped
public class PermGroupController implements Serializable {
    Perms_PermGroup current = new Perms_PermGroup();
    List<Perms_PermGroup> UserGroupList;
    AdminPanel_PermGroup UserGroupDao = new AdminPanel_PermGroup();
    
    public Perms_PermGroup getCurrent() {
        return current;
    }

    public String ChangeGroupPerms(Perms_PermGroup selected)
    {
        current = selected;
        return "/AdminPanel/UserGroupPerms.xhtml";
    }
    public void setCurrent(Perms_PermGroup current) {
        this.current = current;
    }

    public List<Perms_PermGroup> getPermGroupList() {
        UserGroupList = UserGroupDao.getGroupList();
        return UserGroupList;
    }

    public void setPermGroupList(List<Perms_PermGroup> PermGroupList) {
        this.UserGroupList = UserGroupList;
    }
    
     public void UpdateGroup()
    {
        if(current.getGroupId() != 0)
        {
            UserGroupDao.UpdateGroup(current);
        }
        else{
            UserGroupDao.AddGroup(current);
        }
        current = new Perms_PermGroup();
    }
    public void DeleteGroup()
    {
       UserGroupDao.DeleteGroup(current);
        current = new Perms_PermGroup();
    }
    
}
