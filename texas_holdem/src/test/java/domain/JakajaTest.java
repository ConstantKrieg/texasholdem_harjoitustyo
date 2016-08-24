/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Kortti;
import domain.Osallistuja;
import domain.Kasi;
import java.util.List;

/**
 *
 * @author Kim Luokka luo ilmentymän osallistujasta jolla ei ole
 * panostusmahdollisuutta ja tarvitsee tietyn suuruisen käden päästäkseen
 * pöytään
 */
public class JakajaTest extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public JakajaTest() {
        super();
    }

    /*
     * Tarkistaa onko jakajan käsi tarpeeksi hyvä mahtuakseen pöytään
     */
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
