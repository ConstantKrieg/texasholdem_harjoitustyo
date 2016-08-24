package domain;

import java.util.ArrayList;
import java.util.List;
import static domain.Arvo.KASI;

/*
 * Osallistujan ilmentymä jolla panostusmahdollisuus
 */
public class Pelaaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;
    private int panokset;

    public Pelaaja() {
        super();
        this.panokset = 2000;
    }

    public int getPanokset() {
        return panokset;
    }
    /*
     * Metodi asettaa pelikierrokselle panoksen poistamalla sen pelaajalta
     */

    public boolean panosta(int panos) {
        if(panos  <= this.panokset){
            this.panokset -= panos;
            return true;
        }
        return false;
    }
    
    

    /*
     * Lisää pelaajan panostuksiin luvun
     * @param voitot Voiton määrä
     */
    public void vastaanotaVoitot(int voitot) {
        this.panokset += voitot;
    }

    @Override
    public String toString() {

        return "Pelaaja ";
    }

}
