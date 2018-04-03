/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Casper
 */
public class trainingInfo {
    private int trainingId;
    private String trainingName;
    private String trainingInfo;
    private Date BeginDate;
    private Date EndDate;
    private Date ExamDate;

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingInfo() {
        return trainingInfo;
    }

    public void setTrainingInfo(String trainingInfo) {
        this.trainingInfo = trainingInfo;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date BeginDate) {
        this.BeginDate = BeginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public Date getExamDate() {
        return ExamDate;
    }

    public void setExamDate(Date ExamDate) {
        this.ExamDate = ExamDate;
    }
    
            
            
            
            }
