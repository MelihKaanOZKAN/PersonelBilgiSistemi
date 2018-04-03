package controller;

import dao.User_PermitDao;
import entity.User_PermitTypes;
import entity.User_Permits;
import entity.personalinfo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean(name = "PersonInfoPermit")
@SessionScoped
public class PermitController implements Serializable {

    private List<User_Permits> permitList;
    private User_PermitDao permitDao;
    private personalinfo Person;
    private User_Permits permit;
    private List<User_PermitTypes> permitTypes;

    public List<User_PermitTypes> getPermitTypes() {
        return permitTypes;
    }

    public void setPermitTypes(List<User_PermitTypes> permitTypes) {
        this.permitTypes = permitTypes;
    }

    public void eklegüncelle() {
        if (permit.getPermitId() == 0) {
            permitDao.insert(permit);
        } else {
            permitDao.update(permit);
        }
        permit = new User_Permits();
    }

    public void delete() {
        permitDao.delete(permit);
        permit = new User_Permits();

    }

    public PermitController() {
    }

    public List<User_Permits> getPermitList(personalinfo person) {
        permitList = permitDao.getPermits(person);
        this.Person = person;
        return permitList;
    }

    public void setPermitList(List<User_Permits> PermitList) {
        this.permitList = PermitList;
    }

    public User_PermitDao getPermitDao() {
        return permitDao;
    }

    public void setPermitDao(User_PermitDao permitDao) {
        this.permitDao = permitDao;
    }

    public User_Permits getPermit() {
        return permit;
    }

    public void setPermit(User_Permits permit) {
        this.permit = permit;
    }

    public String editAction(User_Permits order) {

        order.setGorunurluk(true);
        return null;
    }

    public String saveAction() {

        for (User_Permits order : permitList) {
            order.setGorunurluk(false);
        }

        return null;

    }
}
