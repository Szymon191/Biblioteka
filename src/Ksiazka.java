import com.sun.security.jgss.GSSUtil;

import javax.xml.crypto.Data;
import java.security.PrivateKey;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

enum Kategoria {naukowe, dla_dzieci, kryminal, romansidla, biografie,literatura};
enum Format {miekka_okladka, twarda_okladka}
public class Ksiazka {
    private String tytul;
    private String wydawnictwo;
    private LocalDate rok_wydania;
    private String opis;
    private Kategoria kategoria;
    private Autor autor;
    private int liczba_stron;
    private Format format;
    private double cena;
    private boolean wypo;

    public Ksiazka(String tytul, String wydawnictwo, LocalDate rok_wydania, String opis, Kategoria kategoria, Autor autor, int liczba_stron, Format format, double cena,boolean wypo) {
        this.tytul = tytul;
        this.wydawnictwo = wydawnictwo;
        this.rok_wydania = rok_wydania;
        this.opis = opis;
        this.kategoria = kategoria;
        this.autor = autor;
        this.liczba_stron = liczba_stron;
        this.format = format;
        this.cena = cena;
        this.wypo = wypo;
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
                case 1 -> Uzytkownik.menu();
                case 2 -> System.exit(0);
            }
        }

    }



    public void setWypo(boolean wypo) {
        this.wypo = wypo;
    }

    @Override
    public String toString() {
        return "**********************************************************************" +
                "\n * tytul: '" + tytul + '\'' +
                "\n * wydawnictwo: '" + wydawnictwo + '\'' +
                "\n * rok_wydania: " + rok_wydania +
                "\n * opis: '" + opis + '\'' +
                "\n * kategoria: " + kategoria +
                "\n * autor: " + autor +
                "\n * liczba_stron: " + liczba_stron +
                "\n * format: " + format +
                "\n * cena: " + cena +
                "\n * wypozyczona:" + wypo +
                "\n**********************************************************************";
    }

    public String wyswietl() {
        return "***************************************************" +
                "\n * tytul: '" + tytul + '\'' +
                "\n * wydawnictwo: '" + wydawnictwo + '\'' +
                "\n * opis: '" + opis + '\'' +
                "\n * kategoria: " + kategoria +
                "\n * autor: " + autor.wyswietl() +
                "\n * cena: " + cena +
                "\n * wypozyczona: " + wypo +
                "\n***************************************************";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return liczba_stron == ksiazka.liczba_stron && Double.compare(ksiazka.cena, cena) == 0 && Objects.equals(tytul, ksiazka.tytul) && Objects.equals(wydawnictwo, ksiazka.wydawnictwo) && Objects.equals(rok_wydania, ksiazka.rok_wydania) && Objects.equals(opis, ksiazka.opis) && kategoria == ksiazka.kategoria && Objects.equals(autor, ksiazka.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, wydawnictwo, rok_wydania, opis, kategoria, autor, liczba_stron, cena);
    }

    public String getTytul() {
        return tytul;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public Autor getAutor() {
        return autor;
    }



    public static ArrayList<Ksiazka> zbior = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // metoda wyswietlajca wszystkie obiekty
    public static void ksiegozbior()
    {
        for (Ksiazka ksiazka : zbior)
        {
            System.out.println(ksiazka.toString());
            System.out.println("\n");
        }

        PrzydatneMetody.powrot();
    }

    // metoda dodajaca nowy obiekt
    public static void dodaj_ksiazke()
    {

        System.out.println("tytul: ");
        String tytul = PrzydatneMetody.DodajString();

        System.out.println("wydawnictwo: ");
        String wyd = PrzydatneMetody.DodajString();

        System.out.println("rok wydania (yyyy-mm-dd): ");
        LocalDate rokWydania = PrzydatneMetody.data();

        System.out.println("opis: ");
        String opis = PrzydatneMetody.DodajString();

        System.out.println("kategoria (" +
                "1. naukowe," +
                "2. dla_dzieci," +
                "3. kryminal," +
                "4. romansidla," +
                "5. biografie," +
                "6. literatura)" +
                "wybierz opcje: ");
        int wyb = scanner.nextInt();
        System.out.println("podaj imie autora: ");
        String imie = PrzydatneMetody.DodajString();
        System.out.println("podaj nazwisko autora: ");
        String nazwisko = PrzydatneMetody.DodajString();
        System.out.println("podaj date urodzenia autora (yyyy-mm-dd): ");

        LocalDate dataUrodzenia = PrzydatneMetody.data();
        System.out.println("pochodzenie autora");
        String kraj = PrzydatneMetody.DodajString();

        System.out.println("liczba stron");
        int str = scanner.nextInt();
        System.out.println("Format (" +
                "1. miekka okladka," +
                "2. twarda okladka," +
                "   wybierz opcje: ");
        int form = scanner.nextInt();
        System.out.println("cena: ");
        double cena = scanner.nextDouble();

        Ksiazka ksiazkatest = new Ksiazka(tytul,
                wyd,
                rokWydania,
                opis,
                switch (wyb) {case 1 -> Kategoria.naukowe; case 2 -> Kategoria.dla_dzieci; case 3 -> Kategoria.kryminal; case 4 -> Kategoria.romansidla; case 5 -> Kategoria.biografie; case 6 -> Kategoria.literatura;
                    default -> throw new IllegalStateException("Unexpected value: " + wyb);
                },
                new Autor(imie,nazwisko,dataUrodzenia,kraj),
                str,
                switch (form) {case 1 -> Format.miekka_okladka; case 2 -> Format.twarda_okladka;
                    default -> throw new IllegalStateException("Unexpected value: " + form);
                },
                cena,
                false
        );

        for (Ksiazka ks : zbior)
        {
            if(ks.equals(ksiazkatest)) {
                System.out.println("taka ksiazka juz istnieje w naszej bibliotece");
            }
        }
        zbior.add(ksiazkatest);


        PrzydatneMetody.powrot();
    }


    // metoda usuwajaca obiekt
    public static void usun_ksiazke()
    {
        System.out.println("podaj tytul ksiazki ktora chcesz usunac: ");
        String tyt = PrzydatneMetody.DodajString();
        int i=0;
        int z=0;
        for (Ksiazka ks : zbior)
        {
            i++;
            if (tyt.equals(ks.getTytul()))
            {
                z=1;
                break;
            }

        }
        if (z==1)
        {
            zbior.remove(i-1);
        }
        else {
            throw new RuntimeException("nie posiadamy takiej ksiazki w bibliocete");
        }


        PrzydatneMetody.powrot();
    }


    //metoda pozwalajaca wyszukac obiekt po tytule wydawictwie lub autorze
    public static void wyszukaj_ksiazke()
    {
        System.out.println("podaj tytul, wydawnictwo lub autora ksiazki");
        String wysz="";
        while (wysz.isEmpty())
        {
            wysz = scanner.nextLine();
        }
        wysz=wysz.toLowerCase();
        int i=0;
        int z=0;
        for (Ksiazka ks : zbior)
        {
            if(wysz.equals(ks.getTytul().toLowerCase()) || wysz.equals(ks.getWydawnictwo().toLowerCase()) || wysz.equals(ks.getAutor().getImie().toLowerCase()) || wysz.equals(ks.getAutor().getNazwisko().toLowerCase()) || wysz.equals(ks.getAutor().wyswietl().toLowerCase())) {
                z = 1;
                break;
            }
            i++;
        }
        if (z==1)
        {
            System.out.println(zbior.get(i).wyswietl());
        }
        else
        {
            System.out.println("nie posiadamy takiej ksiazki");
        }

        PrzydatneMetody.powrot();
    }


    public static void wypozycz()
    {
        System.out.println("podaj tytul ksiazki ktora chcesz wypozyczyc");
        String tyt = PrzydatneMetody.DodajString();
        tyt=tyt.toLowerCase();
        int i=0;
        int z=0;
        for (Ksiazka ks : zbior)
        {
            if(tyt.equals(ks.getTytul().toLowerCase())) {
                z = 1;
                break;
            }
            i++;
        }
        if (z==1)
        {
            wypoo(z,i);
            System.out.println("Ksiazka");
        }
        else
        {
            System.out.println("nie posiadamy takiej ksiazki");
        }



        PrzydatneMetody.powrot();

    }
    public static void wypoo(int z,int t)
    {
        System.out.println("podaj nr tel osoby wypozyczajacej");
        String tel=PrzydatneMetody.dodajNrTel();
        System.out.println("podaj termin oddania ksiazki (yyyy-mm-dd): ");
        LocalDate terminOddania = PrzydatneMetody.data();
        int c=0;
        for (Uzytkownik u : Uzytkownik.uzytkowniks)
        {
            c++;
            if(tel.equals(u.getNr_tel()))
            {
                zbior.get(z).setWypo(true);
                WypozyczonaKsiazka.wypozyczonaKsiazkas.add(new WypozyczonaKsiazka(
                        Uzytkownik.uzytkowniks.get(c).getImie(),
                        Uzytkownik.uzytkowniks.get(c).getNazwisko(),
                        Uzytkownik.uzytkowniks.get(c).getNr_tel(),
                        zbior.get(t).getTytul(),
                        LocalDate.of(PrzydatneMetody.data())));
                //wypozyczona.add(terminOddania);
                System.out.println("dziala");
                break;
            }
            else
            {
                System.out.println("nie ma uzytkownika z takim nr tel ");
                break;
            }
        }
    }


    public static void tworzenie_obiektow()
    {
        Ksiazka.zbior.add(new Ksiazka("The Catcher in the Rye",
                "Little, Brown and Company",
                LocalDate.of(2000,1,1),
                " Historia o 16-letnim Holdenie Caulfieldzie, który próbuje zrozumieć i oswoić otaczający go świat",
                Kategoria.literatura,
                new Autor("J.D","Salinger", LocalDate.of(1975,1,1), "USA"),
                277,
                Format.miekka_okladka,
                19.99,
                false));

        Ksiazka.zbior.add(new Ksiazka("1984",
                "Secker & Warburg",
                LocalDate.of(1949,2,2),
                "Oparty na fikcyjnym świecie przyszłości, opowiada o partii totalitarnej, rządzącej Oceanią i kontrolowanej przez Big Brothera",
                Kategoria.naukowe,
                new Autor("George","Orwell",LocalDate.of(1920,1,1),"Anglia"),
                328,
                Format.miekka_okladka,
                15.99,
                true));

        Ksiazka.zbior.add(new Ksiazka("To Kill a Mockingbird",
                "J.B. Lippincott & Co.",
                LocalDate.of(1960,3,3),
                "Historia Scout, jej brata Jem i ich ojca Atticusa w czasach segregacji rasowej w małym miasteczku w południowych Stanach Zjednoczonych",
                Kategoria.kryminal,
                new Autor("Harper","Lee", LocalDate.of(1926,4,28),"USA"),
                281,
                Format.miekka_okladka,
                17.99,
                false));

        Ksiazka.zbior.add(new Ksiazka("The Lord of the Rings",
                "George Allen & Unwin",
                LocalDate.of(1954,5,5),
                "Saga o stworach, które próbują powstrzymać ponurego Saurona i jego hordy",
                Kategoria.dla_dzieci,
                new Autor("J.R.R","Tolkien",LocalDate.of(1892,3,1),"Anglia"),
                1178,
                Format.miekka_okladka,
                29.99,
                true));

        Ksiazka.zbior.add(new Ksiazka("Brave New World",
                "Chatto & Windus",
                LocalDate.of(1932,8,21),
                " Futurystyczna powieść o społeczeństwie, w którym kontrola nad ludźmi jest całkowita",
                Kategoria.literatura,
                new Autor("Aldous","Huxley", LocalDate.of(1894,7,23),"USA"),
                288,
                Format.miekka_okladka,
                15.99,
                false));
        Ksiazka.zbior.add(new Ksiazka("test",
                "test",
                LocalDate.of(2000,01,01),
                "test",
                Kategoria.literatura,
                new Autor("test","test",LocalDate.of(2000,01,01),"test"),
                0,
                Format.miekka_okladka,
                0,
                false));
    }

}
