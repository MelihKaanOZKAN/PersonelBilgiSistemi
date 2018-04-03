/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Casper
 */
public class User_PermitTypes {
    String PermitName;
    int PermitTypeId;

    public int getPermitTypeId() {
        return PermitTypeId;
    }

    public void setPermitTypeId(int PermitTypeId) {
        this.PermitTypeId = PermitTypeId;
    }
    

    public String getPermitName() {
        return PermitName;
    }

    public void setPermitName(String PermitName) {
        this.PermitName = PermitName;
    }
    
}
