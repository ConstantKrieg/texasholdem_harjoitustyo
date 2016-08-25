/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import domain.Kasi;
import domain.Kortti;
import domain.Osallistuja;
import java.util.ArrayList;
import java.util.List;
import static sovellus.Vertailu.kaikkiKortit;

/*
 * @author Kim Käyttää vertailu-oliotaan asettamaan kädet.
 */
public class KadenTarkistaja {

    private Vertailu v;

    /**
     * Konstruktori.
     * @param v Vertailu-olio
     */
    public KadenTarkistaja(Vertailu v) {
        this.v = v;
    }

    /**
     * Tarkistaa muiden metodien avulla mikä käsi osallistujalla on.
     * @param o Osallistuja jonka käsi tarkistetaan
     */
    public void tarkistaKasi(Osallistuja o) {
        List<Kortti> kortit = kaikkiKortit(o.getTaskut(), v.getGame().getTable().getKortit());
        Kasi k = Kasi.KICKER;

        tarkistaPari(o, kortit, k);
        tarkistaKaksiParia(o, kortit, k);
        tarkistaKolmoset(o, kortit, k);
        tarkistaSuora(o, kortit, k);
        tarkistaVari(o, kortit, k);
        tarkistaTayskasi(o, kortit, k);
        tarkistaNeloset(o, kortit, k);
        tarkistaVarisuora(o, kortit, k);
    }

    private void tarkistaPari(Osallistuja o, List<Kortti> kortit, Kasi k) {

        int x = v.tarkistaSamat(2, kortit);
        if (x > 0) {
            k = Kasi.PARI;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }

    private void tarkistaKolmoset(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int x = v.tarkistaSamat(3, kortit);
        if (x > 0) {
            k = Kasi.KOLMOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }

    }

    private void tarkistaKaksiParia(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int[] kp = v.tarkistaKaksiParia(kortit);
        if (kp[0] > 0 && kp[1] > 0) {
            k = Kasi.KAKSIPARIA;
            o.setKasi(k);
            o.setKorkeinKortti(kp[0]);
        }
    }

    private void tarkistaSuora(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int x = v.onkoSuora(kortit);
        if (x > 0) {
            k = Kasi.SUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }

    private void tarkistaVari(Osallistuja o, List<Kortti> kortit, Kasi k) {
        List<Kortti> apuLista = new ArrayList();
        apuLista = v.tarkistaVari(kortit);
        if (!apuLista.isEmpty()) {
            k = Kasi.VARI;
            o.setKasi(k);
            o.setKorkeinKortti(apuLista.get(0).getArvo());
        }
    }

    private void tarkistaTayskasi(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int[] tk = v.tarkistaTayskasi(kortit);
        if (tk[0] > 0 && tk[1] > 0) {
            k = Kasi.TAYSKASI;
            o.setKasi(k);
            o.setKorkeinKortti(tk[0]);
        }
    }

    private void tarkistaNeloset(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int x = v.tarkistaSamat(4, kortit);
        if (x > 0) {
            k = Kasi.NELOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }

    private void tarkistaVarisuora(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int x = v.tarkistaVarisuora(kortit);
        if (x > 0) {
            k = Kasi.VARISUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }

}
