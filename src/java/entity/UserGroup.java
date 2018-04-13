/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casper
 */
public class UserGroup {
    private int GroupId;
   private String GroupName;
    private List<Perms> GroupPerms;

    public List<Perms> getGroupPerms(boolean mode) {
        List<Perms> tmp = new ArrayList<>(GroupPerms);
        if(mode)
        {
            for(int i = 0; i < tmp.size(); i++)
            {
                if(!tmp.get(i).perm.isViewMenu())
                {
                    tmp.remove(i);
                }
            }
        }
        return tmp;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.GroupId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserGroup other = (UserGroup) obj;
        if (this.GroupId != other.GroupId) {
            return false;
        }
        return true;
    }
   
}
