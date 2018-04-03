/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.departmenttableDAO;
import entity.departments;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aysun
 */
    @ManagedBean(name="departments")
    @SessionScoped
public class departmentController {
    private List<departments> clist;
    private departmenttableDAO cdao;

    public departmentController() {
        this.clist = new ArrayList<>();
        cdao= new departmenttableDAO();
        
    }

    public List<departments> getClist() {
        this.clist= this.getCdao().getdepartments();
        System.out.println(clist.get(0).getDepartmentName());
        return clist;
    }

    public void setClist(List<departments> clist) {
        this.clist = clist;
    }

    public departmenttableDAO getCdao() {
        return cdao;
    }

    public void setCdao(departmenttableDAO cdao) {
        this.cdao = cdao;
    }

    
}
