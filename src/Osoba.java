//import Launcher.SEARCH_FILTER;

public class Osoba {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private String email;

    //konstrukor
    public Osoba(String firstName, String surname, String phoneNumber, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //getteri i setteri
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //odredivanje formata ispisa
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", getFirstName(), getSurname(), getPhoneNumber(), getEmail());
    }

}