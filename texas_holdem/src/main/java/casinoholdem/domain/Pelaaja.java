package casinoholdem.domain;

import casinoholdem.domain.Osallistuja;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Kasi;
import java.util.ArrayList;
import java.util.List;
import static casinoholdem.domain.Arvo.KASI;

/*
 * Osallistujan ilmentymä jolla panostusmahdollisuus
 */
public class Pelaaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;
    private int panokset;

    /**
     * Konstruktori.
     */
    public Pelaaja() {
        super();
        this.panokset = 2000;
    }

    public int getPanokset() {
        return panokset;
    }

    /**
     * Metodi asettaa pelikierrokselle panoksen poistamalla sen pelaajalta.
     *
     * @param panos Panoksen määrä.
     */
    public void panosta(int panos) {
        this.panokset = this.panokset - panos;

    }

    /**
     * Metodi tarkistaa onko panos pelin sääntöjen mukainen sekä onko pelaajalla
     * varaa laittaa näin isoa panosta.
     *
     * @param panos Panoksen määrä.
     * @return true jos panos sopiva ja false muuten.
     */
    public boolean onkoSopivaPanos(int panos) {
        if (panos <= this.panokset / 3 && panos <= 500 && panos > 0) {
            return true;
        } else if (panos > this.panokset / 3 && panos > 500) {
            return false;
        }
        return false;
    }

    /**
     * Lisää pelaajan panostuksiin luvun.
     *
     * @param voitot Voiton määrä
     */
    public void vastaanotaVoitot(int voitot) {
        this.panokset = this.panokset + voitot;
    }

    @Override
    public String toString() {

        return "Pelaaja ";
    }

}
