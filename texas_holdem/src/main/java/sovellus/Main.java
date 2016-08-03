
package sovellus;

import sovelluslogiikka.Kortti;
import sovelluslogiikka.Pakka;
import sovelluslogiikka.Poyta;


public class Main {

  
    public static void main(String[] args) {
        Poyta p = new Poyta();
        Pakka pa = new Pakka();
        Kortti x = pa.getPakka().get(0);
        Kortti y = pa.getPakka().get(1);
        Kortti z = pa.getPakka().get(2);
        
        p.setFlop(x, y, z);
        p.tulostaFlop();
    }
    
}
