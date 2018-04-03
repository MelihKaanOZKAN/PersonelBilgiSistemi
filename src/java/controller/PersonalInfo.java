/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author Casper
 */
public class PersonalInfo {
    
    public void addEducationInfo (int PersonId, String GraduationDate, int EducationType, String InstitutionName, String GraduationType){
           
        try{
                 ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.
            prepareStatement("INSERT INTO EducationInfo VALUES(?,?,?,?,?)");
            stm.setInt(1, PersonId);
            stm.setString(2, GraduationDate);
            stm.setInt(3, EducationType);
            stm.setString(4, InstitutionName);
            stm.setString(5, GraduationType);
            stm.executeUpdate();
        }
           catch(Exception Ex)
        {
          Ex.printStackTrace();
        }
    }
    
    public void updateEducationInfo(int EducationId, String GraduationDate, int EducationType, String InstitutionName, String GraduationType){
           
        try{
                 ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.
            prepareStatement("UPDATE EducationInfo SET 	GraduatiomDate=?, EducationType=?, InstitutionName=?, GraduationType=? WHERE EducationId=?");
            stm.setString(1, GraduationDate);
            stm.setInt(2, EducationType);
            stm.setString(3, InstitutionName);
            stm.setString(4, GraduationType);
            stm.setInt(5, EducationId);
            stm.executeUpdate();
        }
           catch(Exception Ex)
        {
          Ex.printStackTrace();
        }
    }
}
