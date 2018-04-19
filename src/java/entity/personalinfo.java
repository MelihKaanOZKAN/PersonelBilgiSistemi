/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author HakanBey
 */
public class personalinfo {

    private int PInfoId;
    private String EName;
    private String ESurname;
    private String SocialSecurityNumber;
    private String CitizensShipNumber;
    private adress Adress;
    private Date BirthDate;
    private communicationinfo Communication;
    private Boolean Gender;
    private int MaritalStatus;

    public personalinfo() {

    }

    public personalinfo(int PInfoId, String EName, String ESurname, String SocialSecurityNumber, String CitizensShipNumber, adress Adress, Date BirthDate, communicationinfo Communication, Boolean Gender, int MaritalStatus) {
        this.PInfoId = PInfoId;
        this.EName = EName;
        this.ESurname = ESurname;
        this.SocialSecurityNumber = SocialSecurityNumber;
        this.CitizensShipNumber = CitizensShipNumber;
        this.Adress = Adress;
        this.BirthDate = BirthDate;
        this.Communication = Communication;
        this.Gender = Gender;
        this.MaritalStatus = MaritalStatus;
    }

    public int getPInfoId() {
        return PInfoId;
    }

    public void setPInfoId(int PInfoId) {
        this.PInfoId = PInfoId;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getESurname() {
        return ESurname;
    }

    public void setESurname(String ESurname) {
        this.ESurname = ESurname;
    }

    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) {
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getCitizensShipNumber() {
        return CitizensShipNumber;
    }

    public void setCitizensShipNumber(String CitizensShipNumber) {
        this.CitizensShipNumber = CitizensShipNumber;
    }

    public adress getAdress() {
        if(Adress == null)
            Adress = new adress();
        return Adress;
    }

    public void setAdress(adress Adress) {
        this.Adress = Adress;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public communicationinfo getCommunication() {
        if(Communication == null)
            Communication = new communicationinfo();
        return Communication;
    }

    public void setCommunication(communicationinfo Communication) {
        this.Communication = Communication;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public int getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(int MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    @Override
    public String toString() {
        return "personalinfo{" + "PInfoId=" + PInfoId + ", EName=" + EName + ", ESurname=" + ESurname + ", SocialSecurityNumber=" + SocialSecurityNumber + ", CitizensShipNumber=" + CitizensShipNumber + ", Adress=" + Adress + ", BirthDate=" + BirthDate + ", Communication=" + Communication + ", Gender=" + Gender + ", MaritalStatus=" + MaritalStatus + '}';
    }
    
    
}
