package dao;

import entity.educationtypes;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionClass;

public class educationtypesDao {
    public List<educationtypes> getEducationtypes(){
        List<educationtypes> clist=new ArrayList();
        try {
            ConnectionClass connection = new ConnectionClass();
            String egitimBilgi="EduTypeID,EduTypeName";
            PreparedStatement st= (PreparedStatement) connection.connection.prepareStatement(egitimBilgi);
            ResultSet rs = st.executeQuery ();
            while(rs.next()){
                educationtypes tmp=new educationtypes();
                tmp.setEduTypeID(rs.getInt("EduTypeID"));
                tmp.setEduTypeName(rs.getString("EduTypeName"));
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clist;
    }
    
}