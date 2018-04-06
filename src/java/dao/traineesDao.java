/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.EmployeeInfo;
import entity.JobInfo;
import entity.departments;
import entity.personalinfo;
import entity.trainingInfo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;

/**
 *
 * @author Syste
 */
public class traineesDao {

    ConnectionClass con = new ConnectionClass();

    public void removeTrainee(EmployeeInfo person, trainingInfo selectedTraining) {
        try {
            String sql = "DELETE FROM trainees WHERE TrainingID=? AND PersonId=?";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
                s.setInt(1, selectedTraining.getTrainingId());
                s.setInt(2, person.getPinfo().getPInfoId());
                s.executeUpdate();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addTrainees(List<Integer> Persons, trainingInfo selectedTraining) {
        try {
            String sql = "INSERT INTO trainees (TrainingID, PersonId, AppConfirm) VALUES (?,?,1)";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            for (int i = 0; i < Persons.size(); i++) {
                s.setInt(1, selectedTraining.getTrainingId());
                s.setInt(2, Persons.get(i));
                s.executeUpdate();
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<EmployeeInfo> selectedPersons(trainingInfo info) {
        List<EmployeeInfo> result = new ArrayList<>();

        try {
            String sql = "select InfoId, P.EName, P.ESurname, d.DepartmentId, d.DepartmentName, j.JobId, j.JobName  FROM employeeinfo e "
                    + "inner join personalinfo P on P.PInfoId=e.InfoId "
                    + "inner join trainees t on t.PersonId = P.PInfoId "
                    + "inner join departments d on d.DepartmentId = e.Department "
                    + "inner join jobs j on j.JobId = e.JobId "
                    + "where t.TrainingID = ? ";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            s.setInt(1, info.getTrainingId());
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                EmployeeInfo E = new EmployeeInfo();
                personalinfo tmp = new personalinfo();
                tmp.setPInfoId(rs.getInt(1));
                tmp.setEName(rs.getString(2));
                tmp.setESurname(rs.getString(3));
                E.setPinfo(tmp);
                departments d = new departments();
                d.setDeparmentId(rs.getInt(4));
                d.setDepartmentName(rs.getString(5));
                E.setDepartment(d);
                JobInfo j = new JobInfo();
                j.setJobId(rs.getInt(6));
                j.setJobName(rs.getString(7));
                E.setJob(j);
                result.add(E);
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<EmployeeInfo> PersonList(departments info) {
        List<EmployeeInfo> result = new ArrayList<>();

        try {
            String sql = "select InfoId, P.EName, P.ESurname, d.DepartmentId, d.DepartmentName, j.JobId, j.JobName  FROM employeeinfo e "
                    + "inner join personalinfo P on P.PInfoId=e.InfoId "
                    + "left join trainees t on t.PersonId = P.PInfoId "
                    + "inner join departments d on d.DepartmentId = e.Department and d.DepartmentId = ? "
                    + "inner join jobs j on j.JobId = e.JobId "
                    + "where t.TrainingID is null;";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            s.setInt(1, info.getDeparmentId());
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                EmployeeInfo E = new EmployeeInfo();
                personalinfo tmp = new personalinfo();
                tmp.setPInfoId(rs.getInt(1));
                tmp.setEName(rs.getString(2));
                tmp.setESurname(rs.getString(3));
                E.setPinfo(tmp);
                departments d = new departments();
                d.setDeparmentId(rs.getInt(4));
                d.setDepartmentName(rs.getString(5));
                E.setDepartment(d);
                JobInfo j = new JobInfo();
                j.setJobId(rs.getInt(6));
                j.setJobName(rs.getString(7));
                E.setJob(j);
                result.add(E);
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

}
