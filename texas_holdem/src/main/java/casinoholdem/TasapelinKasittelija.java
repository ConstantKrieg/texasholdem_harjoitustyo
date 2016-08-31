/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.domain.Jakaja;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Pelaaja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import casinoholdem.domain.Kasi;

/*
 * @author Kim Luokka toteuttaa metodin kaynnistaTarkistus.
 */
public class TasapelinKasittelija {

    private Peli p;
    private Jakaja jakaja;
    private Pelaaja pelaaja;
    private Vertailu vertailu;

    /**
     * Konstruktori.
     *
     * @param p Peli jossa tasapeli tapahtunut
     * @param v Vertailu jota käytetään
     */
    public TasapelinKasittelija(Peli p, Vertailu v) {
        this.p = p;
        this.jakaja = this.p.getDealer();
        this.pelaaja = this.p.getPlayer();
        this.vertailu = v;
    }

    /**
     * Metodi käy läpi kaikki eri käsien arvot private metodeilla ja palauttaa
     * kokonaisluvun sitä mukaan kumpi voittaa.
     *
     * @return Kokonaisluku sen mukaan oliko pelaajalla vai jakajalla korkeampi
     * käsi
     */
    public int kaynnistaTarkistus() {
        List<Kortti> pelaajaKortit = p.kaikkiKortit(this.pelaaja.getTaskut(), p.getTable().getKortit());
        List<Kortti> jakajaKortit = p.kaikkiKortit(this.jakaja.getTaskut(), p.getTable().getKortit());
        if (this.pelaaja.getKorkeinKortti() > this.jakaja.getKorkeinKortti()) {
            return 1;
        } else if (this.pelaaja.getKorkeinKortti() < this.jakaja.getKorkeinKortti()) {
            return -1;
        } else {
            if (this.jakaja.getKasi().equals(Kasi.KICKER)) {
                return tieBreakerKickerilla(pelaajaKortit, jakajaKortit, 5);
            } else if ((this.jakaja.getKasi().equals(Kasi.PARI) || this.jakaja.getKasi().equals(Kasi.KOLMOSET) || this.jakaja.getKasi().equals(Kasi.NELOSET))) {
                return tieBreakerSamoillaKorteilla(pelaajaKortit, jakajaKortit);
            } else if (this.jakaja.getKasi().equals(Kasi.VARI)) { //Suoraa en tarkista koska jos molemmilla suora ja korkein kortti samanarvoinen on peli aina tasapeli. Sama pätee värisuorassa.
                return tieBreakerVarilla(pelaajaKortit, jakajaKortit);
            } else if (this.jakaja.getKasi().equals(Kasi.KAKSIPARIA) || this.jakaja.getKasi().equals(Kasi.TAYSKASI)) {
                return tieBreakerKahdellaParillaJaTayskadella();
            }
        }
        return 0;
    }

    private static int tieBreakerKickerilla(List<Kortti> p2, List<Kortti> j2, int koko) {
        int apu = 0;
        Collections.sort(p2);
        Collections.sort(j2);
        for (int i = 0; i < koko; i++) {
            if (p2.get(i).getArvo() > j2.get(i).getArvo()) {
                return 1;
            } else if (p2.get(i).getArvo() < j2.get(i).getArvo()) {
                return -1;
            }
        }
        return 0;
    }

    private int tieBreakerVarilla(List<Kortti> pK, List<Kortti> jK) {
        List<Kortti> pelaajaVari = vertailu.tarkistaVari(pK);
        List<Kortti> jakajaVari = vertailu.tarkistaVari(jK);
        Collections.sort(pelaajaVari);
        Collections.sort(jakajaVari);

        for (int i = 0; i < 5; i++) {
            if (pelaajaVari.get(i).getArvo() > jakajaVari.get(i).getArvo()) {
                return 1;
            } else if (pelaajaVari.get(i).getArvo() < jakajaVari.get(i).getArvo()) {
                return -1;
            }
        }
        return 0;
    }

    private int tieBreakerKahdellaParillaJaTayskadella() {
        List<Kortti> pelaajaKortit = p.kaikkiKortit(pelaaja.getTaskut(), p.getTable().getKortit()); //Luo siksi uuden olion jottei poistaKorkeimmat-metodi vaikuta muihin tarkistuksiin.
        List<Kortti> jakajaKortit = p.kaikkiKortit(jakaja.getTaskut(), p.getTable().getKortit());

        poistaKorkeimmat(pelaajaKortit, jakajaKortit);
        if (vertailu.tarkistaSamat(2, jakajaKortit) > vertailu.tarkistaSamat(2, pelaajaKortit)) {
            return -1;
        } else if (vertailu.tarkistaSamat(2, jakajaKortit) < vertailu.tarkistaSamat(2, pelaajaKortit)) {
            return 1;
        } else if (vertailu.tarkistaSamat(2, jakajaKortit) == vertailu.tarkistaSamat(2, pelaajaKortit) && this.jakaja.getKasi().getKadenArvo() == 3) {
            poistaKorkeimmat(pelaajaKortit, jakajaKortit);
            return tieBreakerKickerilla(pelaajaKortit, jakajaKortit, 1);
        }

        return 0;
    }

    private int tieBreakerSamoillaKorteilla(List<Kortti> pelaaja, List<Kortti> jakaja) {
        int apu = 0;
        int koko = 0;
        if (this.pelaaja.getKasi().getKadenArvo() == 2) {
            koko = 3;
        } else if (this.pelaaja.getKasi().getKadenArvo() == 4) {
            koko = 2;
        } else if (this.pelaaja.getKasi().getKadenArvo() == 8) {
            koko = 1;
        }
        poistaKorkeimmat(pelaaja, jakaja);
        return tieBreakerKickerilla(pelaaja, jakaja, koko);
    }

    private void poistaKorkeimmat(List<Kortti> p2, List<Kortti> j2) {
        List<Kortti> poistettavat = new ArrayList();
        List<Kortti> poistettavat2 = new ArrayList();

        for (Kortti k1 : p2) {
            if (k1.getArvo() == pelaaja.getKorkeinKortti()) {
                poistettavat.add(k1);
            }
        }
        for (Kortti k2 : j2) {
            if (k2.getArvo() == jakaja.getKorkeinKortti()) {
                poistettavat2.add(k2);
            }
        }
        p2.removeAll(poistettavat);
        j2.removeAll(poistettavat2);
    }

}
