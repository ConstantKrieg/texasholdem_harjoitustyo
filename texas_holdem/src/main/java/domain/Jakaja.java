package domain;

import java.util.List;
import sovellus.Peli;

public class Jakaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public Jakaja() {
        super();
    }

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
