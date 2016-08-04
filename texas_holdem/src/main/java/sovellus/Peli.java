package sovellus;

import java.util.ArrayList;
import java.util.List;
import sovelluslogiikka.Kortti;
import sovelluslogiikka.Pakka;
import sovelluslogiikka.Pelaaja;
import sovelluslogiikka.Poyta;

public class Peli {

    private Pakka deck;
    private Poyta table;
    private List<Pelaaja> players;
    private int pelaajaMaara;

    public Peli(Pakka pakka, Poyta poyta, int pelaajamaara) {
        this.deck = pakka;
        this.table = poyta;
        this.players = new ArrayList();
        this.pelaajaMaara = pelaajamaara;

    }

    public List<Pelaaja> getPlayers() {
        return players;
    }

    public void alustaPelaajat() {
        for (int i = 0; i < this.pelaajaMaara; i++) {
            this.players.add(new Pelaaja(i));

        }
    }

    public void jaaKortit() throws Exception {

        this.deck.sekoitus();
        for (int i = 0; i < 2; i++) { //Kierrokset ovat tässä tapauksessa 0 ja 1 koska Pelaaja-luokalla on atrribuuttina taulukko jonka indeksit menevät niin
            for (Pelaaja p : players) {
                Kortti k = deck.jaa();
                p.annaKortti(k);
            }
        }
        deck.poltaKortti();
        Kortti x = deck.jaa(); //jakaa flopin
        Kortti y = deck.jaa();
        Kortti z = deck.jaa();
        table.setFlop(x, y, z);
        deck.poltaKortti();
        Kortti turn = deck.jaa();  //jakaa turnin
        table.setTurn(turn);
        deck.poltaKortti();
        Kortti river = deck.jaa(); //jakaa riverin
        table.setRiver(river);
    }

    public void tulostaTilanne() {
        for (Pelaaja player : players) {
            List<Kortti> lista = player.getTaskut();
            System.out.println(player.toString());
            for (Kortti k : lista) {
                System.out.print(k + " | ");
            }
            System.out.println("");
            System.out.println("");
        }
        table.tulostaFlop();
        table.tulostaTurn();
        table.tulostaRiver();
    }

}
