import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PrivatnaOsoba extends Osoba{
    private static Scanner sc = new Scanner(System.in);
    private String address;
    private String dateOfBirth;

    //konstrukor
    public PrivatnaOsoba(String firstName, String surname, String phoneNumber, String email, String address, String dateOfBirth) {
        super(firstName, surname, phoneNumber, email);
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    //getteri i setteri
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    static String datumRodenja() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        System.out.println("Unesite datum rođenja: (mm/dd/yyyy)");
        String datumRodenja = sc.nextLine();
        try {
            sdf.parse(datumRodenja);
            return datumRodenja;
        } catch (ParseException e) {
            System.out.println("Neispravan format!");
            datumRodenja();
        }
        return null;
    }

    //odredivanje formata ispisa
    @Override
    public String toString() {
        return String.format("%s,%s,%s", super.toString(), getAddress(), getDateOfBirth());
    }
}