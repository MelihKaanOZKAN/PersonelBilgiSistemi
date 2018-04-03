/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Casper
 */
    @ManagedBean(name="City")
    @SessionScoped
    public class City{
        public String SelectedCity="";

        public String getSelectedCity() {
            return SelectedCity;
        }

        public void setSelectedCity(String SelectedCity) {
            this.SelectedCity = SelectedCity;
        }
        
        public List<SelectItem> getCitys(){
            List<SelectItem> result = new ArrayList<SelectItem>();
            try{
             ConnectionClass connect = new ConnectionClass();
            PreparedStatement  stm = (PreparedStatement) connect.connection.prepareStatement("SELECT CityName FROM CityTable order by Cityname ASC");
            ResultSet rs = stm.executeQuery();
            while(rs.next())
                {
                   result.add(new SelectItem(rs.getString("CityName")));
                }
            }
            catch(Exception err)
            {
                err.printStackTrace();
            }
            return result;
        }
        
        public String SelectedDistrict;

        public String getSelectedDistrict() {
            return SelectedDistrict;
        }

        public void setSelectedDistrict(String SelectedDistrict) {
            this.SelectedDistrict = SelectedDistrict;
        }
        public List<SelectItem> getDistricts(){
            List<SelectItem> result = new ArrayList<SelectItem>();
            try{
                System.out.println("TEST S:" + SelectedCity);
             ConnectionClass connect = new ConnectionClass();
             if (SelectedCity != ""){
                  PreparedStatement  stm = (PreparedStatement) connect.connection.prepareStatement("SELECT DistrictName FROM DistrictTable DT"
                          + " INNER JOIN CityTable ct ON ct.CityName=? WHERE DT.City=ct.CityId   order by Districtname ASC");
                  ResultSet rs = stm.executeQuery();
                    while(rs.next())
                        {
                           result.add(new SelectItem(rs.getString("DistrictName")));
                        }
                     }
           
            }
            catch(Exception err)
            {
                err.printStackTrace();
            }
            return result;
        }
        
    }
