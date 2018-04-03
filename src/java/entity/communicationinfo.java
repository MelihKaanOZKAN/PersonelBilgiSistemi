package entity;

/**
 *
 * @author HakanBey
 */
public class communicationinfo {

    private int CommId;
    private String PhoneNumber;
    private String Email;

    public communicationinfo() {
    }

    public communicationinfo(int CommId, String PhoneNumber, String Email) {
        this.CommId = CommId;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
    }

    public int getCommId() {
        return CommId;
    }

    public void setCommId(int CommId) {
        this.CommId = CommId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "communicationinfo{" + "CommId=" + CommId + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email + '}';
    }

}
