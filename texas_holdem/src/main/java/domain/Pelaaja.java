package domain;

import java.util.ArrayList;
import java.util.List;
import static domain.Arvo.KASI;

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

    public void panosta(int panos) {
        this.panokset -= panos;
    }

    public void vastaanotaVoitot(int voitot) {
        this.panokset += voitot;
    }

    @Override
    public String toString() {

        return "Pelaaja ";
    }

}