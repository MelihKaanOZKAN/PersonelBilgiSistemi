package controller;

import dao.personalinfoDao;
import entity.EmployeeInfo;
import entity.personalinfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Personal")
@SessionScoped
public class personalInfoController implements Serializable {

    private List<EmployeeInfo> clist;
    private personalinfoDao personalDao;

    private EmployeeInfo personal;

    public personalInfoController() {
        this.clist = new ArrayList<>();
    }
public String emergency(EmployeeInfo person){
        this.personal = person;
        return "/emergencyInfo.xhtml?faces-redirect=true";
    }
    public String izinIslem(EmployeeInfo person){
        this.personal = person;
        return "/izinislemleri.xhtml?faces-redirect=true";
    }
    public String updateForm(EmployeeInfo person)
    {
        this.personal=person;
        return "addPerson.xhtml?faces-redirect=true";
    }
    
    public String update(personalinfo person)
    {
        this.getPersonalDao().updatePersonal(person);
        return "persons";
    }
    
    public String delete(EmployeeInfo person)
    {
        this.getPersonalDao().deletePersonal(person.getPinfo());
        return "persons";
    }
    
    public String create() {
        this.getPersonalDao().addPersonal(this.personal);
        return "addPerson";
    }

    public List<EmployeeInfo> getClist() {
        this.clist = this.getPersonalDao().getPersonal();
        return clist;
    }

    public void setClist(List<EmployeeInfo> clist) {
        this.clist = clist;
    }

    public EmployeeInfo getPersonal() {
        if (this.personal == null) {
            this.personal = new EmployeeInfo();
        }
        return personal;
    }

    public void setPersonal(EmployeeInfo personal) {
        this.personal = personal;
    }

    public personalinfoDao getPersonalDao() {
        if (this.personalDao == null) {
            this.personalDao = new personalinfoDao();
        }
        return personalDao;
    }

    public void setPersonalDao(personalinfoDao personalDao) {
        this.personalDao = personalDao;
    }

}
