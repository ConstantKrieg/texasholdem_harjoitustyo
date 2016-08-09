
package sovellus;

import sovelluslogiikka.Kortti;
import sovelluslogiikka.Pakka;
import sovelluslogiikka.Poyta;


public class Main {

  
    public static void main(String[] args) throws Exception {
        Poyta p = new Poyta();
        Pakka pa = new Pakka();
        
        Peli peli = new Peli(pa, p);
       
        peli.jaaKortit();
        
        peli.testaus();
        
        
    }
    
}
