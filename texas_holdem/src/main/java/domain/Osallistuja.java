/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Kim Luokka joka toteuttaa jakajan sekä pelaajan.
 */
public class Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;
    private int korkeinKortti;

    /**
     * Konstruktori.
     */
    public Osallistuja() {
        this.taskut = new ArrayList();
        this.kasi = Kasi.KICKER;
        this.korkeinKortti = 0;
    }

    public void setKorkeinKortti(int korkeinKortti) {
        this.korkeinKortti = korkeinKortti;
    }

    public void setKasi(Kasi k) {
        this.kasi = k;
    }

    /**
     * Palauttaa korkeimman kortin pelaajan kädestä.
     *
     * @return int korkeinKortti
     */
    public int getKorkeinKortti() {
        return korkeinKortti;
    }

    /**
     * Lisää osallistujan  taskukortteihin kortin.
     * @param k Lisättävä kortti
     */
    public void annaKortti(Kortti k) {
        this.taskut.add(k);
    }

    public Kasi getKasi() {
        return kasi;
    }

    public List<Kortti> getTaskut() {
        return this.taskut;
    }

}
