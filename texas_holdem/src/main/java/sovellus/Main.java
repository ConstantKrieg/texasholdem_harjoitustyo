package sovellus;

import domain.Kortti;
import domain.Pakka;
import domain.Poyta;
import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;

public class Main {

    /**
     * Pääluokka.
     */
    public static void main(String[] args) throws Exception {

//        Pakka pakka = new Pakka();
//        Poyta poyta = new Poyta();
//        
//        Peli peli = new Peli (pakka,poyta);
//        
//        peli.kaynnista();
//        String symbol = "\u2202";
//        System.out.println(symbol);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
