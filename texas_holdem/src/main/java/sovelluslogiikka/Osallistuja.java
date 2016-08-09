/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim
 */
public class Osallistuja {

    private List<Kortti> taskut;
    private Kasi kasi;

    public Osallistuja() {
        this.taskut = new ArrayList();
        this.kasi = Kasi.KICKER;
    }

    public void setKasi(Kasi k) {
        this.kasi = k;
    }
    
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
