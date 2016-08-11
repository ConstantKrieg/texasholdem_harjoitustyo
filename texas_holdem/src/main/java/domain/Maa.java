package domain;

public enum Maa {

    RUUTU("Ruutu"),
    PATA("Pata"),
    RISTI("Risti"),
    HERTTA("Hertta");

    private final String nimi;

    private Maa(String teksti) {
        this.nimi = teksti;
    }

    public String getMaa() {
        return this.nimi;
    }
}
