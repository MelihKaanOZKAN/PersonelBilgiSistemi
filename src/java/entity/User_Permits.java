/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.User_PermitTypes;
import java.sql.Date;



public class User_Permits {
String PermitComment;
int PermitId;
personalinfo person;
User_PermitTypes PermitType;
Date date;
boolean gorunurluk;
		
	public boolean isGorunurluk() {
		return gorunurluk;
	}
	public void setGorunurluk(boolean gorunurluk) {
		this.gorunurluk = gorunurluk;
	}


    public String getPermitComment() {
        return PermitComment;
    }

    public void setPermitComment(String PermitComment) {
        this.PermitComment = PermitComment;
    }

    public int getPermitId() {
        return PermitId;
    }

    public void setPermitId(int PermitId) {
        this.PermitId = PermitId;
    }

    public personalinfo getPerson() {
        return person;
    }

    public void setPerson(personalinfo person) {
        this.person = person;
    }


    public User_PermitTypes getPermitType() {
        return PermitType;
    }

    public void setPermitType(User_PermitTypes PermitType) {
        this.PermitType = PermitType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
  
 

    
    
}


