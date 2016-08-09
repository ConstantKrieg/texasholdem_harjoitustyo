package sovellus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sovelluslogiikka.Kortti;
import sovelluslogiikka.Pakka;
import sovelluslogiikka.Pelaaja;
import sovelluslogiikka.Poyta;

public class Peli {

    private Pakka deck;
    private Poyta table;
    private Pelaaja player;

    public Peli(Pakka pakka, Poyta poyta) {
        this.deck = pakka;
        this.table = poyta;
        this.player = new Pelaaja();

    }

    public Poyta getTable() {
        return table;
    }

    public void jaaKortit() throws Exception {

        this.deck.sekoitus();
        this.player.annaKortti(this.deck.jaa());
        this.player.annaKortti(this.deck.jaa());

        Kortti x = deck.jaa(); //jakaa flopin
        Kortti y = deck.jaa();
        Kortti z = deck.jaa();
        table.setFlop(x, y, z);
        Kortti turn = deck.jaa();  //jakaa turnin
        table.setTurn(turn);
        Kortti river = deck.jaa(); //jakaa riverin
        table.setRiver(river);
    }

    public void testaus() {
        List<Kortti> kaikki = kaikkiKortit(this.player.getTaskut(), this.table.getKortit());
        Collections.sort(kaikki);

        for (Kortti k : kaikki) {
            System.out.println(k);
        }

    }

    public void tulostaTilanne() {

        List<Kortti> lista = player.getTaskut();

        for (Kortti k : lista) {
            System.out.println(k);
        }
        table.tulostaFlop();
        table.tulostaTurnJaRiver();
    }

    public static boolean tarkistaVari(List<Kortti> kortit) {
        List<Kortti> vari = new ArrayList();

        for (Kortti k1 : kortit) {
            vari.add(k1);
            for (Kortti k2 : kortit) {
                if (!k1.equals(k2) && k1.getMaa().equals(k2.getMaa())) {
                    vari.add(k2);
                }
            }
            if (vari.size() >= 5) {
                return true;
            }
            vari.clear();
        }
        return false;
    }

    public static List<Kortti> kokoaSuora(List<Kortti> kortit) { //palauttaa listan siksi että voi käyttää myös värisuoran tarkastuksessa
        List<Kortti> suora = new ArrayList();
        Collections.sort(kortit);
        int j = 1;

        for (int i = 0; i < kortit.size() - 1; i++) {
            if (kortit.get(i).getArvo() == kortit.get(j).getArvo() + 1) {
                suora.add(kortit.get(i));
            }
            j++;
        }
        if (kortit.get(6).getArvo() == kortit.get(5).getArvo() - 1) {
            suora.add(kortit.get(6));
        }

        if (suora.size() == 5) {
            return suora;
        } else if (suora.size() == 6) {
            suora.remove(5);
            return suora;
        } else if (suora.size() == 7) {
            suora.remove(6);
            suora.remove(7);
            return suora;
        }

        return null;
    }

    public static int tarkistaSamat(int koko, List<Kortti> kortit) {
        List<Kortti> samat = new ArrayList();

        for (Kortti k1 : kortit) {
            samat.add(k1);
            for (Kortti k2 : kortit) {
                if (!k1.equals(k2) && k1.getArvo() == k2.getArvo()) {
                    samat.add(k2);
                }
            }
            if (samat.size() == koko) {
                return samat.get(0).getArvo();
            }
            samat.clear();
        }
        return 0;
    }

    public boolean tarkistaPari(List<Kortti> kortit) {
        if (tarkistaSamat(2, kortit) > 0) {
            return true;
        }
        return false;
    }

    public boolean tarkistaKolmoset(List<Kortti> kortit) {
        if (tarkistaSamat(3, kortit) > 0) {
            return true;
        }
        return false;
    }

    public boolean tarkistaNeloset(List<Kortti> kortit) {
        if (tarkistaSamat(4, kortit) > 0) {
            return true;
        }
        return false;
    }

    public boolean tarkistaTayskasi(List<Kortti> kortit) {
        if (tarkistaPari(kortit) && tarkistaKolmoset(kortit)) {
            return true;
        }
        return false;
    }

    public static List<Kortti> kaikkiKortit(List<Kortti> taskut, List<Kortti> poydat) {
        List<Kortti> lista = new ArrayList();
        lista.addAll(poydat);
        lista.addAll(taskut);
        return lista;
    }

    public boolean tarkistaVarisuora(List<Kortti> kortit) {
        List<Kortti> lista = kokoaSuora(kortit);

        if (!lista.equals(null)) {
            if (tarkistaVari(lista)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static int[] tarkistaKaksiParia(List<Kortti> kortit) {
        int ensimmaisenParinArvo = tarkistaSamat(2, kortit);

        List<Kortti> valiaikainen = new ArrayList();
        List<Kortti> poistettavat = new ArrayList();

        for (Kortti k : kortit) {
            if (k.getArvo() == ensimmaisenParinArvo) {
                valiaikainen.add(k);
                poistettavat.add(k);
            }
        }
        kortit.removeAll(poistettavat);

        int toisenParinArvo = tarkistaSamat(2, kortit);

        int[] luvut = new int[2];

        if (ensimmaisenParinArvo > toisenParinArvo) {
            luvut[0] = ensimmaisenParinArvo;
            luvut[1] = toisenParinArvo;
        } else {
            luvut[0] = toisenParinArvo;
            luvut[1] = ensimmaisenParinArvo;
        }
        kortit.addAll(valiaikainen);
        return luvut;
    }

}
