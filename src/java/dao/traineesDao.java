/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.EmployeeInfo;
import entity.JobInfo;
import entity.Trainees;
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
    public void acceptTrainee(EmployeeInfo person, trainingInfo selectedTraining){
        try {
            String sql = "UPDATE trainees SET AppConfirm=1 WHERE TrainingID=? AND PersonId=?";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
                s.setInt(1, selectedTraining.getTrainingId());
                s.setInt(2, person.getPinfo().getPInfoId());
                s.executeUpdate();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 public void addTrainees(List<Integer> Persons, trainingInfo selectedTraining, Boolean AppConfirm) {
        try {
            String sql = "INSERT INTO trainees (TrainingID, PersonId, AppConfirm) VALUES (?,?,?)";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            for (int i = 0; i < Persons.size(); i++) {
                s.setInt(1, selectedTraining.getTrainingId());
                s.setInt(2, Persons.get(i));
                s.setBoolean(3, AppConfirm);
                s.executeUpdate();
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addTrainee(Trainees tr) {
        try {
            String sql = "INSERT INTO trainees (TrainingID, PersonId, AppConfirm) VALUES (?,?,?)";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
                s.setInt(1, tr.getTraininginfo().getTrainingId());
                s.setInt(2, tr.getPersonInfo().getPinfo().getPInfoId());
                s.setBoolean(3, tr.isAppConfirm());
                s.executeUpdate();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Trainees> selectedPersons(trainingInfo info) {
        List<Trainees> result = new ArrayList<>();

        try {
            String sql = "select InfoId, P.EName, P.ESurname, d.DepartmentId, d.DepartmentName, j.JobId, j.JobName, t.AppConfirm  FROM employeeinfo e "
                    + "inner join personalinfo P on P.PInfoId=e.InfoId "
                    + "inner join trainees t on t.PersonId = P.PInfoId "
                    + "inner join departments d on d.DepartmentId = e.Department "
                    + "inner join jobs j on j.JobId = e.JobId "
                    + "where t.TrainingID = ? "
                    + "group by t.AppConfirm ASC";
            PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            s.setInt(1, info.getTrainingId());
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                Trainees T = new Trainees();
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
                T.setPersonInfo(E);
                T.setAppConfirm(rs.getBoolean(8));
                result.add(T);
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

    public List<Trainees> getTrainings(EmployeeInfo info)
    {
        List<Trainees> result = new ArrayList<>();
        try{
            String sql ="select TI.TraningId, TI.TrainingName, TI.TrainingInfo, TI.BeginDate, TI.EndDate, TI.ExamDate, TR.participateTraining, TR.participateExam, TR.passExam, TR.ExamMark, TR.AppConfirm from trainees TR " +
"inner join TrainingInfo TI on TI.TraningId=TR.TrainingID " +
"where TR.PersonId=?";
            
             PreparedStatement s = (PreparedStatement) con.connection.prepareStatement(sql);
            s.setInt(1, info.getPinfo().getPInfoId());
            ResultSet rs = s.executeQuery();

            while(rs.next())
            {
                Trainees tr = new Trainees();
                tr.setPersonInfo(info);
                tr.getTraininginfo().setTrainingId(rs.getInt(1));
                tr.getTraininginfo().setTrainingName(rs.getString(2));
                tr.getTraininginfo().setTrainingInfo(rs.getString(3));
                tr.getTraininginfo().setBeginDate(rs.getDate(4));
                tr.getTraininginfo().setEndDate(rs.getDate(5));
                tr.getTraininginfo().setExamDate(rs.getDate(6));
                tr.setParticipateTraining(rs.getBoolean(7));
                tr.setParticipateTraining(rs.getBoolean(8));
                tr.setPassExam(rs.getBoolean(9));
                tr.setExamMark(rs.getInt(10));
                tr.setAppConfirm(rs.getBoolean(11));
                result.add(tr);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return result;
    }
    
    
}
