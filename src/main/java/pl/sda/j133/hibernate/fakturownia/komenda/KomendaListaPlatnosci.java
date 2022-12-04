package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;
import pl.sda.j133.hibernate.fakturownia.model.Platnosc;

import java.util.List;

public class KomendaListaPlatnosci implements Komenda {

    private DataAccessObject<Platnosc> dataAccessObject;

    public KomendaListaPlatnosci(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista platnosci";
    }

    @Override
    public void obsluga() {

        List<Platnosc> platnosci = dataAccessObject.findAll(Platnosc.class);
        platnosci.forEach(System.out::println);
    }



}
