package dao;

import entity.EmployeeInfo;
import entity.JobInfo;
import util.ConnectionClass;
import entity.adress;
import entity.communicationinfo;
import entity.departments;
import entity.personalinfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class personalinfoDao {

    ConnectionClass connection = new ConnectionClass();

    public void addPersonal(personalinfo person) {
        try {
            String sorgu = "insert into personalinfo (EName,ESurname, SocialSecurityNumber,CitizensShipNumber,BirthDate,MaritalStatus) values(?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, person.getEName());
            ps.setString(2, person.getESurname());
            ps.setString(3, person.getSocialSecurityNumber());
            ps.setString(4, person.getCitizensShipNumber());
            ps.setDate(5, person.getBirthDate());
            //ps.setBoolean(6, person.getGender());
            ps.setInt(6, person.getMaritalStatus());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePersonal(personalinfo person) {
        try {
            String sorgu = "UPDATE personalinfo SET EName=?,ESurname=?,SocialSecurityNumber=?,CitizensShipNumber=?,BirthDate=?,Gender=?,MaritalStatus=? where PInfoId=?";
            PreparedStatement ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, person.getEName());
            ps.setString(2, person.getESurname());
            ps.setString(3, person.getSocialSecurityNumber());
            ps.setString(4, person.getCitizensShipNumber());
            ps.setDate(5, person.getBirthDate());
            ps.setBoolean(6, person.getGender());
            ps.setInt(7, person.getMaritalStatus());
            ps.setInt(8, person.getPInfoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePersonal(personalinfo person) {
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "DELETE FROM personalinfo WHERE PInfoId=?";
            PreparedStatement ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setInt(1, person.getPInfoId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<EmployeeInfo> getPersonal() {
        List<EmployeeInfo> clist = new ArrayList<>();
        try {
            String sql = "select   EmployeeId, P.PInfoId, P.EName, P.ESurname, " +
"P.SocialSecurityNumber,P.CitizensShipNumber,AT.Adress,P.BirthDate, " +
"CT.CommId, CT.PhoneNumber, CT.Email,P.Gender,P.MaritalStatus, " +
" d.DepartmentId, d.DepartmentName, j.JobId, j.JobName  FROM employeeinfo e                   " +
"  						inner join personalinfo P on P.PInfoId=e.InfoId " +
"                    inner join departments d on d.DepartmentId = e.Department " +
"                    inner join jobs j on j.JobId = e.JobId " +
"                    inner join adress AT on P.Adress=AT.AdressId " +
"						  inner join communicationinfo CT on P.Communication=CT.CommId " +
"                    ";
            PreparedStatement st = (PreparedStatement) connection.connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EmployeeInfo E = new EmployeeInfo();
                adress adress = new adress();
                communicationinfo comm = new communicationinfo();
                comm.setCommId(rs.getInt("CommId"));
                comm.setEmail(rs.getString("Email"));
                comm.setPhoneNumber(rs.getString("PhoneNumber"));
                personalinfo info = new personalinfo();
                info.setPInfoId(rs.getInt("PInfoId"));
                info.setEName(rs.getString("EName"));
                info.setESurname(rs.getString("ESurname"));
                info.setSocialSecurityNumber(rs.getString("SocialSecurityNumber"));
                info.setCitizensShipNumber(rs.getString("CitizensShipNumber"));
                info.setAdress(adress);
                info.setBirthDate(rs.getDate("BirthDate"));
                info.setCommunication(comm);
                info.setGender(rs.getBoolean("Gender"));
                info.setMaritalStatus(rs.getInt("MaritalStatus"));
                departments d = new departments();
                d.setDeparmentId(rs.getInt("DepartmentId"));
                d.setDepartmentName(rs.getString("DepartmentName"));
                E.setDepartment(d);
                JobInfo J = new JobInfo();
                J.setJobId(rs.getInt("JobId"));
                J.setJobName(rs.getString("JobName"));
                E.setJob(J);
                E.setEmployeeId(rs.getInt("EmployeeId"));
                E.setPinfo(info);
                clist.add(E);
            }
            System.out.println("test");
            st.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clist;
    }

    public personalinfo getPersonalInfobyCTNumber(personalinfo info) {
        try {
            String sorgu = "SELECT PInfoId,EName,ESurname,SocialSecurityNumber,CitizensShipNumber,BirthDate,Gender,MaritalStatus from personalinfo where CitizensShipNumber=?";
            PreparedStatement ps = (PreparedStatement) connection.connection.prepareStatement(sorgu);
            ps.setString(1, info.getCitizensShipNumber());
            ResultSet rs = ps.executeQuery();
            rs.next();
            info.setPInfoId(rs.getInt(1));
            info.setEName(rs.getString(2));
            info.setESurname(rs.getString(3));
            info.setSocialSecurityNumber(rs.getString(4));
            info.setCitizensShipNumber(rs.getString(5));
            info.setBirthDate(rs.getDate(6));
            info.setGender(rs.getBoolean(7));
            info.setMaritalStatus(rs.getInt(8));
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return info;
    }

}
