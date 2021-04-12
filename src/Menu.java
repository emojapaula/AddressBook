import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static Action MainMenu() throws IOException {
        System.out.println("Molimo odaberite broj pored jedne od 4 opcije!");
        System.out.println("1. Unos novog kontakta");
        System.out.println("2. Ažuriranje postojećeg kontakta");
        System.out.println("3. Brisanje kontakta");
        System.out.println("4. Pretraživanje kontakata");
        System.out.println("5. Izađi iz programa\n");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                return Action.ADD;
            case "2":
                return Action.UPDATE;
            case "3":
                return Action.DELETE;
            case "4":
                return Action.SEARCH;
            case "5":
                return Action.EXIT;
            default:
                MainMenu();
                break;
        }
        return null;
    }

    public static SearchFilter SearchMenu() throws IOException {
        System.out.println("Molimo odaberite broj pored jedne od 4 opcije!");
        System.out.println("1. Pretraživanje po imenu");
        System.out.println("2. Pretraživanje po prezimenu");
        System.out.println("3. Pretraživanje po emailu");
        System.out.println("4. Povratak u prethodi izbornik");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                return SearchFilter.NAME;
            case "2":
                return SearchFilter.SURNAME;
            case "3":
                return SearchFilter.EMAIL;
            case "4":
                MainMenu();
                break;
            default:
                SearchMenu();
        }
        return null;
    }

    static UpdateFilter UpdateMenuPrivate() throws IOException {
        System.out.println("Molimo unesite broj pored jedne od ponuđenih opcija!");
        System.out.println("1. Promjena imena");
        System.out.println("2. Promjena prezimena");
        System.out.println("3. Promjena broja telefona");
        System.out.println("4. Promjena emaila");
        System.out.println("5. Promjena datuma rođenja");
        System.out.println("6. Promjena adrese");
        System.out.println("7. Povratak u prethodni izbornik");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                return UpdateFilter.NAME;
            case "2":
                return UpdateFilter.SURNAME;
            case "3":
                return UpdateFilter.TELEPHONE;
            case "4":
                return UpdateFilter.EMAIL;
            case "5":
                return UpdateFilter.DATEOFBIRTH;
            case "6":
                return UpdateFilter.ADDRESS;
            case "7":
                SearchMenu();
                break;
            default:
                UpdateMenuPrivate();
        }
        return null;
    }
    static UpdateFilter UpdateMenuPoslovni() throws IOException {
        System.out.println("Molimo unesite broj pored jedne od ponuđenih opcija!");
        System.out.println("1. Promjena imena");
        System.out.println("2. Promjena prezimena");
        System.out.println("3. Promjena broja telefona");
        System.out.println("4. Promjena emaila");
        System.out.println("5. Promjena titule");
        System.out.println("6. Promjena tvrtke:");
        System.out.println("7. Povratak u prethodni izbornik:");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                return UpdateFilter.NAME;
            case "2":
                return UpdateFilter.SURNAME;
            case "3":
                return UpdateFilter.TELEPHONE;
            case "4":
                return UpdateFilter.EMAIL;
            case "5":
                return UpdateFilter.TITLE;
            case "6":
                return UpdateFilter.COMPANY;
            case "7":
                SearchMenu();
                break;
            default:
                UpdateMenuPoslovni();
        }
        return null;
    }

    static AddFilter AddMenu() throws IOException {
        System.out.println("Molimo odaberite broj pored jedne od 3 opcije!");
        System.out.println("1. Dodavanje privatnog kontakta");
        System.out.println("2. Dodavanje poslovnog kontakta");
        System.out.println("3. Povratak u prethodni izbornik");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                return AddFilter.PRIVATE;
            case "2":
                return AddFilter.POSLOVNI;
            case "3":
                MainMenu();
        }
        return  null;
    }
}

