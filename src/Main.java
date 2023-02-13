import java.awt.image.DataBufferInt;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        menustart();
    }

    public static void menustart()
    {
        Uzytkownik.uzyt();
        Ksiazka.tworzenie_obiektow();

        System.out.println("1. Zaloguj sie");
        System.out.println("2. utworz konto");
        System.out.println("3. wyjdz");
        int wybor = scanner.nextByte();


        if (wybor == 1 || wybor == 2 || wybor == 3)
        {
            switch (wybor)
            {
                case 1 -> Uzytkownik.zaloguj();
                case 2 -> Uzytkownik.utworzKonto();
                case 3 -> System.exit(0);
            }
        }
        else
        {
            System.out.println("wprowadz poprawna liczbe");
            menustart();
        }

    }



}