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
public class EmployeeInfo {
   private int EmployeeId;
   private JobInfo Job;
   private departments Department;
   private personalinfo pinfo;

    public EmployeeInfo() {
        Job = new JobInfo();
        Department = new departments();
        pinfo = new personalinfo();
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public JobInfo getJob() {
        return Job;
    }

    public void setJob(JobInfo Job) {
        this.Job = Job;
    }

    public departments getDepartment() {
        return Department;
    }

    public void setDepartment(departments Department) {
        this.Department = Department;
    }

    public personalinfo getPinfo() {
        return pinfo;
    }

    public void setPinfo(personalinfo pinfo) {
        this.pinfo = pinfo;
    }
   
}
