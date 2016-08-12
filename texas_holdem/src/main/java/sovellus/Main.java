
package sovellus;

import domain.Kortti;
import domain.Pakka;
import domain.Poyta;


public class Main {

  
    public static void main(String[] args) throws Exception {
        
        Pakka pakka = new Pakka();
        Poyta poyta = new Poyta();
        
        Peli peli = new Peli (pakka,poyta);
        
        peli.kaynnista();
        
        
    }
    
}
