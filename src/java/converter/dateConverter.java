/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Casper
 */
@FacesConverter("convertDate")
public class dateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
           java.util.Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            string = string.replace('-','/');
           date  = format.parse(string);
        } catch (ParseException ex) {
            Logger.getLogger(dateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date dt = new java.sql.Date(date.getTime());
        return dt;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Date date = (Date) o;
        return date.toString();
    }
    
}
