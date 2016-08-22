package sovellus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import domain.Jakaja;
import domain.Kasi;
import domain.Kortti;
import domain.Osallistuja;
import domain.Pakka;
import domain.Pelaaja;
import domain.Poyta;

/**
 * @author Kim Luokka toteuttaa kaikki pelin kulkuun vaikuttavat metodit
 */
public class Peli {

    private final Pakka deck;
    private final Poyta table;
    private final Pelaaja player;
    private final Jakaja dealer;
    private int ante;
    private int raise;
    private Scanner lukija;
    private int voittaja; //jos voittaja on 1 niin pelajaa voittaa ja jos -1 niin jakaja. Jos pelaaja voittaa niin ettei jakaja mahdu pöytään on voittajan arvo 2
    private boolean lisaakoPanosta;

    public Peli(Pakka pakka, Poyta poyta) {
        this.deck = pakka;
        this.table = poyta;
        this.player = new Pelaaja();
        this.dealer = new Jakaja();
        this.ante = 0;
        this.raise = 0;
        this.lukija = new Scanner(System.in);
        this.voittaja = 0;
        this.lisaakoPanosta = false;
    }

    public void setVoittaja(int voittaja) {
        this.voittaja = voittaja;
    }

    

    /**
     * Metodi luo vertailu-ja kädentarkistajaoliot ja käyttämällä näiden
     * metodeja asettaa arvon voittaja-muuttujaan
     */
    public void paataVoittaja() {
        Vertailu v = new Vertailu(this);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        kt.tarkistaKasi(player);
        kt.tarkistaKasi(dealer);
        if (dealer.mahtuukoPoytaan(this)) {
            if (player.getKasi().getKadenArvo() > dealer.getKasi().getKadenArvo()) {
                this.setVoittaja(1);
            } else if (player.getKasi().getKadenArvo() < dealer.getKasi().getKadenArvo()) {
                this.setVoittaja(-1);
            } else if (player.getKorkeinKortti() > dealer.getKorkeinKortti()) {
                this.setVoittaja(1);
            } else if (player.getKorkeinKortti() < dealer.getKorkeinKortti()) {
                this.setVoittaja(-1);
            } else {
                this.setVoittaja(v.tieBreakerKickerilla(dealer, player));
            }
        } else {
            this.setVoittaja(2);
        }

    }

    public Poyta getTable() {
        return table;
    }

    

    /**
     * Metodi käyttää Jakaja- ja Pelaaja-luokkien metodia ja asettaa taskukortit
     * niille. Jakaa myös kortit pöytään
     */
    public void jaaKortit() throws Exception {
        this.deck.sekoitus();
        for (int i = 0; i < 2; i++) {   //Jakaa taskukortit pelaajalle sekä jakajalle
            this.player.annaKortti(this.deck.jaa());
            this.dealer.annaKortti(this.deck.jaa());
        }
        Kortti x = deck.jaa(); //jakaa flopin
        Kortti y = deck.jaa();
        Kortti z = deck.jaa();
        table.setFlop(x, y, z);
        Kortti turn = deck.jaa();  //jakaa turnin
        table.setTurn(turn);
        Kortti river = deck.jaa(); //jakaa riverin
        table.setRiver(river);
    }

    public void setLisaakoPanosta(boolean lisaakoPanosta) {
        this.lisaakoPanosta = lisaakoPanosta;
    }

    public int getVoittaja() {
        return voittaja;
    }

    public Pakka getDeck() {
        return deck;
    }

    public Pelaaja getPlayer() {
        return player;
    }

    public void setAnte(int ante) {
        this.ante = ante;
    }

    public void setRaise(int raise) {
        this.raise = raise;
    }

    public Jakaja getDealer() {
        return dealer;
    }

    public int getAnte() {
        return ante;
    }

    public Scanner getLukija() {
        return lukija;
    }

    public int getRaise() {
        return raise;
    }

}
