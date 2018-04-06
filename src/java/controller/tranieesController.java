/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.departmenttableDAO;
import dao.traineesDao;
import entity.EmployeeInfo;
import entity.Trainees;
import entity.departments;
import entity.trainingInfo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "tranieesController")
@ViewScoped
public class tranieesController {

    private trainingInfo selectedTraining;
    private List<Integer> Persons;
    private List<Trainees> selectedPersons;
    private List<EmployeeInfo> PersonList;
    private List<departments> depList;
    private traineesDao traineeDao;
    private int  selectedDep;
    private departmenttableDAO depdao;
    public tranieesController() {
        selectedPersons = new ArrayList<>();
        Persons = new ArrayList<>();
        PersonList = new ArrayList<>();
        traineeDao = new traineesDao();
        depList = new ArrayList();
        depdao = new departmenttableDAO();
    }
    public void removePerson(EmployeeInfo p)
    {
        traineeDao.removeTrainee(p, selectedTraining);
    }
    public void acceptPerson(EmployeeInfo p)
    {
        traineeDao.acceptTrainee(p, selectedTraining);
    }
    public void addPersons(){
        traineeDao.addTrainees(Persons, selectedTraining, true);
    }
    public List<Integer> getPersons() {
        return Persons;
    }

    public void setPersons(List<Integer> Persons) {
        this.Persons = Persons;
    }

    public List<departments> getDepList() {
       depList = depdao.getdepartments();
        return depList;
    }

    public void setDepList(List<departments> depList) {
        this.depList = depList;
    }

    public int getSelectedDep() {
        return selectedDep;
    }

    public void setSelectedDep(int selectedDep) {
        this.selectedDep = selectedDep;
    }

    public trainingInfo getSelectedTraining() {
        return selectedTraining;
    }

    public void setSelectedTraining(trainingInfo selectedTraining) {
        this.selectedTraining = selectedTraining;
    }

    public List<Trainees> getSelectedPersons(trainingInfo info) {
        this.selectedTraining = info;
        selectedPersons = traineeDao.selectedPersons(selectedTraining);
        return selectedPersons;
    }

    public void setSelectedPersons(List<Trainees> selectedPersons) {
        this.selectedPersons = selectedPersons;
    }

    private departments getSelectedDepartment(){
        departments dep = new departments();
        dep.setDeparmentId(selectedDep);
        return dep;
    }
    public List<EmployeeInfo> getPersonList() {
        
        PersonList = traineeDao.PersonList(this.getSelectedDepartment());
        return PersonList;
    }

    public void setPersonList(List<EmployeeInfo> PersonList) {
        this.PersonList = PersonList;
    }
    public boolean isDepSelected(){
        if(this.selectedDep == 0)
        {
            return false;
        }
        else{
            return true;
        }
    }
    
}
