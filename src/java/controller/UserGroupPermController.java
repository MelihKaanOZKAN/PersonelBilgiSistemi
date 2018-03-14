/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    Perms current = null;
    List<Perms> UserGroupList;
    List<Perms> PermList;
    AdminPanel_UserGroupPerms UserGroupPermDao = new AdminPanel_UserGroupPerms();
    Perms_PermGroup selectedGroup;
   
    public boolean isAddActive(Perms perm)
    {
        if(current == null)
        {
            return false;
        }
        else if (current.getPerm().PermId == perm.getPerm().PermId)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isSelectActive()
    {
        if(current == null)
        {
            return true;
        }
        else{
            return false;
        }
    }
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

    public List<Perms> getUserGroupList(Perms_PermGroup grp) {
        selectedGroup = grp;
        UserGroupList = UserGroupPermDao.getGroupPerms(selectedGroup.getGroupId());
        return UserGroupList;
    }

    public void setUserGroupList(List<Perms> UserGroupList) {
        this.UserGroupList = UserGroupList;
    }
    
    public void setPermtoGroup()
    {
        UserGroupPermDao.addPerm2Group(current, selectedGroup);
        current=null;
        PermList = null;
    }
    public void deletePermFromGroup(Perms perm)
    {
        UserGroupPermDao.deletePermFromGroup(perm, selectedGroup);
    }
    
   
}
