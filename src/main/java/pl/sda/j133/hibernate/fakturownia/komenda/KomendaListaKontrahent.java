package pl.sda.j133.hibernate.fakturownia.komenda;

import pl.sda.j133.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturownia.model.Firma;
import pl.sda.j133.hibernate.fakturownia.model.Kontrahent;

import java.util.List;

public class KomendaListaKontrahent implements Komenda {

    private DataAccessObject<Kontrahent> dataAccessObject;

    public KomendaListaKontrahent(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista kontrahentow";
    }

    @Override
    public void obsluga() {

        List<Kontrahent> kontrahenci = dataAccessObject.findAll(Kontrahent.class);
        kontrahenci.forEach(System.out::println);
    }



}
