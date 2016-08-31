/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.domain.Kasi;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Osallistuja;
import java.util.ArrayList;
import java.util.List;


/*
 * @author Kim KÃ¤yttÃ¤Ã¤ vertailu-oliotaan asettamaan kÃ¤det.
 */
public class KadenTarkistaja {

    private Vertailu vertailu;

    /**
     * Konstruktori.
     *
     * @param v Vertailu-olio
     */
    public KadenTarkistaja(Vertailu v) {
        this.vertailu = v;
    }

    /**
     * Tarkistaa muiden metodien avulla mikä käsi osallistujalla on.
     *
     * @param o Osallistuja jonka kÃ¤si tarkistetaan
     */
    public void tarkistaKasi(Osallistuja o) {
        List<Kortti> kortit = vertailu.getGame().kaikkiKortit(o.getTaskut(), vertailu.getGame().getTable().getKortit());
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
        if (vertailu.tarkistaSamat(2, kortit) > 0) {
            k = Kasi.PARI;
            o.setKasi(k);
            o.setKorkeinKortti(vertailu.tarkistaSamat(2, kortit));
        }
    }

    private void tarkistaKolmoset(Osallistuja o, List<Kortti> kortit, Kasi k) {

        if (vertailu.tarkistaSamat(3, kortit) > 0) {
            k = Kasi.KOLMOSET;
            o.setKasi(k);
            o.setKorkeinKortti(vertailu.tarkistaSamat(3, kortit));
        }

    }

    private void tarkistaKaksiParia(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int[] kp = vertailu.tarkistaKaksiParia(kortit);
        if (kp[0] > 0 && kp[1] > 0) {
            k = Kasi.KAKSIPARIA;
            o.setKasi(k);
            o.setKorkeinKortti(kp[0]);
        }
    }

    private void tarkistaSuora(Osallistuja o, List<Kortti> kortit, Kasi k) {
        if (vertailu.onkoSuora(kortit) > 0) {
            k = Kasi.SUORA;
            o.setKasi(k);
            o.setKorkeinKortti(vertailu.onkoSuora(kortit));
        }
    }

    private void tarkistaVari(Osallistuja o, List<Kortti> kortit, Kasi k) {
        List<Kortti> apuLista = new ArrayList();
        apuLista = vertailu.tarkistaVari(kortit);
        if (!apuLista.isEmpty()) {
            k = Kasi.VARI;
            o.setKasi(k);
            o.setKorkeinKortti(apuLista.get(0).getArvo());
        }
    }

    private void tarkistaTayskasi(Osallistuja o, List<Kortti> kortit, Kasi k) {
        int[] tk = vertailu.tarkistaTayskasi(kortit);
        if (tk[0] > 0 && tk[1] > 0) {
            k = Kasi.TAYSKASI;
            o.setKasi(k);
            o.setKorkeinKortti(tk[0]);
        }
    }

    private void tarkistaNeloset(Osallistuja o, List<Kortti> kortit, Kasi k) {
        if (vertailu.tarkistaSamat(4, kortit) > 0) {
            k = Kasi.NELOSET;
            o.setKasi(k);
            o.setKorkeinKortti(vertailu.tarkistaSamat(4, kortit));
        }
    }

    private void tarkistaVarisuora(Osallistuja o, List<Kortti> kortit, Kasi k) {
        if (vertailu.tarkistaVarisuora(kortit) > 0) {
            k = Kasi.VARISUORA;
            o.setKasi(k);
            o.setKorkeinKortti(vertailu.tarkistaVarisuora(kortit));
        }
    }
}
