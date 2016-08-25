/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import domain.Jakaja;
import domain.Kortti;
import domain.Pelaaja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static sovellus.Vertailu.kaikkiKortit;

/**
 *
 * @author Kim Luokka toteuttaa metodin kaynnistaTarkistus joka aloitetaan
 * Peli-luokasta mikäli jakajan ja pelaajan kädet ovat samanarvoisia
 */
public class TasapelinKasittelija {

    private Peli p;
    private Jakaja j;
    private Pelaaja pe;

    public TasapelinKasittelija(Peli p) {
        this.p = p;
        this.j = this.p.getDealer();
        this.pe = this.p.getPlayer();
    }

    /**
     * Metodi käy läpi kaikki eri käsien arvot private metodeilla ja palauttaa
     * kokonaisluvun sitä mukaan kumpi voittaa
     *
     * @return Kokonaisluku sen mukaan oliko pelaajalla vai jakajalla korkeampi
     * käsi
     */
    public int kaynnistaTarkistus() {
        List<Kortti> pelaaja = kaikkiKortit(pe.getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = kaikkiKortit(j.getTaskut(), p.getTable().getKortit());
        int palautus = 0;
        if (this.pe.getKorkeinKortti() > this.j.getKorkeinKortti()) {
            palautus = 1;
        } else if (this.pe.getKorkeinKortti() < this.j.getKorkeinKortti()) {
            palautus = -1;
        } else {
            if (this.j.getKasi().getKadenArvo() == 1) {
                palautus = tieBreakerKickerilla(pelaaja, jakaja, 5);
            } else if ((this.j.getKasi().getKadenArvo() == 2 || this.j.getKasi().getKadenArvo() == 4 || this.j.getKasi().getKadenArvo() == 8) && this.j.getKorkeinKortti() == this.pe.getKorkeinKortti()) {
                palautus = tieBreakerSamoillaKorteilla(pelaaja, jakaja);
            } else if (this.j.getKasi().getKadenArvo() == 5 || this.j.getKasi().getKadenArvo() == 6 || this.j.getKasi().getKadenArvo() == 9) {
                palautus = tieBreakerSuorallaJaVarilla();
            } else if (this.j.getKasi().getKadenArvo() == 3 || this.j.getKasi().getKadenArvo() == 7) {
                palautus = tieBreakerKahdellaParillaJaTayskadella();
            }
        }

        return palautus;
    }

    private int tieBreakerKickerilla(List<Kortti> p2, List<Kortti> j2, int koko) {
        int apu = 0;

        Collections.sort(p2);
        Collections.sort(j2);

        for (int i = 0; i < koko; i++) {
            if (p2.get(i).getArvo() > j2.get(i).getArvo()) {
                apu = 1;
            } else if (p2.get(i).getArvo() < j2.get(i).getArvo()) {
                apu = -1;
            }
        }
        return apu;
    }

    private int tieBreakerSuorallaJaVarilla() {
        int apu = 0;

        if (this.pe.getKorkeinKortti() > this.j.getKorkeinKortti()) {
            return 1;
        } else if (this.pe.getKorkeinKortti() < this.j.getKorkeinKortti()) {
            return -1;
        } else if (this.pe.getKorkeinKortti() == this.j.getKorkeinKortti()) {
            return 0;
        }
        return 0;
    }

    private int tieBreakerKahdellaParillaJaTayskadella() {
        int apu = 0;
        Vertailu v = new Vertailu(this.p);
        List<Kortti> pelaaja = kaikkiKortit(pe.getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = kaikkiKortit(j.getTaskut(), p.getTable().getKortit());

        if (this.pe.getKorkeinKortti() > this.j.getKorkeinKortti()) {
            apu = 1;
        } else if (this.pe.getKorkeinKortti() < this.j.getKorkeinKortti()) {
            apu = -1;
        } else if (this.pe.getKorkeinKortti() == this.j.getKorkeinKortti()) {
            poistaKorkeimmat(pelaaja, jakaja);
            if (v.tarkistaSamat(2, jakaja) > v.tarkistaSamat(2, pelaaja)) {
                apu = -1;
            } else if (v.tarkistaSamat(2, jakaja) < v.tarkistaSamat(2, pelaaja)) {
                apu = 1;

            }
        }
        return apu;
    }

    private int tieBreakerSamoillaKorteilla(List<Kortti> pelaaja, List<Kortti> jakaja) {
        int apu = 0;
        int koko = 0;
        if (this.pe.getKasi().getKadenArvo() == 2) {
            koko = 3;
        } else if (this.pe.getKasi().getKadenArvo() == 4) {
            koko = 2;
        } else if (this.pe.getKasi().getKadenArvo() == 8) {
            koko = 1;
        }
        poistaKorkeimmat(pelaaja, jakaja);
        apu = tieBreakerKickerilla(pelaaja, jakaja, koko);

        return apu;
    }

    private void poistaKorkeimmat(List<Kortti> p2, List<Kortti> j2) {
        List<Kortti> poistettavat = new ArrayList();

        for (Kortti k1 : p2) {
            if (k1.getArvo() == pe.getKorkeinKortti()) {
                poistettavat.add(k1);
            }
        }
        p2.removeAll(poistettavat);
        j2.removeAll(poistettavat);
    }

}
