/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.LoginUserInfo;
import entity.Perms;
import entity.Perms_Perm;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class authUserPerms {

    public List<Perms> getUserPerms(LoginUserInfo info) {
        List<Perms> result = new ArrayList<>();
        try {
            ConnectionClass connect = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connect.connection.prepareStatement("SELECT P.PermId, P.PermName, P.PermLink, PermVisual, PermSet FROM UserPerms UP  "
                    + "INNER JOIN Perms P ON P.PermId = UP.PermissionId "
                    + "INNER JOIN Users U ON U.UserType=UP.UserTypeId AND U.PersonId=?");
            stm.setInt(1, info.PersonInfoId);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Perms_Perm perm = new Perms_Perm();
                perm.setPermId(rs.getInt(1));
                perm.setPermName(rs.getString(2));
                perm.setPermLink(rs.getString(3));
                Perms p = new Perms();
                p.setPerm(perm);
                p.setPermVisual(rs.getBoolean(4));
                p.setPermSet(rs.getBoolean(5));
                result.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
