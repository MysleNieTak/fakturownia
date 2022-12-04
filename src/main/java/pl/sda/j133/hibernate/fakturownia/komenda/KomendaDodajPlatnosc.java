package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.FormaPlatnosci;
import pl.sda.j133.hibernate.fakturownia.model.Platnosc;

import java.time.LocalDate;

public class KomendaDodajPlatnosc implements Komenda{
    private DataAccessObject<Platnosc> dao = new DataAccessObject<Platnosc>();

    @Override
    public String getKomenda() {
        return "dodaj platnosc";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj kwotę płatności");
        String StringKwota = Komenda.SCANNER.nextLine();
        Double kwota = Double.parseDouble(StringKwota);

        System.out.println("Podaj formę płatności (KARTA/GOTOWKA/PRZELEW)");
        FormaPlatnosci formaPlatnosci =
                FormaPlatnosci.valueOf(Komenda.SCANNER.nextLine());

        System.out.println("Podaj datę realizacji YYYY-MM-DD");
        LocalDate dataRealizacji = LocalDate.parse(Komenda.SCANNER.nextLine());

        Platnosc platnosc = Platnosc.builder()
                .kwota(kwota)
                .formaplatnosci(formaPlatnosci)
                .dataRealizacji(dataRealizacji)
                .build();

        dao.insert(platnosc);
    }
}
