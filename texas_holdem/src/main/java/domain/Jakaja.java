package domain;

import java.util.List;
import sovellus.Peli;

public class Jakaja extends Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public Jakaja() {
        super();
    }

    public boolean mahtuukoPoytaan(Peli p) {
        if (p.getDealer().getKasi().getKadenArvo() > 2) {
            return true;
        } else if (p.getDealer().getKasi().getKadenArvo() == 2) {
            if (p.getDealer().getKorkeinKortti() > 3) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int maksaVoitot(Peli p) {
        int voitto = 0;
        int veto = 0;
        if (p.getVoittaja() == 1) { //tarkistaa onko jakaja pöydässä. Jos on niin maksaa myös raisen 1:1 suhteella.
            veto = p.getRaise() * 2;
        }
        if (p.getVoittaja() > 0) {        //Maksaa voittotaulukon mukaisesti voitot tarkistettuaan käden arvon
            if (p.getPlayer().getKasi().getKadenArvo() < 6) {
                voitto = p.getAnte() * 2 + veto;
                p.getPlayer().vastaanotaVoitot(voitto);
            } else if (p.getPlayer().getKasi().getKadenArvo() == 6) {
                voitto = p.getAnte() * 3 + veto;
                p.getPlayer().vastaanotaVoitot(voitto);
            } else if (p.getPlayer().getKasi().getKadenArvo() == 7) {
                voitto = p.getAnte() * 4 + veto;
                p.getPlayer().vastaanotaVoitot(voitto);
            } else if (p.getPlayer().getKasi().getKadenArvo() == 8) {
                voitto = p.getAnte() * 11 + veto;
                p.getPlayer().vastaanotaVoitot(voitto);
            } else if (p.getPlayer().getKasi().getKadenArvo() == 9) {
                voitto = p.getAnte() * 51 + veto;
                p.getPlayer().vastaanotaVoitot(voitto);
            } else if (p.getPlayer().getKasi().getKadenArvo() == 9 && p.getPlayer().getKorkeinKortti() == 14) {
                voitto = p.getAnte() * 101 + veto;
            }
        } else if (p.getVoittaja() == 0) {
            if (p.getRaise() > 0) {
                voitto = p.getAnte() + p.getRaise();
                p.getPlayer().vastaanotaVoitot(voitto);
            } else {
                voitto = p.getAnte();
                p.getPlayer().vastaanotaVoitot(p.getAnte());
            }
        } else {
            System.out.println("Jakaja voittaa");
        }
        return voitto;
    }
}
