package domain;

import java.util.ArrayList;
import java.util.List;

public class Poyta {

    private Kortti[] flop;
    private Kortti turn;
    private Kortti river;

    public Poyta() {
        this.flop = new Kortti[3];
        this.turn = null;
        this.river = null;
    }

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

    public void tulostaFlop() {
        for (int i = 0; i < flop.length; i++) {
            System.out.println(flop[i]);
        }
    }

    public void tulostaTurnJaRiver() {
        System.out.println(turn);
        System.out.println(river);
    }

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
