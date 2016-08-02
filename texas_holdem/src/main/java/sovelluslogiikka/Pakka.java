
package sovelluslogiikka;

import java.util.ArrayList;
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
