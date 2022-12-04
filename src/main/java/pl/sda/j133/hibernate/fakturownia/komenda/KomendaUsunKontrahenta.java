package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;

public class KomendaUsunKontrahenta implements Komenda {

    private DataAccessObject<Kontrahent> dataAccessObject;

    public KomendaUsunKontrahenta(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun kontrahenta";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanego kontrahenta: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);


        if(dataAccessObject.delete(Kontrahent.class,id)){
            System.out.println("Usunięto kontrahenta");
        } else {
            System.err.println("Nie udało się usunąć kontrahenta");
        }
    }
}
