package domain;

import java.awt.Color;

public enum Maa {

    RUUTU("Ruutu", Color.red),
    PATA("Pata", Color.BLACK),
    RISTI("Risti", Color.BLACK),
    HERTTA("Hertta", Color.red);

    private final String nimi;
    private Color vari;

    private Maa(String teksti, Color vari) {
        this.nimi = teksti;
        this.vari = vari;
    }

    public String getMaa() {
        return this.nimi;
    }

    public Color getVari() {
        return vari;
    }
    
    

    
    
    
}
