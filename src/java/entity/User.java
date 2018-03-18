/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Syste
 */
public class User {
    
   private int userId;
    private String userName;
    private String password;
    private UserGroup userType;
    private personalinfo userinfo;

    public User() {
        userType = new UserGroup();
        userinfo= new personalinfo();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGroup getUserType() {
        return userType;
    }

    public void setUserType(UserGroup userType) {
        this.userType = userType;
    }

    public personalinfo getuserinfo() {
        return userinfo;
    }

    public void setuserinfo(personalinfo userinfo) {
        this.userinfo = userinfo;
    }
    
}
