package sovelluslogiikka;

public class Pelaaja {

    private int numero;
    private Kortti[] taskut;
    private Kasi kasi;

    public Pelaaja(int nro) {
        this.numero = nro;
        this.taskut = new Kortti[2];
        this.kasi = null;
    }

    public void setKasi(Kasi k) {
        this.kasi = k;
    }

}
