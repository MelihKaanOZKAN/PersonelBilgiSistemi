package entity;

/**
 *
 * @author HakanBey
 */
public class citys {
    private int CityId;
    private String CityName;

    public citys() {
    }

    public citys(int CityId, String CityName) {
        this.CityId = CityId;
        this.CityName = CityName;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    @Override
    public String toString() {
        return "citys{" + "CityId=" + CityId + ", CityName=" + CityName + '}';
    }
    
    
    
}
