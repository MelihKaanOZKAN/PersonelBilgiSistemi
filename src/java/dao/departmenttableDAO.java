/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.ConnectionClass;
import entity.departments;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aysun
 */
public class departmenttableDAO {
    
    public void addDepartment(departments depart)
    {
        try {
            
            ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement(" insert into departments (DepatmentName) values (?)");
            stm.setString(1, depart.getDepartmentName());
            
            stm.executeUpdate();
            stm.close();
            
            
        } catch (Exception e) {
        }

    }
    public void deleteDepartment(departments depart){
        try {ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement(" delete from deparmenttable where Deparmentld=?");
              stm.setInt(1, depart.getDeparmentId());
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
        }
    }
    
     public void UptadeDepartment(departments depart)
    {
        try {
            
            ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement("Update departments set DepartmentName= ? where Deparmentld = ?");
            stm.setString(1, depart.getDepartmentName());
            stm.setInt(2, depart.getDeparmentId());
            stm.executeUpdate();
            stm.close();
            
            
        } catch (Exception e) {
        }

    }
     public List<departments> getdepartments(){
         List<departments> clist= new ArrayList<>();
         try {
              ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement("select DepartmentId,DepartmentName from departments");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                departments depart = new departments();
                depart.setDeparmentId(rs.getInt("DepartmentId"));
                depart.setDepartmentName(rs.getString("DepartmentName"));
                clist.add(depart);
            }
            
             
         } catch (Exception e) {
         }
         return clist;
     }
}
