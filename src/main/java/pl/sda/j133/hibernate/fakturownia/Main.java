package pl.sda.j133.hibernate.fakturownia;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.komenda.*;
import pl.sda.j133.hibernate.fakturownia.model.Firma;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Komenda> listaKomend = List.of(
               new KomendaDodajFirme(),
                new KomendaListaFirma(),
                new KomendaUsunFirme(),

                new KomendaDodajKontrahenta(),
                new KomendaListaKontrahent(),
                new KomendaUsunKontrahenta(),

                new KomendaDodajPlatnosc(),
                new KomendaListaPlatnosci(),
                new KomendaUsunPlatnosc()

        );

        String komenda;
        do {

            System.out.println("Lista dostępnych komend: ");
            for (int i = 0; i < listaKomend.size(); i++) {

                // wiersz po wierszu wypiszą się komendy w formie:
                // 1. dodaj X
                // 2. dodaj Y...

                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }

            System.out.println(); // pusta nowa lista, która oddziela poprzednią listę
            komenda = Komenda.SCANNER.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        }while (!komenda.equalsIgnoreCase("exit"));
    }
}
