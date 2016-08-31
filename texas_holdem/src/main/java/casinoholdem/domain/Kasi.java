package casinoholdem.domain;

public enum Kasi {

    KICKER("Kicker", 1), PARI("Pari", 2), KAKSIPARIA("Kaksi paria", 3),
    KOLMOSET("Kolmoset", 4), SUORA("Suora", 5), VARI("Väri", 6),
    TAYSKASI("Täyskäsi", 7), NELOSET("Neloset", 8), VARISUORA("Värisuora", 9);

    private final int kadenArvo;
    private final String kadenNimi;

    private Kasi(String nimi, int arvo) {
        this.kadenNimi = nimi;
        this.kadenArvo = arvo;
    }

    public int getKadenArvo() {
        return this.kadenArvo;
    }

    @Override
    public String toString() {
        return this.kadenNimi;
    }

    /**
     * Tarkistaa onko käsi samanarvoinen kuin toinen vertaamalla niiden arvoja.
     * @param k Vertailtava käsi.
     * @return True jos kädet ovat samanarvoisia ja false jos ei.
     */    
    public boolean equals(Kasi k) {
        if (this.getKadenArvo() == k.getKadenArvo()) {
            return true;
        }
        return false;
    }

}
