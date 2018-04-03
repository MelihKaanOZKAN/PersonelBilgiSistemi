package controller;

import dao.trainingDao;
import entity.trainingInfo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "TrainingInfoC")
@SessionScoped
public class TrainingInfoController {

    private trainingDao TInfDao;
    private List<trainingInfo> TList;
    private String ScreenCode = "TIE";
    private trainingInfo selectedTraınıng;

    
    public void Kaydet() {
        if (selectedTraınıng.getTrainingId() == 0) {
            TInfDao.Kaydet(selectedTraınıng);
        } else {
            TInfDao.Guncelle(selectedTraınıng);
        }
        selectedTraınıng = new trainingInfo();
    }

    public void Sil() {
        TInfDao.sil(selectedTraınıng);
        selectedTraınıng = new trainingInfo();
    }

    public List<trainingInfo> getTList() {
        TList = TInfDao.getTrainingList();

        return TList;
    }

    public TrainingInfoController() {
        selectedTraınıng = new trainingInfo();

        TInfDao = new trainingDao();
    }

    public void setTList(List<trainingInfo> TList) {
        this.TList = TList;
    }

    public String getScreenCode() {
        return ScreenCode;
    }

    public trainingInfo getSelectedTraınıng() {
        return selectedTraınıng;
    }

    public void setSelectedTraınıng(trainingInfo selectedTraınıng) {
        this.selectedTraınıng = selectedTraınıng;
    }

}
