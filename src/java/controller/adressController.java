package controller;

import dao.adressDao;
import entity.adress;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author HakanBey
 */
@ManagedBean(name="adres")
@SessionScoped
public class adressController {

    private adressDao cdao;
     private List<adress> clist;

    public List<adress> getClist() {
        this.clist= this.getCdao().getAdress();
        return clist;
    }

    public void setClist(List<adress> clist) {
        this.clist = clist;
    }

    public adressController() {
        cdao = new adressDao();
    }

    public adressDao getCdao() {
        if( cdao==null )
            cdao = new adressDao();
        return cdao;
    }

    public void setCdao(adressDao cdao) {
        this.cdao = cdao;
    }

}
