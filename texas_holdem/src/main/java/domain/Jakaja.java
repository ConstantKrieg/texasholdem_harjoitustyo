package domain;

import java.util.List;
import sovellus.Peli;

public class Jakaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public Jakaja() {
        super();
    }

    public boolean mahtuukoPoytaan() {
        if (this.kasi.getKadenArvo() > 2) {
            return true;
        } else if (this.kasi.getKadenArvo() == 2) {
            if (this.getKorkeinKortti() > 3) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void maksaVoitot(Peli p) {
        if(p.getVoittaja() == 2){
            if(p.getPlayer().getKasi().getKadenArvo() < 6){
                p.getPlayer().vastaanotaVoitot(p.getAnte() * 2);
            }
        }
    }

}
