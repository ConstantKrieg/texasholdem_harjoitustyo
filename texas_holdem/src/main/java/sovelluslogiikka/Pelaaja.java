package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;
import static sovelluslogiikka.Arvo.KASI;

public class Pelaaja  extends Osallistuja{

    
    private List<Kortti> taskut;
    private Kasi kasi;
    private int panokset;

    public Pelaaja(){
        this.kasi = Kasi.KICKER;
        this.panokset = 2000;
        this.taskut = new ArrayList();
    }

    

    public int getPanokset() {
        return panokset;
    }
    
    public void panosta(int panos){
        this.panokset -= panos;
    }
    
    public void  maksaVoitot(int voitot){
        this.panokset += voitot;
    }

    

    

    @Override
    public String toString(){
        
        return "Pelaaja ";
    }

    

}
