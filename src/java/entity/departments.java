/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Aysun
 */
public class departments { 
    private int  DeparmentId;
    private String DepartmentName;

    public departments() {
    }

    public departments(int DeparmentId, String DepartmentName) {
        this.DeparmentId = DeparmentId;
        this.DepartmentName = DepartmentName;
    }

    public int getDeparmentId() {
        return DeparmentId;
    }

    public void setDeparmentId(int DeparmentId) {
        this.DeparmentId = DeparmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
    
}
