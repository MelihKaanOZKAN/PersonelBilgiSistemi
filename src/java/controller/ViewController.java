/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.LoginUserInfo;
import entity.Perms;
import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.Perms_Perm;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Casper
 */
@ManagedBean(name = "viewController")
@SessionScoped
public class ViewController {

    LinkedList<Perms> perm;

    public LinkedList<Perms> getPerms() {
        return perm;
    }

   
    public ViewController() {
        perm = new LinkedList<Perms>();
    }

    public void view(LoginUserInfo user) {
        try {
            perm.clear();
            while (user.UserPerms.next()) {
                Perms perm1 = new Perms(); 
                perm1.setPerm(new Perms_Perm());
                perm1.getPerm().setPermName(user.UserPerms.getString("PermName"));
                perm1.getPerm().setPermLink(user.UserPerms.getString("PermLink"));
                perm1.setPermVisual(user.UserPerms.getBoolean("PermVisual"));
                perm1.setPermSet(user.UserPerms.getBoolean("PermSet"));
                perm.add(perm1);
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
