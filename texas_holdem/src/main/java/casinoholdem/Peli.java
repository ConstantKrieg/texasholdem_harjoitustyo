package casinoholdem;

import casinoholdem.domain.Jakaja;
import casinoholdem.domain.Kasi;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Pakka;
import casinoholdem.domain.Pelaaja;
import casinoholdem.domain.Poyta;

/*
 * @author Kim Luokka toteuttaa kaikki pelin kulkuun vaikuttavat metodit.
 */
public class Peli {

    private Pakka deck;
    private Poyta table;
    private Pelaaja player;
    private Jakaja dealer;
    private int ante;
    private int raise;
    private int voittaja; //jos voittaja on 1 niin pelajaa voittaa ja jos -1 niin jakaja. Jos pelaaja voittaa niin ettei jakaja mahdu pöytään on voittajan arvo 2
    private boolean lisaakoPanosta;
    private int voitto;

    /**
     * Konstruktori joka saa parametrina joitain arvoja ja luo loput tarvittavat oliot ja muuttujat itse.
     * @param pakka Käytettävä pakka
     * @param poyta Käytettävä pöytä
     */
    public Peli(Pakka pakka, Poyta poyta) {
        this.deck = pakka;
        this.table = poyta;
        this.player = new Pelaaja();
        this.dealer = new Jakaja();
        this.ante = 0;
        this.raise = 0;
        this.voittaja = 0;
        this.lisaakoPanosta = false;
        this.voitto = 0;
    }

    public void setVoittaja(int voittaja) {
        this.voittaja = voittaja;
    }

    /**
     * Metodi luo vertailu-ja kädentarkistajaoliot ja käyttämällä näiden
     * metodeja asettaa arvon voittaja-muuttujaan.
     */
    public void paataVoittaja() {
        Vertailu v = new Vertailu(this);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(this);
        kt.tarkistaKasi(player);
        kt.tarkistaKasi(dealer);
        if (dealer.mahtuukoPoytaan() == true) {
            if (player.getKasi().getKadenArvo() > dealer.getKasi().getKadenArvo()) {
                setVoittaja(1);
            } else if (player.getKasi().getKadenArvo() < dealer.getKasi().getKadenArvo()) {
                setVoittaja(-1);
            } else if (player.getKasi().getKadenArvo() == dealer.getKasi().getKadenArvo()) {
                setVoittaja(tk.kaynnistaTarkistus());
            }
        } else {
            this.setVoittaja(2);
        }
    }

    /**
     * Palauttaa poyta-muuttujan.
     * @return Peli-luokan muuttujan table
     */
    public Poyta getTable() {
        return table;
    }

    /**
     * Luo Voitonmaksaja-olion ja käyttää sen metodia maksaVoitot.
     */
    public void maksaVoitot() {
        VoitonMaksaja vm = new VoitonMaksaja(this);
        vm.maksaVoitot();

    }

    /**
     * Metodi käyttää Jakaja- ja Pelaaja-luokkien metodia ja asettaa taskukortit
     * niille. Jakaa myös kortit pöytään.
     * @throws Exception Jos pakkaa ei ole luotu tms.
     */
    public void jaaKortit() throws Exception {
        alusta();

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

    private void alusta() {    
        this.deck = new Pakka();
        this.player.getTaskut().clear();
        this.dealer.getTaskut().clear();
        this.table = new Poyta();
        this.player.setKasi(Kasi.KICKER);
        this.dealer.setKasi(Kasi.KICKER);
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
        this.player.panosta(ante);
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

    public int getRaise() {
        return raise;
    }

}
