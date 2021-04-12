public class PoslovnaOsoba extends Osoba {
    private String title;
    private String company;

    //konstrukor
    public PoslovnaOsoba(String firstName, String surname, String phoneNumber, String email, String title, String company) {
        super(firstName, surname, phoneNumber, email);
        this.title = title;
        this.company = company;
    }

    //getteri i setteri
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    //odredivanje formata ispisa
    @Override
    public String toString() {
        return String.format("%s,%s,%s", super.toString(), getTitle(), getCompany());
    }
}