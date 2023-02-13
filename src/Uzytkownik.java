import com.sun.security.jgss.GSSUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String nr_tel;
    private String login;
    private String haslo;
    private boolean pracownik;

    public static ArrayList<Uzytkownik> uzytkowniks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Uzytkownik(String imie, String nazwisko, String nr_tel, String login, String haslo, boolean pracownik) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel = nr_tel;
        this.login = login;
        this.haslo = haslo;
        this.pracownik = pracownik;
    }

    class PrzydatneMetody
    {
        private static String dodajNrTel()
        {
            String tel="";
            while (tel.isEmpty())
            {
                tel = scanner.nextLine();
            }
            return tel;
        };

        private static LocalDate data()
        {
            int rok = scanner.nextInt();
            int mm = scanner.nextInt();
            int dd = scanner.nextInt();
            LocalDate data = LocalDate.of(rok,mm,dd);
            return data;
        }

        private static String DodajString()
        {
            String tyt="";
            while (tyt.isEmpty())
            {
                tyt = scanner.nextLine();
            }
            return tyt;
        }

        private static void powrot()
        {
            System.out.println("1. wroc do menu");
            System.out.println("2. wyjdz");
            int wybor = scanner.nextInt();
            switch (wybor)
            {
                case 1 -> menu();
                case 2 -> System.exit(0);
            }
        }

    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", pracownik=" + pracownik +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public boolean isPracownik() {
        return pracownik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uzytkownik that = (Uzytkownik) o;
        return pracownik == that.pracownik && Objects.equals(login, that.login) && Objects.equals(haslo, that.haslo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, haslo, pracownik);
    }


    public static void zaloguj()
    {
        System.out.println("Zaloguj sie");

        System.out.println("podaj login: ");
        String log = PrzydatneMetody.DodajString();

        System.out.println("podaj haslo: ");
        String pass = PrzydatneMetody.DodajString();

        for (Uzytkownik uzytkownik : uzytkowniks)
        {
            if (uzytkownik.getLogin().equals(log) && uzytkownik.getHaslo().equals(pass))
            {
                if(uzytkownik.isPracownik())
                {
                    menu();
                }
                else
                {
                    menuUzyt();
                }
            }
            else {
                System.out.println("blad! zaloguj sie ponownie");
                Main.menustart();
            }
        }


        PrzydatneMetody.powrot();
    };

    public static void utworzKonto()
    {
        System.out.println("Utworz konto");

        System.out.println("podaj imie: ");
        String im = PrzydatneMetody.DodajString();

        System.out.println("podaj nazwisko: ");
        String naz = PrzydatneMetody.DodajString();

        System.out.println("podaj nr_tel: ");
        String tel = PrzydatneMetody.DodajString();

        System.out.println("podaj login: ");
        String log = PrzydatneMetody.DodajString();

        System.out.println("podaj haslo: ");
        String pass = PrzydatneMetody.DodajString();


        for (Uzytkownik uzytkownik : uzytkowniks)
        {
            if (uzytkownik.getLogin().equals(log) && uzytkownik.getHaslo().equals(pass) && uzytkownik.getNr_tel().equals(tel)) {
                System.out.println("takie konto juz istnieje");
                utworzKonto();
            }
        }

        uzytkowniks.add(new Uzytkownik(im,naz,tel,log,pass,false));
        System.out.println("konto zostalo utworzone!");

        menuUzyt();
    }


    public static void menu()
    {


        System.out.println("1. Wyszukaj ksiazke");
        System.out.println("2. Dodaj ksiazke");
        System.out.println("3. Usun ksiazke");
        System.out.println("4. Pokaz zbior wszystkich ksiazke w bibliotece");
        System.out.println("5. wypozycz ksiazke");
        System.out.println("6. wyloguj");
        System.out.println("7. wyjdz");
        System.out.println("wybierz opcje (1-4): ");
        int wybor = scanner.nextInt();

        if(wybor == 1 || wybor == 2 || wybor == 3 || wybor == 4 || wybor == 5 || wybor == 6 || wybor == 7) {

            switch (wybor) {
                case 1 -> Ksiazka.wyszukaj_ksiazke();
                case 2 -> Ksiazka.dodaj_ksiazke();
                case 3 -> Ksiazka.usun_ksiazke();
                case 4 -> Ksiazka.ksiegozbior();
                case 5 -> Ksiazka.wypozycz();
                case 6 -> Main.menustart();
                case 7 -> System.exit(0);
                default -> System.out.println("podaj prawidlowa liczbe");
            }
        }
        menu();
    }

    public static void menuUzyt()
    {
        System.out.println("1. Wyszukaj ksiazke");
        System.out.println("2. Pokaz zbior wszystkich ksiazke w bibliotece");
        System.out.println("wybierz opcje (1-2): ");
        int wybor = scanner.nextByte();

        if (wybor == 1 || wybor == 2)
        {

            switch (wybor)
            {
                case 1 -> Ksiazka.wyszukaj_ksiazke();
                case 2 -> Ksiazka.ksiegozbior();
            }
        }
        else {
            System.out.println("podaj prawidlowa liczbe");
            menuUzyt();
        }

        System.out.println("1. wyloguj");
        System.out.println("2. wyjdz");
        int wyborr = scanner.nextInt();
        switch (wyborr)
        {
            case 1 -> menu();
            case 2 -> System.exit(0);
        }

    }


    public static void uzyt()
    {
        uzytkowniks.add(new Uzytkownik("szymon","szymanski","111000111","admin","admin",true));
        uzytkowniks.add(new Uzytkownik("mateusz","maniak","123456789","leszcz","leszcz",false));
    }
}
