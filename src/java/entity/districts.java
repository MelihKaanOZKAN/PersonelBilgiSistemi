/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HakanBey
 */
public class districts {

    private int DistId;
    private citys City;
    private String DistrictName;

    public districts() {
    }

    public districts(int DistId, citys City, String DistrictName) {
        this.DistId = DistId;
        this.City = City;
        this.DistrictName = DistrictName;
    }

    public int getDistId() {
        return DistId;
    }

    public void setDistId(int DistId) {
        this.DistId = DistId;
    }

    public citys getCity() {
        if (City == null) {
            City = new citys();
        }
        return City;
    }

    public void setCity(citys City) {
        this.City = City;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    @Override
    public String toString() {
        return "districts{" + "DistId=" + DistId + ", City=" + City + ", DistrictName=" + DistrictName + '}';
    }

}
