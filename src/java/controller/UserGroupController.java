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
import util.Pagination;

/**
 *
 * @author Casper
 */
@ManagedBean(name="AdminPage_UserGroups")
@SessionScoped
public class UserGroupController implements Serializable {
   private UserGroup current = new UserGroup();
   private List<UserGroup> UserGroupList;
   private AdminPanel_UserGroup UserGroupDao = new AdminPanel_UserGroup();
   private UserGroup currentGroup4Perm = new UserGroup();
    private String ScreenCode = "AKG";
    private Pagination pagination = new Pagination();

    public Pagination getPagination() {
        
        return pagination;
    }
    
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
        return "/AdminPanel/UserGroupPerms.xhtml?faces-redirect=true";
    }
    public String UsersAddDelete(UserGroup selected)
    {
        currentGroup4Perm = selected;
        return "/AdminPanel/Users.xhtml?faces-redirect=true";
    }
    public void setCurrent(UserGroup current) {
        this.current = current;
    }

    public List<UserGroup> getPermGroupList() {
        pagination.setRowCount(UserGroupDao.getCount());
        pagination.setRowLimit(2);
        UserGroupList = UserGroupDao.getGroupList(pagination);
        return UserGroupList;
    }

    public void setPermGroupList(List<UserGroup> PermGroupList) {
        this.UserGroupList = PermGroupList;
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
