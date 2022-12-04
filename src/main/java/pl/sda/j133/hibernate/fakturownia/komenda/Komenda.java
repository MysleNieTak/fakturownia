package pl.sda.j133.hibernate.fakturownia.komenda;

import java.util.Scanner;

public interface Komenda {

    Scanner SCANNER = new Scanner(System.in);
    String getKomenda ();
    void obsluga();
}
