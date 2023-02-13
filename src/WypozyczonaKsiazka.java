import java.time.LocalDate;
import java.util.ArrayList;

public class WypozyczonaKsiazka {
    private Uzytkownik uzytkownik;
    private Ksiazka ksiazka;
    private LocalDate terminOddania;

    public WypozyczonaKsiazka(Uzytkownik uzytkownik, Ksiazka ksiazka, LocalDate terminOddania) {
        this.uzytkownik = uzytkownik;
        this.ksiazka = ksiazka;
        this.terminOddania = terminOddania;
    }

    public static ArrayList<WypozyczonaKsiazka> wypozyczonaKsiazkas = new ArrayList<>();
}
