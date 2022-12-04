package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;

public class KomendaDodajKontrahenta implements Komenda{
    private DataAccessObject<Kontrahent> dao = new DataAccessObject<Kontrahent>();

    @Override
    public String getKomenda() {
        return "dodaj kontrahenta";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj nazwę kontrahenta");
        String nazwa = Komenda.SCANNER.nextLine();

        System.out.println("Podaj nip kontrahenta");
        String nip = Komenda.SCANNER.nextLine();

        System.out.println("Podaj adres kontrahenta");
        String adres = Komenda.SCANNER.nextLine();

        Kontrahent kontrahent = Kontrahent.builder()
                .adres(adres)
                .nip(nip)
                .nazwa(nazwa)
                .build();

        dao.insert(kontrahent);
    }
}
