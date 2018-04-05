package dao;

import controller.City;
import entity.adress;
import util.ConnectionClass;
import entity.personalinfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class adressDao {

    ConnectionClass connection = new ConnectionClass();
    PreparedStatement ps;
    String sorgu;

    public void addAdress(personalinfo person) {
        try {
            sorgu = "INSERT INTO adress (Adress,City,District) VALUES (?,?,?)";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getAdress().getAdress());
            ps.setString(2, person.getAdress().getCity().getCityName());
            ps.setString(3, person.getAdress().getDistrict().getDistrictName());
            ps.executeQuery();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAdress(personalinfo person) {
        try {
            sorgu = "UPDATE adress SET Adress=?, City=?, District=? WHERE AdressId=?";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, person.getAdress().getAdress());
            ps.setString(2, person.getAdress().getCity().getCityName());
            ps.setString(3, person.getAdress().getDistrict().getDistrictName());
            ps.setInt(4, person.getAdress().getAdressId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAdress(personalinfo person) {
        try {
            sorgu = "DELETE from adress WHERE AdressId=?";
            ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setInt(1, person.getAdress().getAdressId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public personalinfo findAdress(personalinfo person)
    {
        try {
            sorgu="SELECT AdressId, Adress, City, District from adress WHERE AdressId=?";
            ps=(PreparedStatement) connection.connection.prepareStatement(sorgu);
            ResultSet rs = ps.executeQuery();
            while( rs.next() )
            {
                if(person.getAdress().getAdressId()==rs.getInt("AdressId"))
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return person;
    }
    
    public List<adress> getAdress(){
         List<adress> clist= new ArrayList<>();
         try {
              ConnectionClass connection = new ConnectionClass();
              /* select AdressId, Adress,A.City, C.CityName, A.District, D.DistrictName from adress A
inner join Citys C on C.CityId = A.City
inner join Districts D on C.CityId = D.City
*/
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement("select AdressId, Adress,City, C.CityName, District, D.Districtname from adress");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                adress tmp = new adress();
                tmp.setAdressId(rs.getInt(1));
                tmp.setAdress(rs.getString(2));
                
                clist.add(tmp);
            }
            
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return clist;
     }

}
