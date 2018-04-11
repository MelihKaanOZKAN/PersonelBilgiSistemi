/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.emergencyinfoDao;
import entity.EmployeeInfo;
import entity.emergencyinfo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ozan
 */
@ManagedBean(name="emergencyinfo")
@SessionScoped
public class emergencyinfoController implements Serializable{
    List<emergencyinfo> clist;
    emergencyinfoDao cdao;

    public List<emergencyinfo> getClist(EmployeeInfo info) {
        this.clist = this.getCdao().getEmergencyinfo(info);
        return clist;
    }

    public void setClist(List<emergencyinfo> clist) {
        this.clist = clist;
    }

    public emergencyinfoDao getCdao() {
        if(cdao==null)
            cdao = new emergencyinfoDao();
        return cdao;
    }

    public void setCdao(emergencyinfoDao cdao) {
        this.cdao = cdao;
    }
    
}
