package entity;


public class educationtypes {
    
    private int EduTypeID;
    private String EduTypeName;

    public int getEduTypeID() {
        return EduTypeID;
    }

    public void setEduTypeID(int EduTypeID) {
        this.EduTypeID = EduTypeID;
    }

    public String getEduTypeName() {
        return EduTypeName;
    }

    public void setEduTypeName(String EduTypeName) {
        this.EduTypeName = EduTypeName;
    }

    public educationtypes() {
        
    }
   
    @Override
    public String toString() {
        return "educationtypes{" + "EduTypeID=" + EduTypeID + ", EduTypeName=" + EduTypeName + '}';
    }
    
}

