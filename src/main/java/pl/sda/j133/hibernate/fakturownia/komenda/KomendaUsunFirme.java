package pl.sda.j133.hibernate.fakturownia.komenda;

import org.hibernate.query.sqm.sql.FromClauseIndex;
import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;

public class KomendaUsunFirme implements Komenda {

    private DataAccessObject<Firma> dataAccessObject;

    public KomendaUsunFirme(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun firme";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanej firmy: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);


        if(dataAccessObject.delete(Firma.class,id)){
            System.out.println("Usunięto firme");
        } else {
            System.err.println("Nie udało się usunąć firmy");
        }
    }
}
