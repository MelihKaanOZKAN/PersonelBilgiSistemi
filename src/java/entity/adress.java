package entity;

/**
 *
 * @author HakanBey
 */
public class adress {

    private int AdressId;
    private String Adress;
    private citys City;
    private districts District;

    public adress() {
    }

    public adress(int AdressId, String Adress, citys City, districts District) {
        this.AdressId = AdressId;
        this.Adress = Adress;
        this.City = City;
        this.District = District;
    }

    public int getAdressId() {
        return AdressId;
    }

    public void setAdressId(int AdressId) {
        this.AdressId = AdressId;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public citys getCity() {
        return City;
    }

    public void setCity(citys City) {
        this.City = City;
    }

    public districts getDistrict() {
        return District;
    }

    public void setDistrict(districts District) {
        this.District = District;
    }

    @Override
    public String toString() {
        return "adress{" + "AdressId=" + AdressId + ", Adress=" + Adress + ", City=" + City + ", District=" + District + '}';
    }

}
