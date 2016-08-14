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

/**
 *
 * @author Kim
 * Käyttää vertailu-oliotaan laittamaan oikean käden oikealle osallistujalle
 */
public class KadenTarkistaja {
    
    private Vertailu v;
    
    
    public KadenTarkistaja(Vertailu v){
        this.v = v;
    }
    
    
    public void tarkistaKasi(Osallistuja o) { //Metodimonsteri mutta en keksinyt muitakaan tapoja toteuttaa kuin else if:eillä. Tarkistaa jokaisen mahdollisen käden ja antaa sen osallistujalle.
        List<Kortti> kortit = kaikkiKortit(o.getTaskut(), v.getGame().getTable().getKortit());
        List<Kortti> apuLista = new ArrayList();
        Kasi k = Kasi.KICKER;

        int x = v.tarkistaSamat(2, kortit);
        if (x > 0) {
            k = Kasi.PARI;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        int[] kp = v.tarkistaKaksiParia(kortit);
        if (kp[0] > 0 && kp[1] > 0) {
            k = Kasi.KAKSIPARIA;
            o.setKasi(k);
            o.setKorkeinKortti(kp[0]);
        }
        x = v.tarkistaSamat(3, kortit);
        if (x > 0) {
            k = Kasi.KOLMOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        x = v.onkoSuora(kortit);
        if (x > 0) {
            k = Kasi.SUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        apuLista = v.tarkistaVari(kortit);
        if (!apuLista.isEmpty()) {
            k = Kasi.VARI;
            o.setKasi(k);
            o.setKorkeinKortti(apuLista.get(0).getArvo());
        }
        int[] tk = v.tarkistaTayskasi(kortit);
        if (tk[0] > 0 && tk[1] > 0) {
            k = Kasi.TAYSKASI;
            o.setKasi(k);
            o.setKorkeinKortti(tk[0]);
        }
        x = v.tarkistaSamat(4, kortit);
        if (x > 0) {
            k = Kasi.NELOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        x = v.tarkistaVarisuora(kortit);
        if (x > 0) {
            k = Kasi.VARISUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }
    
   
    
}
