/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AdminPanel_UserGroupPerms;
import entity.Perms;
import entity.UserGroup;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Pagination;

/**
 *
 * @author Casper
 */
@ManagedBean(name="AdminPage_UserGroupPerms")
@SessionScoped
public class UserGroupPermController implements Serializable {
   private Perms current = null;
   private List<UserGroup> UserGroupList;
   private List<Perms> PermList;
   private AdminPanel_UserGroupPerms UserGroupPermDao = new AdminPanel_UserGroupPerms();
   private UserGroup selectedGroup;
   private Pagination pagePermList = new Pagination();
   private Pagination pageGroupPerm = new Pagination();
   private String ScreenCode = "APGPerms";

    public String getScreenCode() {
        return ScreenCode;
    }
   
    public Pagination getPagePermList() {
        return pagePermList;
    }

    public void setPagePermList(Pagination pagePermList) {
        this.pagePermList = pagePermList;
    }

    public Pagination getPageGroupPerm() {
        return pageGroupPerm;
    }

    public void setPageGroupPerm(Pagination pageGroupPerm) {
        this.pageGroupPerm = pageGroupPerm;
    }
   
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
    public UserGroup getSelectedGroup() {
        this.pageGroupPerm.setRowCount(UserGroupPermDao.getCountGroupPerms(selectedGroup));
        this.pageGroupPerm.setRowLimit(2);
        
        selectedGroup = UserGroupPermDao.getGroupPerms(selectedGroup, this.pageGroupPerm);
        return selectedGroup;
    }

    public List<Perms> getPermList() {
        return PermList;
    }

    public void setPermList(List<Perms> PermList) {
        this.PermList = PermList;
    }


    public void setSelectedGroup(UserGroup selectedGroup) {
        
        this.selectedGroup = selectedGroup;
    }

    public Perms getCurrent() {
        return current;
    }
    
    public List<Perms> getPermList(UserGroup grp) {
        selectedGroup = grp;
        this.pagePermList.setRowCount(UserGroupPermDao.getCountPermList(grp));
        this.pagePermList.setRowLimit(2);
        PermList = UserGroupPermDao.getPermList(selectedGroup, this.pagePermList);
        return PermList;
    }

    
    public void setCurrent(Perms current) {
        this.current = current;
    }

    public void setPermtoGroup()
    {
        UserGroupPermDao.addPerm2Group(current, selectedGroup);
        this.pageGroupPerm.setRowCount(UserGroupPermDao.getCountGroupPerms(selectedGroup));
        this.pageGroupPerm.setRowLimit(2);
        selectedGroup = UserGroupPermDao.getGroupPerms(selectedGroup, this.pageGroupPerm);
        current=null;
        PermList = null;
    }
    public void deletePermFromGroup(Perms perm)
    {
        UserGroupPermDao.deletePermFromGroup(perm, selectedGroup);
         this.pageGroupPerm.setRowCount(UserGroupPermDao.getCountGroupPerms(selectedGroup));
        this.pageGroupPerm.setRowLimit(2);
        selectedGroup = UserGroupPermDao.getGroupPerms(selectedGroup, this.pageGroupPerm);
    }
    
   
}
