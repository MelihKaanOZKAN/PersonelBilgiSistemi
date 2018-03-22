/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.annonsmentDao;
import entity.Annons;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Syste
 */
    @ManagedBean(name="Annons")
    @SessionScoped
public class AnnonsController {
    private annonsmentDao dao = new annonsmentDao();
    List<Annons> AnnonsList;

    public List<Annons> getAnnonsList(int GroupId) {
        AnnonsList = dao.getAnnons(GroupId);
        return AnnonsList;
    }

    public void setAnnonsList(List<Annons> AnnonsList) {
        this.AnnonsList = AnnonsList;
    }
}
