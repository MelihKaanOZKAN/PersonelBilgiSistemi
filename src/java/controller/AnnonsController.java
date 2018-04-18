/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.annonsmentDao;
import entity.Annons;
import entity.UserGroup;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Pagination;

/**
 *
 * @author Syste
 */
@ManagedBean(name = "Annons")
@SessionScoped
public class AnnonsController implements Serializable {

    private annonsmentDao dao = new annonsmentDao();
    private List<Annons> AnnonsList;
    private Annons selected;
    private String ScreenCode = "AnnonsCon";
    private int group;

    public Pagination getPagination() {
        return pagination;
    }
    private Pagination pagination = new Pagination();

    public void delete() {
        dao.deleteAnnons(selected);
        selected = new Annons();
        this.getSelected().getGroup().setGroupId(group);
    }

    public void update() {
        if (selected.getId() == 0) {
            dao.addAnnons(selected);
        } else {
            dao.updateAnnons(selected);
        }
        selected = new Annons();
        this.getSelected().getGroup().setGroupId(group);
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.getSelected().getGroup().setGroupId(group);
        this.group = group;
    }

    public void setCurrentAnnos(Annons a) {
        selected = a;
    }

    public String getScreenCode() {
        return ScreenCode;
    }

    public boolean isGroupSelected() {
        if (this.group == 0) {
            return false;
        } else {
            return true;
        }
    }

    public Annons getSelected() {
        if (selected == null) {
            selected = new Annons();
        }
        return selected;
    }

    public void setSelected(Annons selected) {
        this.selected = selected;
    }

    public List<Annons> getAnnonsList(UserGroup group, Boolean Mode) {
        if (Mode) {
            pagination.setRowCount(dao.getCount(group));
            pagination.setRowLimit(2);
            AnnonsList = dao.getAnnons(group, pagination);
        } else {
            pagination.setRowCount(dao.getCountAll(group));
            pagination.setRowLimit(2);
            AnnonsList = dao.getAllAnnons(group, pagination);
        }

        return AnnonsList;
    }

    public void setAnnonsList(List<Annons> AnnonsList) {
        this.AnnonsList = AnnonsList;
    }
}
