/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import domain.Kortti;
import domain.Osallistuja;
import domain.Kasi;
import java.util.List;

/**
 *
 * @author Kim
 */
public class Jakaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public Jakaja() {
        super();
    }

    public boolean mahtuukoPoytaan() {
        boolean palautus = false;

        if (this.kasi.getKadenArvo() > 2) {
            palautus = true;
        } else if (this.kasi.getKadenArvo() == 2) {
            if (this.getKorkeinKortti() >= 4) {
                palautus = true;
            }
        }
        return palautus;
    }

}
