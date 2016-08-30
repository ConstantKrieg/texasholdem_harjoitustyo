package casinoholdem;

import javax.swing.SwingUtilities;
import casinoholdem.gui.Kayttoliittyma;

public class Main {

    /**
     * Pääluokka.
     */
    public static void main(String[] args) throws Exception {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
