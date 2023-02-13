import java.time.LocalDate;
import java.util.Objects;

public class Autor {
    private String imie;
    private String nazwisko;
    private LocalDate data_urodzenia;
    private String pochodzenie;

    public Autor(String imie, String nazwisko, LocalDate data_urodzenia, String pochodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pochodzenie = pochodzenie;
    }

    @Override
    public String toString() {
        return "{ " +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", pochodzenie='" + pochodzenie + '\'' +
                '}';
    }

    public String wyswietl() {
        return imie +" "+ nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(imie, autor.imie) && Objects.equals(nazwisko, autor.nazwisko) && Objects.equals(data_urodzenia, autor.data_urodzenia) && Objects.equals(pochodzenie, autor.pochodzenie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, data_urodzenia, pochodzenie);
    }
}
