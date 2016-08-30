package casinoholdem.domain;

import casinoholdem.domain.Kortti;
import java.util.ArrayList;
import java.util.List;

/*
 * Luokka pitää sisällään pöytään tulevat kortit
 */
public class Poyta {

    private Kortti[] flop;
    private Kortti turn;
    private Kortti river;

    /**
     * Konstruktori.
     */
    public Poyta() {
        this.flop = new Kortti[3];
        this.turn = null;
        this.river = null;
    }

    /**
     * Asettaa kolme korttia floppiin.
     * @param x Kortti floppiin
     * @param y Kortti floppiin
     * @param z Kortti floppiin
     */
    public void setFlop(Kortti x, Kortti y, Kortti z) {
        this.flop[0] = x;
        this.flop[1] = y;
        this.flop[2] = z;
    }

    public void setTurn(Kortti k) {
        this.turn = k;
    }

    public Kortti[] getFlop() {
        return flop;
    }

    public Kortti getTurn() {
        return turn;
    }

    public Kortti getRiver() {
        return river;
    }

    public void setRiver(Kortti k) {
        this.river = k;
    }

    /**
     * Palauttaa listana pöytäkortit.
     * @return lista korteista
     */
    public List<Kortti> getKortit() {
        List<Kortti> lista = new ArrayList();

        for (Kortti k : flop) {
            lista.add(k);
        }
        lista.add(turn);
        lista.add(river);

        return lista;
    }

}
