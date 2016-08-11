package domain;

import java.util.List;

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

}
