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

public class Peli {

    private final Pakka deck;
    private final Poyta table;
    private final Pelaaja player;
    private final Jakaja dealer;
    private int ante;
    private int raise;
    private Scanner lukija;

    public Peli(Pakka pakka, Poyta poyta) {
        this.deck = pakka;
        this.table = poyta;
        this.player = new Pelaaja();
        this.dealer = new Jakaja();
        this.ante = 0;
        this.raise = 0;
        this.lukija = new Scanner(System.in);

    }

    public Poyta getTable() {
        return table;
    }

    public void kysyPanos() {

        while (true) {
            System.out.print("Anna panos (Panoksen oltava parillinen sekä välillä 10-500): ");
            int x = Integer.parseInt(lukija.nextLine());

            if (x <= 500 && x >= 10 && x % 2 == 0) { //tarkistaa että panostuksen ehdot tayttyvat
                this.ante = x;
                break;
            }

        }
    }

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

        for (Kortti k : pelaajanKortit) {
            System.out.println(k);
        }
        table.tulostaFlop();
    }

    public void tulostaLoppuTilanne(List<Kortti> jakajanKortit) {

        for (Kortti k : jakajanKortit) {
            System.out.println(k);
        }
        table.tulostaTurnJaRiver();
    }

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
