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

    public static List<Kortti> tarkistaVari(List<Kortti> kortit) {
        List<Kortti> vari = new ArrayList();
        List<Kortti> palautus = new ArrayList();

        for (Kortti k1 : kortit) {
            vari.add(k1);
            for (Kortti k2 : kortit) {
                if (!k1.equals(k2) && k1.getMaa().equals(k2.getMaa())) {
                    vari.add(k2);
                }
            }
            if (vari.size() >= 5) {
                palautus.addAll(vari);
                break;
            }
            vari.clear();
        }

        return palautus;
    }

    public static int onkoSuora(List<Kortti> kortit) {
        Collections.sort(kortit);
        int j = 1;
        int i = 0;
        int onPerakkain = 1;
        int suurin = 0;

        while (i < kortit.size() - 1) {

            if (kortit.get(i).getArvo() == kortit.get(j).getArvo() + 1) {
                if (onPerakkain == 1) {
                    suurin = kortit.get(i).getArvo();
                }
                onPerakkain++;
                i++;
                j++;
            } else if (kortit.get(i).getArvo() == kortit.get(j).getArvo()) {
                i++;
                j++;
            } else {
                onPerakkain = 1;
                suurin = 0;
                i++;
                j++;
            }
            if(onPerakkain == 5){
                return suurin;
            }
        }

        
            if (onPerakkain == 4) {
                int apu = kortit.size();
                if (kortit.get(apu -1).getArvo() == kortit.get(apu - 2).getArvo() - 1) {
                    return kortit.get(apu - 5).getArvo();
                }
            }

            return 0;
        

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

    public int tarkistaVarisuora(List<Kortti> kortit) {
        List<Kortti> vari = tarkistaVari(kortit);
        int palautus = 0;

        if (!vari.isEmpty()) {
            int x = onkoSuora(vari);
            if (x > 0) {
                Collections.sort(vari);
                palautus = vari.get(0).getArvo();
            }
        }
        return palautus;
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
