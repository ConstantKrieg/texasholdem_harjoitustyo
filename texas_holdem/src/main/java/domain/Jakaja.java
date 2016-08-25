package domain;

import java.util.List;
import sovellus.Peli;

public class Jakaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    /**
     * Luokka toteuttaa Jakaja-olion.
     */
    public Jakaja() {
        super();
    }

    /**
     * Metodi tarkistaa onko jakajan käsi tarpeeksi hyvä pääsemään mukaan peliin.
     * @param p Peli jota käsitellään
     * @return Boolean sitä mukaa pitääkö väite paikkansa
     */
    public boolean mahtuukoPoytaan(Peli p) {
        if (p.getDealer().getKasi().getKadenArvo() > 2) {
            return true;
        } else if (p.getDealer().getKasi().getKadenArvo() == 2) {
            if (p.getDealer().getKorkeinKortti() > 3) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
