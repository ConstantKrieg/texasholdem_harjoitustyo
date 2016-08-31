package casinoholdem.domain;

import java.util.List;
import casinoholdem.Peli;

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
     * Metodi tarkistaa onko jakajan käsi tarpeeksi hyvä pääsemään mukaan
     * peliin.
     *
     * @return Boolean sitä mukaa pitääkö väite paikkansa
     */
    public boolean mahtuukoPoytaan() {
        if (this.getKasi().getKadenArvo() > 2) {
            return true;
        } else if (this.getKasi().getKadenArvo() == 2 && this.getKorkeinKortti() > 3) {
            return true;
        }
        return false;
    }
}
