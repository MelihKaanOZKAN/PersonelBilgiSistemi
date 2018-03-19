/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Casper
 */
public class UserGroup {
    private int GroupId;
   private String GroupName;
    private List<Perms> GroupPerms;

    public List<Perms> getGroupPerms() {
        return GroupPerms;
    }

    public void setGroupPerms(List<Perms> GroupPerms) {
        this.GroupPerms = GroupPerms;
    }

  
    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int GroupId) {
        this.GroupId = GroupId;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }
   
}
