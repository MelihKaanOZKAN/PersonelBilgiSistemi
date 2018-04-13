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
public class Annons {
    private int Id;
    private UserGroup Group;
    private String Text;
    private boolean Active;

    public UserGroup getGroup() {
        if(Group == null)
            Group = new UserGroup();
        return Group;
    }

    public void setGroup(UserGroup Group) {
        this.Group = Group;
    }

    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
}
