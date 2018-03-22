/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Users;
import entity.User;
import entity.changePass;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Casper
 */
@ManagedBean(name = "UserChangePass")
@SessionScoped
public class LoginUserUpdateController {

    private Users userDao = new Users();
    private boolean wrongPass = false;
    private changePass newPass = new changePass();
    private User oldPass = new User();
    private String ScreenCode = "UPC";
    private String Message;

    public String getMessage() {
        return Message;
    }

    public User getOldPass() {
        return oldPass;
    }

    public void setOldPass(User oldPass) {
        this.oldPass = oldPass;
    }

    public String getScreenCode() {
        return ScreenCode;
    }

    public void setScreenCode(String ScreenCode) {
        this.ScreenCode = ScreenCode;
    }

    public boolean isWrongPass() {
        return wrongPass;
    }

    public void setWrongPass(boolean wrongPass) {
        this.wrongPass = wrongPass;
    }

    public changePass getNewPass() {
        return newPass;
    }

    public void setNewPass(changePass newPass) {
        this.newPass = newPass;
    }

    public void updatePassword(User user) {
        if (newPass.getNewPass1().equals(newPass.getNewPass2())) {
            if (user.getPassword().equalsIgnoreCase(oldPass.getPassword())) {
                user.setPassword(newPass.getNewPass1());
                userDao.updateUser(user);
                wrongPass = false;
            } else {
                Message = "Eski Parola Yanlış";
                wrongPass = true;
            }
            newPass = new changePass();
        } else {
            Message = "Yeni Parolalar Aynı Değil";
            wrongPass = true;
        }
    }
}
