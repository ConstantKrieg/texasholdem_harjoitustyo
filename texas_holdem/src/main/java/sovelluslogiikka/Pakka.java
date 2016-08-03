
package sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pakka {
    
    private List<Kortti> pakka;
    
    public Pakka(){
        this.pakka = new ArrayList();
        
        for (Maa m : Maa.values()) {
            for (Arvo a : Arvo.values()) {
                pakka.add(new Kortti(m, a));
            }
        }
        
    }
    
    public int getKoko(){
        return this.pakka.size();
    }
    
    public List<Kortti> getPakka(){
        return this.pakka;
    }
    
    
    public void sekoitus(){
        Collections.shuffle(pakka);
    }
    
    
    public Kortti[] jaaFlop(){
        Kortti[] k = new Kortti[3];
        for (int i = 0; i < k.length; i++) {
            k[1] = this.pakka.get(i);
        }
        return k;
    }
    
    public Kortti jaa(){
        return this.pakka.get(0);
    }
    
    
    
    public void poltaKortti(){
        this.pakka.remove(0);
    }
    
    @Override
    public String toString(){
        String p = "";
        for (Kortti k : pakka) {
            System.out.println(k);
            p += k + " ";
        }
        return p;
    }
    
    
    
}
