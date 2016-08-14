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

/** @author Kim
 * Luokka toteuttaa kaikki pelin kulkuun vaikuttavat metodit
 */
public class Peli {

    private final Pakka deck;
    private final Poyta table;
    private final Pelaaja player;
    private final Jakaja dealer;
    private int ante;
    private int raise;
    private Scanner lukija;
    private int voittaja; //jos voittaja on 1 niin pelajaa voittaa ja os -1 niin jakaja. Jos pelaaja voittaa niin ettei jakaja mahdu pöytään on voittajan arvo 2

    public Peli(Pakka pakka, Poyta poyta) {
        this.deck = pakka;
        this.table = poyta;
        this.player = new Pelaaja();
        this.dealer = new Jakaja();
        this.ante = 0;
        this.raise = 0;
        this.lukija = new Scanner(System.in);
        this.voittaja = 0;

    }

    public void setVoittaja(int voittaja) {
        this.voittaja = voittaja;
    }

    /**
     * Metodi toteuttaa koko pelin kulun kutsumalla muita metodeja
     */
    public void kaynnista() throws Exception {
        kysyPanos();
        jaaKortit();
        this.tulostaTilanneEnnenJatkoPanostusta(this.player.getTaskut());
        if (lisaatkoPanosta()) {
            this.tulostaLoppuTilanne(this.dealer.getTaskut());
            paataVoittaja();
            this.dealer.maksaVoitot(this);
        } else {
            System.out.println("Luovutit. Häviät alkupanoksen");
        }

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
            } else {
                if (player.getKorkeinKortti() > dealer.getKorkeinKortti()) {
                    this.setVoittaja(1);
                } else if (player.getKorkeinKortti() < dealer.getKorkeinKortti()) {
                    this.setVoittaja(-1);
                } else {
                    this.setVoittaja(v.tieBreakerKickerilla(dealer, player));
                }
            }
        } else {
            this.setVoittaja(2);
        }

    }

    public Poyta getTable() {
        return table;
    }

    public void kysyPanos() {
        while (true) {
            System.out.print("Anna panos (Panoksen oltava välillä 10-500): ");
            int x = Integer.parseInt(lukija.nextLine());

            if (x <= 500 && x >= 10) { //tarkistaa että panostuksen ehdot tayttyvat
                this.ante = x;
                break;
            }
        }
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

    public void tulostaTilanneEnnenJatkoPanostusta(List<Kortti> pelaajanKortit) {
        System.out.println("Pelaajan kortit");
        for (Kortti k : pelaajanKortit) {
            System.out.println(k);
        }
        System.out.println("");
        table.tulostaFlop();
    }

    public void tulostaLoppuTilanne(List<Kortti> jakajanKortit) {
        System.out.println("");
        table.tulostaTurnJaRiver();
        System.out.println("");

        System.out.println("Jakajan kortit");
        for (Kortti k : jakajanKortit) {
            System.out.println(k);
        }

    }

    /**
     * Metodi kysyy pelaajalta panostaako enemman peliin vai luovuttaako
     * @return true tai false sen mukaan laheeko pelaaja mukaan
     */
    public boolean lisaatkoPanosta() {

        System.out.println("Lähdetkö mukaan (k/e)?:");
        while (true) {
            String vastaus = lukija.nextLine();
            if (vastaus.equals("k")) {
                this.raise = 2 * this.ante;
                return true;
            } else if (vastaus.equals("e")) {
                return false;
            } else {
                System.out.println("Vastaukseksi kelpaa vain k tai e ");
            }
        }
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
