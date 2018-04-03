package controller;

import dao.communicationinfoDao;
import entity.communicationinfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author HakanBey
 */
@ManagedBean(name = "communication")
@SessionScoped
public class communicationinfoController implements Serializable {

    private List<communicationinfo> clist;
    private communicationinfoDao cdao;

    public communicationinfoController() {
        this.clist = new ArrayList<>();
        cdao = new communicationinfoDao();
    }

    public List<communicationinfo> getClist() {
        clist = this.getCdao().getCommunication();
        return clist;
    }

    public void setClist(List<communicationinfo> clist) {
        this.clist = clist;
    }

    public communicationinfoDao getCdao() {
        if (cdao == null) {
            cdao = new communicationinfoDao();
        }
        return cdao;
    }

    public void setCdao(communicationinfoDao cdao) {
        this.cdao = cdao;
    }

}
