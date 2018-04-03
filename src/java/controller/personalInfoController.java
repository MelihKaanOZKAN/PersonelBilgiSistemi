package controller;

import dao.personalinfoDao;
import entity.personalinfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Personal")
@SessionScoped
public class personalInfoController implements Serializable {

    private List<personalinfo> clist;
    private personalinfoDao personalDao;

    private personalinfo personal;

    public personalInfoController() {
        this.clist = new ArrayList<>();
    }

    public String izinIslem(personalinfo person){
        this.personal = person;
        return "izinislemleri";
    }
    public String updateForm(personalinfo person)
    {
        this.personal=person;
        return "persons";
    }
    
    public String update(personalinfo person)
    {
        this.getPersonalDao().updatePersonal(person);
        return "persons";
    }
    
    public String delete(personalinfo person)
    {
        this.getPersonalDao().deletePersonal(person);
        return "persons";
    }
    
    public String create() {
        this.getPersonalDao().addPersonal(this.personal);
        return "addPerson";
    }

    public List<personalinfo> getClist() {
        this.clist = this.getPersonalDao().getPersonal();
        return clist;
    }

    public void setClist(List<personalinfo> clist) {
        this.clist = clist;
    }

    public personalinfo getPersonal() {
        if (this.personal == null) {
            this.personal = new personalinfo();
        }
        return personal;
    }

    public void setPersonal(personalinfo personal) {
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
