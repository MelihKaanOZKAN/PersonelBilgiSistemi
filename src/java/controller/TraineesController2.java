/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.traineesDao;
import dao.trainingDao;
import entity.EmployeeInfo;
import entity.Trainees;
import entity.personalinfo;
import entity.trainingInfo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "tranieesController2")
@SessionScoped


/* 
       
 */
public class TraineesController2 {

    private traineesDao tDao;
    private List<Trainees> TList;
    private Trainees selectedTrainee;
    private String ScreenCode = "PTR";
    private List<trainingInfo> UnAppliedTrainings;
    private trainingDao trDao;
    
       public TraineesController2() {
        tDao = new traineesDao();
        TList = new ArrayList<>();
        UnAppliedTrainings = new ArrayList<>();
        trDao = new trainingDao();
    }

    public void Apply(personalinfo info,trainingInfo t)
    {
        Trainees tr = new Trainees();
        tr.setTraininginfo(t);
        tr.setPersonInfo(this.getEmployeeFromPInfo(info));
        tr.setAppConfirm(false);
        tDao.addTrainee(tr);
    }
    public List<trainingInfo> getUnAppliedTrainings(personalinfo info) {
        UnAppliedTrainings = trDao.getUnAppliedTrainings(this.getEmployeeFromPInfo(info));
        return UnAppliedTrainings;
    }

    public void setUnAppliedTrainings(List<trainingInfo> UnAppliedTrainings) {
        this.UnAppliedTrainings = UnAppliedTrainings;
    }
    
    public String openPage(Trainees t)
    {
        selectedTrainee = t;
        return "TrainingInfo";
    }
    
    public String getScreenCode() {
        return ScreenCode;
    }

    private EmployeeInfo getEmployeeFromPInfo(personalinfo info) {
        EmployeeInfo result = new EmployeeInfo();
        result.setPinfo(info);
        return result;
    }

 
    public List<Trainees> getTList(personalinfo info) {
        TList = tDao.getTrainings(getEmployeeFromPInfo(info));
        return TList;
    }

    public void setTList(List<Trainees> TList) {
        this.TList = TList;
    }

    public Trainees getSelectedTrainee() {
        return selectedTrainee;
    }

    public void setSelectedTrainee(Trainees selectedTrainee) {
        this.selectedTrainee = selectedTrainee;
    }

}
