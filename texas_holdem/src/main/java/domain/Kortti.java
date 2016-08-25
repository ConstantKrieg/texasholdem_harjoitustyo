package domain;

import java.awt.Color;

/**
 * Luokka toteuttaa Kortti-olion kahden enumin avulla.
 */
public class Kortti implements Comparable<Kortti> {

    private Maa maa;
    private Arvo arvo;
    private Color vari;

    public Kortti(Maa maa, Arvo arvo) {
        this.maa = maa;
        this.arvo = arvo;

    }

    public String getMaa() {
        return this.maa.getMaa();
    }

    public Color getVari() {
        return this.maa.getVari();
    }

    public int getArvo() {
        return this.arvo.getArvo();
    }

    @Override
    public String toString() {

        String s = "";
        if (this.arvo.getArvo() < 11) {
            if (this.maa.equals(Maa.HERTTA)) {
                s = this.arvo.getArvo() + "\u2665";
            } else if (this.maa.equals(Maa.RUUTU)) {
                s = this.arvo.getArvo() + "\u2666";
            } else if (this.maa.equals(Maa.RISTI)) {
                s = this.arvo.getArvo() + "\u2663";
            } else if (this.maa.equals(Maa.PATA)) {
                s = this.arvo.getArvo() + "\u2660";
            }
        } else {
            if (this.maa.equals(Maa.HERTTA)) {
                s = this.arvo.getArvonimi() + "\u2665";
            } else if (this.maa.equals(Maa.RUUTU)) {
                s = this.arvo.getArvonimi() + "\u2666";
            } else if (this.maa.equals(Maa.RISTI)) {
                s = this.arvo.getArvonimi() + "\u2663";
            } else if (this.maa.equals(Maa.PATA)) {
                s = this.arvo.getArvonimi() + "\u2660";
            }
        }

        return s;
    }

    /**
     * Metodi kertoo kumpi korteista on arvokkaampi
     *
     * @param toinen Vertailtava kortti
     * @return Luku sen mukaan kumpi on isompi
     */
    @Override
    public int compareTo(Kortti toinen) {
        return toinen.getArvo() - this.getArvo();
    }

}
