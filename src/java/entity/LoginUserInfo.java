/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Syste
 */
@ManagedBean(name="authUserInfo")
@SessionScoped
public class LoginUserInfo {
     public boolean authStatus = false;
    public int PersonInfoId;
    public int UserType;
    public int UserId;
    public List<Perms> UserPerms;
    public String username, password, Name, Surname, CitizenNumber;

    public String getCitizenNumber() {
        return CitizenNumber;
    }

    public void setCitizenNumber(String CitizenNumber) {
        this.CitizenNumber = CitizenNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    
    public boolean isAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }

    public int getPersonInfoId() {
        return PersonInfoId;
    }

    public void setPersonInfoId(int PersonInfoId) {
        this.PersonInfoId = PersonInfoId;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public List<Perms> getUserPerms() {
        return UserPerms;
    }

    public void setUserPerms(List<Perms> UserPerms) {
        this.UserPerms = UserPerms;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
