import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Launcher {
    private static Scanner sc = new Scanner(System.in);
    public List<Osoba> Contacts;

    //konstruktor
    public Launcher() {
        sc = new Scanner(System.in);
        this.Contacts = new ArrayList<Osoba>();
    }

    //glavna metoda iz koje se ostale granaju
    public void run() throws IOException {
        while (true) {
            Action choice = Menu.MainMenu();
            switch (choice) {
                case ADD -> addNewContact();
                case UPDATE -> updateContact();
                case DELETE -> deleteContact();
                case SEARCH -> searchContacts();
                case EXIT -> System.exit(0);
            }
        }
    }

    //metoda koja sluzi za odabir dodajemo poslovni/dodajemo privatni
    private void addNewContact() throws IOException {
        AddFilter choice = Menu.AddMenu();
        switch (choice) {
            case PRIVATE:
                Contacts.add(addPrivate());
                break;
            case POSLOVNI:
                Contacts.add(addPoslovni());
                break;
            default:
                addNewContact();
        }
    }
    //metoda za dodavanje privatnog kontakta sa njegovim pripadajućim atributima
    private PrivatnaOsoba addPrivate() {
        System.out.println("Unesite ime: ");
        String firstName = sc.nextLine();
        System.out.println("Unesite prezime: ");
        String surname = sc.nextLine();
        System.out.println("Unesite broj telefona: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Unesite email: ");
        String email = sc.nextLine();
        System.out.println("Unesite adresu: ");
        String address = sc.nextLine();
        String dateOfBirth = PrivatnaOsoba.datumRodenja();
        return new PrivatnaOsoba(firstName, surname, phoneNumber, email, address, dateOfBirth);
    }
    //metoda za dodavanje poslovnog kontakta sa njegovim pripadajućim atributima
    private PoslovnaOsoba addPoslovni() {
        System.out.println("Unesite ime: ");
        String firstName = sc.nextLine();
        System.out.println("Unesite prezime: ");
        String surname = sc.nextLine();
        System.out.println("Unesite broj telefona: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Unesite email: ");
        String email = sc.nextLine();
        System.out.println("Unesite titulu ");
        String title = sc.nextLine();
        System.out.println("Unesite ime kompanije: ");
        String company = sc.nextLine();
        return new PoslovnaOsoba(firstName, surname, phoneNumber, email, title, company);
    }

     //metoda za pretraživanje kontakata, nakon odabira nacina pretrazivanja pomocu streama vraca listu kontakata s odgovarajucim atributom
    private List<Osoba> searchContacts() throws IOException {
        //int i = 0;
        SearchFilter choice = Menu.SearchMenu();
        List<Osoba> filter;
        switch (choice) {
            case NAME:
                System.out.println("Unesite ime: ");
                String ime = sc.nextLine();
                filter = Contacts.stream().filter(osoba -> osoba.getFirstName().equals(ime)).collect(Collectors.toList());
                //Collections.sort(filter);
                if (filter.size() == 0) {
                    System.out.println("Nema nijednog kontakta s tim imenom!");
                } else {
                    for(int i = 0; i < filter.size(); i++){
                        System.out.println((i + 1) + ". "+ (Osoba)filter.get(i));
                    }
                }
                return filter;
            case SURNAME:
                System.out.println("Unesite prezime: ");
                String prezime = sc.nextLine();
                filter = Contacts.stream().filter(osoba -> osoba.getSurname().equals(prezime)).collect(Collectors.toList());
                if (filter.size() == 0) {
                    System.out.println("Nema nijednog kontakta s tim prezimenom!");
                } else {
                    for(int i = 0; i < filter.size(); i++){
                        System.out.println((i + 1) + ". "+ (Osoba)filter.get(i));
                    }
                }
                return filter;
            case EMAIL:
                System.out.println("Unesite email: ");
                String email = sc.nextLine();
                filter =  Contacts.stream().filter(osoba -> osoba.getEmail().equals(email)).collect(Collectors.toList());
                if (filter.size() == 0) {
                    System.out.println("Nema nijednog kontakta s tim emailom!");
                } else {
                    for(int i = 0; i < filter.size(); i++){
                        System.out.println((i + 1) + ". "+ (Osoba)filter.get(i));
                    }
                }
                return filter;
        }
        return null;
    }

    //koristenjem metode searchcontacts korisniku olakavamo pronalazak zeljenog kontakta
    // u try-catch parsiramo string te pomocu njega pristupamo koncanom zeljenom kontaktu
    //i naposlijetku proslijedujemo kontakt dalje metodama updateprivate i updateposlovni ovisno o tipu kontakta
    private void updateContact() throws IOException {
        List<Osoba> filter = searchContacts();
        int Rb = 0;
        if(filter.size() > 0){
            while(true){
                System.out.println("Molimo unesite redni broj osobe koju želite urediti!");
                String RedniBrojOsobe = sc.nextLine();
            try {
                Rb = Integer.parseInt(RedniBrojOsobe) - 1;
                break;
            } catch (NumberFormatException e){
                System.out.println("Neispravan format!");
            }
        }
            Osoba Osoba = filter.get(Rb);
            if (Osoba instanceof PrivatnaOsoba){
                updatePrivate(Osoba);
            } else {
                updatePoslovni((PoslovnaOsoba) Osoba);
            }}

    }

    //castamo osobu na tip poslovnaosoba te nakon odabira pomocu settera postavljamo novu vrijednost zeljenog atributa
    private void updatePoslovni(Osoba o) throws IOException {
        PoslovnaOsoba Osoba = (PoslovnaOsoba) o;
        UpdateFilter choice = Menu.UpdateMenuPoslovni();
        switch(choice) {
            case NAME:
                System.out.println("Molimo unesite novo ime: ");
                Osoba.setFirstName(sc.nextLine());
                break;
            case SURNAME:
                System.out.println("Molimo unesite novo prezime: ");
                Osoba.setSurname(sc.nextLine());
                break;
            case EMAIL:
                System.out.println("Molimo unesite novi email: ");
                Osoba.setEmail(sc.nextLine());
                break;
            case TELEPHONE:
                System.out.println("Molimo unesite novi broj telefona: ");
                Osoba.setPhoneNumber(sc.nextLine());
                break;
            case TITLE:
                System.out.println("Molimo unesite novu titulu: ");
                Osoba.setTitle(sc.nextLine());
                break;
            case COMPANY:
                System.out.println("Molimo unesite novu tvrtku: ");
                Osoba.setTitle(sc.nextLine());
                break;
            case BACK:
                Menu.MainMenu();
            }
    }

    //castamo osobu na tip privatnaosoba te nakon odabira pomocu settera postavljamo novu vrijednost zeljenog atributa
    private void updatePrivate(Osoba o) throws IOException {
        PrivatnaOsoba Osoba = (PrivatnaOsoba) o;
            UpdateFilter choice = Menu.UpdateMenuPrivate();
            switch (choice) {
                case BACK:
                    Menu.MainMenu();
                case NAME:
                    System.out.println("Molimo unesite novo ime: ");
                    Osoba.setFirstName(sc.nextLine());
                    //break;
                case SURNAME:
                    System.out.println("Molimo unesite novo prezime: ");
                    Osoba.setSurname(sc.nextLine());
                    break;
                case EMAIL:
                    System.out.println("Molimo unesite novi email: ");
                    Osoba.setEmail(sc.nextLine());
                    break;
                case TELEPHONE:
                    System.out.println("Molimo unesite novi broj telefona: ");
                    Osoba.setPhoneNumber(sc.nextLine());
                    break;
                case DATEOFBIRTH:
                    System.out.println("Molimo unesite novi datum rođenja: ");
                    Osoba.setDateOfBirth(PrivatnaOsoba.datumRodenja());
                    break;
                case ADDRESS:
                    System.out.println("Molimo unesite novu adresu: ");
                    Osoba.setAddress(sc.nextLine());
                    break;
            }
    }

    //koristenjem metode searchcontacts korisniku olakavamo pronalazak zeljenog kontakta
    // u try-catch parsiramo string te pomocu njega pristupamo koncanom zeljenom kontaktu
    //i naposlijetku ga pomocu builtin funkcije remove izbrisemo
    private void deleteContact() throws IOException {
        List<Osoba> filter = searchContacts();
        int Rb;
        if(filter.size() > 0){
            while (true) {
                System.out.println("Molimo unesite redni broj osobe koju želite izbrisati!");
                String RedniBrojOsobe = sc.nextLine();
                try {
                    Rb = Integer.parseInt(RedniBrojOsobe) - 1;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Neispravan format!");
                }
            }
            Contacts.remove(filter.get(Rb));
        }

    }
}