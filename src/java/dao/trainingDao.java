/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import entity.trainingInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionClass;

/**
 *
 * @author Casper
 */
public class trainingDao {

    ConnectionClass connect = new ConnectionClass();

    public List<trainingInfo> getTrainingList() {
        List<trainingInfo> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trainingInfo";

            PreparedStatement pstm = (PreparedStatement) connect.connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                trainingInfo t = new trainingInfo();
                t.setTrainingId(rs.getInt("TraningId"));
                t.setTrainingName(rs.getString("TrainingName"));
                t.setTrainingInfo(rs.getString("TrainingInfo"));
                t.setBeginDate(rs.getDate("BeginDate"));
                t.setEndDate(rs.getDate("EndDate"));
                t.setExamDate(rs.getDate("ExamDate"));
                result.add(t);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return result;
    }

    public void Kaydet(trainingInfo kyt) {
        try {
            String sql = "INSERT INTO traininginfo (TrainingName, TrainingInfo, BeginDate, EndDate, ExamDate) values (?,?,?,?,?)";

            PreparedStatement p = (PreparedStatement) connect.connection.prepareStatement(sql);
            p.setString(1, kyt.getTrainingName());
            p.setString(2, kyt.getTrainingInfo());
            p.setDate(3, kyt.getBeginDate());
            p.setDate(4, kyt.getEndDate());
            p.setDate(5, kyt.getExamDate());
            p.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
    
    public void Guncelle(trainingInfo kyt) {
        try {
            String sql = "UPDATE  traininginfo SET TrainingName=?, TrainingInfo=?, BeginDate=?, EndDate=?, ExamDate=? WHERE TraningId=?";

            PreparedStatement p = (PreparedStatement) connect.connection.prepareStatement(sql);
            p.setString(1, kyt.getTrainingName());
            p.setString(2, kyt.getTrainingInfo());
            p.setDate(3, kyt.getBeginDate());
            p.setDate(4, kyt.getEndDate());
            p.setDate(5, kyt.getExamDate());
            p.setInt(6,kyt.getTrainingId());
            p.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
    public void sil(trainingInfo kyt)
    {
        try {
            String sql = "DELETE FROM traininginfo WHERE TraningId=?";

            PreparedStatement p = (PreparedStatement) connect.connection.prepareStatement(sql);
            
            p.setInt(1,kyt.getTrainingId());
            p.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
}
