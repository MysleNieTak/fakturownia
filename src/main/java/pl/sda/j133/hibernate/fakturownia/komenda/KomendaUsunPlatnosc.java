package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Platnosc;

public class KomendaUsunPlatnosc implements Komenda {

    private DataAccessObject<Platnosc> dataAccessObject;

    public KomendaUsunPlatnosc(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun platnosc";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanej platnosci: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);


        if(dataAccessObject.delete(Platnosc.class,id)){
            System.out.println("Usunięto płatność");
        } else {
            System.err.println("Nie udało się usunąć płatności");
        }
    }
}
