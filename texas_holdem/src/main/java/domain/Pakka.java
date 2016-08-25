package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luokka luo ja hallitsee 52 kortista tehtyä listaa.
 */
public class Pakka {

    private List<Kortti> pakka;

    /**
     * Konstruktori.
     */
    public Pakka() {
        this.pakka = new ArrayList();

        for (Maa m : Maa.values()) {
            for (Arvo a : Arvo.values()) {

                pakka.add(new Kortti(m, a));
            }
        }

    }

    public int getKoko() {
        return this.pakka.size();
    }

    public List<Kortti> getPakka() {
        return this.pakka;
    }
    /**
     * Sekoittaa pakan.
     */
    public void sekoitus() {
        Collections.shuffle(pakka);
    }

    /**
     * Antaa ensimmäisenä olevan kortin pois.
     * @return Kortti-olio joka listan ensimmäisenä
     * @throws Exception Jos ei onnistu 
     */
    public Kortti jaa() throws Exception {
        Kortti k = this.pakka.get(0);
        pakka.remove(0);
        if (k != null) {
            return k;
        }
        return null;
    }

    @Override
    public String toString() {
        String p = "";
        for (Kortti k : pakka) {
            System.out.println(k);
            p += k + " ";
        }
        return p;
    }

}
