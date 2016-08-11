/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import domain.Jakaja;
import domain.Kasi;
import domain.Kortti;
import domain.Osallistuja;
import domain.Pelaaja;

/**
 *
 * @author Kim
 */
public class Vertailu {

    private Peli game;

    public Vertailu(Peli p) {
        this.game = p;
    }

    public List<Kortti> tarkistaVari(List<Kortti> kortit) {
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

    public int onkoSuora(List<Kortti> kortit) {
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
            if (onPerakkain == 5) {
                return suurin;
            }
        }

        if (onPerakkain == 4) {
            int apu = kortit.size();
            if (kortit.get(apu - 1).getArvo() == kortit.get(apu - 2).getArvo() - 1) {
                return kortit.get(apu - 5).getArvo();
            }
        }

        return 0;

    }

    public int tarkistaSamat(int koko, List<Kortti> kortit) {
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

    public int tieBreakerKickerilla(Jakaja j, Pelaaja p) {
        int apu = 0;

        List<Kortti> pelaaja = kaikkiKortit(p.getTaskut(), game.getTable().getKortit());
        List<Kortti> jakaja = kaikkiKortit(j.getTaskut(), game.getTable().getKortit());
        Collections.sort(pelaaja);
        Collections.sort(jakaja);

        for (int i = 0; i < 5; i++) {
            if (pelaaja.get(i).getArvo() > jakaja.get(i).getArvo()) {
                apu = 1;
            } else if (pelaaja.get(i).getArvo() < jakaja.get(i).getArvo()) {
                apu = -1;
            }

        }

        return apu;
    }

    /**
     *
     * @param o
     */
    public void tarkistaKasi(Osallistuja o) { //Metodimonsteri mutta en keksinyt muitakaan tapoja toteuttaa kuin else if:eillä. Tarkistaa jokaisen mahdollisen käden ja antaa sen osallistujalle.
        List<Kortti> kortit = kaikkiKortit(o.getTaskut(), game.getTable().getKortit());
        List<Kortti> apuLista = new ArrayList();
        Kasi k = Kasi.KICKER;

        int x = tarkistaSamat(2, kortit);
        if (x > 0) {
            k = Kasi.PARI;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        int[] kp = tarkistaKaksiParia(kortit);
        if (kp[0] > 0 && kp[1] > 0) {
            k = Kasi.KAKSIPARIA;
            o.setKasi(k);
            o.setKorkeinKortti(kp[0]);
        }
        x = tarkistaSamat(3, kortit);
        if (x > 0) {
            k = Kasi.KOLMOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        x = onkoSuora(kortit);
        if (x > 0) {
            k = Kasi.SUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        apuLista = tarkistaVari(kortit);
        if (!apuLista.isEmpty()) {
            k = Kasi.VARI;
            o.setKasi(k);
            o.setKorkeinKortti(apuLista.get(0).getArvo());
        }
        int[] tk = tarkistaTayskasi(kortit);
        if (tk[0] > 0 && tk[1] > 0) {
            k = Kasi.TAYSKASI;
            o.setKasi(k);
            o.setKorkeinKortti(tk[0]);
        }
        x = tarkistaSamat(4, kortit);
        if (x > 0) {
            k = Kasi.NELOSET;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
        x = tarkistaVarisuora(kortit);
        if (x > 0) {
            k = Kasi.VARISUORA;
            o.setKasi(k);
            o.setKorkeinKortti(x);
        }
    }

    /**
     *
     * @param kortit
     * @return
     */
    public int[] tarkistaTayskasi(List<Kortti> kortit) {
        int x = tarkistaSamat(2, kortit);
        int y = tarkistaSamat(3, kortit);
        int[] luvut = new int[2];

        if (x > 0 && y > 0) {
            luvut[0] = y;
            luvut[1] = x;
            return luvut;
        } else {
            luvut[0] = 0;
            luvut[1] = 0;
            return luvut;
        }

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

    public int[] tarkistaKaksiParia(List<Kortti> kortit) {
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