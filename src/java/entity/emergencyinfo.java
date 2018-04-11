/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ozan
 */
public class emergencyinfo {
    private int RecordId;
    private int InfoId;
    private String NameSurname;
    private String Phone;

    public emergencyinfo() {
    }

    public emergencyinfo(int RecordId, int InfoId, String NameSurname, String Phone) {
        this.RecordId = RecordId;
        this.InfoId = InfoId;
        this.NameSurname = NameSurname;
        this.Phone = Phone;
    }

    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int RecordId) {
        this.RecordId = RecordId;
    }

    public int getInfoId() {
        return InfoId;
    }

    public void setInfoId(int InfoId) {
        this.InfoId = InfoId;
    }

    public String getNameSurname() {
        return NameSurname;
    }

    public void setNameSurname(String NameSurname) {
        this.NameSurname = NameSurname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "emergencyinfo{" + "RecordId=" + RecordId + ", InfoId=" + InfoId + ", NameSurname=" + NameSurname + ", Phone=" + Phone + '}';
    }
    
    
    
}