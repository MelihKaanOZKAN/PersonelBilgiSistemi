/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AdminPanel_UserGroup;
import entity.UserGroup;
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
public class UserGroupController implements Serializable {
    UserGroup current = new UserGroup();
    List<UserGroup> UserGroupList;
    AdminPanel_UserGroup UserGroupDao = new AdminPanel_UserGroup();
    UserGroup currentGroup4Perm = new UserGroup();
    private String ScreenCode = "AKG";

    public String getScreenCode() {
        return ScreenCode;
    }

    public void setScreenCode(String ScreenCode) {
        this.ScreenCode = ScreenCode;
    }
    public UserGroup getCurrentGroup4Perm() {
        return currentGroup4Perm;
    }

    public void setCurrentGroup4Perm(UserGroup currentGroup4Perm) {
        this.currentGroup4Perm = currentGroup4Perm;
    }
    
    public UserGroup getCurrent() {
        return current;
    }

    public String ChangeGroupPerms(UserGroup selected)
    {
        currentGroup4Perm = selected;
        return "/AdminPanel/UserGroupPerms.xhtml";
    }
    public String UsersAddDelete(UserGroup selected)
    {
        currentGroup4Perm = selected;
        return "/AdminPanel/Users.xhtml";
    }
    public void setCurrent(UserGroup current) {
        this.current = current;
    }

    public List<UserGroup> getPermGroupList() {
        UserGroupList = UserGroupDao.getGroupList();
        return UserGroupList;
    }

    public void setPermGroupList(List<UserGroup> PermGroupList) {
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
        current = new UserGroup();
    }
    public void DeleteGroup()
    {
       UserGroupDao.DeleteGroup(current);
        current = new UserGroup();
    }
    
}
