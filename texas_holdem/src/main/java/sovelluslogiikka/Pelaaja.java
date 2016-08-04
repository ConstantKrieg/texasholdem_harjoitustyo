package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;
import static sovelluslogiikka.Arvo.KASI;

public class Pelaaja {

    private int numero;
    private List<Kortti> taskut;
    private Kasi kasi;

    public Pelaaja(int nro) {
        this.numero = nro;
        this.taskut = new ArrayList();
        this.kasi = Kasi.KICKER;
    }

    public void setKasi(Kasi k) {
        this.kasi = k;
    }

    public void annaKortti(Kortti k) {
        this.taskut.add(k);
    }

    public List<Kortti> getTaskut() {
        return this.taskut;
    }

    @Override
    public String toString(){
        
        return "Pelaaja " + this.numero;
    }

    public Kasi getKasi() {
        return kasi;
    }

}
