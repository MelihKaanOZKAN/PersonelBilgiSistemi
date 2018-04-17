/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import dao.Users;
import dao.personalinfoDao;
import entity.User;
import entity.UserGroup;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Pagination;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "AdminPage_Users")
@SessionScoped
public class UserController {

    private UserGroup selectedGroup;
    private List<User> userList;
    private User selectedUser;
    private Users userDao = new Users();
    private personalinfoDao PinfoDao = new personalinfoDao();
    private Pagination page = new Pagination();
    private boolean isErrorActive;

    public boolean isIsErrorActive() {
        return isErrorActive;
    }
    
    public Pagination getPage() {
        return page;
    }
    
    private boolean buttonsActive = false;

    public boolean isButtonsActive() {
        return buttonsActive;
    }

    public UserController() {
        selectedGroup = new UserGroup();
        selectedUser = new User();
    }

    public UserGroup getSelectedGroup() {
        return selectedGroup;
    }

    public void findUser() {
        selectedUser.setuserinfo(PinfoDao.getPersonalInfobyCTNumber(selectedUser.getuserinfo()));
    }

    public void setSelectedGroup(UserGroup selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<User> getUserList(UserGroup selectedGroup) {
        this.setSelectedGroup(selectedGroup);
        page.setRowCount(userDao.getCount(selectedGroup));
        page.setRowLimit(2);
        userList = userDao.getUserList(selectedGroup, page);
        return userList;
    }

    public void addUpdate() {
        if (!("".equals(selectedUser.getuserinfo().getEName()))) {
            if (selectedUser.getUserId() == 0) {
                    this.isErrorActive = !userDao.addUser(selectedUser);
            } else {
                userDao.updateUser(selectedUser);
                
            }
            if(!this.isErrorActive)
            {
             selectedUser = new User();
            }
        }
    }

    public void deleteUser() {
        userDao.deleteUser(selectedUser);
        selectedUser = new User();
    }

    public User getSelectedUser() {
        selectedUser.setUserType(selectedGroup);
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public boolean isButtonsactive() {
        return selectedUser.getuserinfo().getEName().equals("");
    }
    public void clearForm(){
        selectedUser = new User();
    }
}
