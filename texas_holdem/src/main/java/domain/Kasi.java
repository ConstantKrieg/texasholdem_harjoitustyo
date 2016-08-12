package domain;

public enum Kasi {

    KICKER(1), PARI(2), KAKSIPARIA(3),
    KOLMOSET(4), SUORA(5), VARI(6),
    TAYSKASI(7), NELOSET(8), VARISUORA(9);

    private final int kadenArvo;

    private Kasi(int arvo) {
        this.kadenArvo = arvo;
    }

    public int getKadenArvo() {
        return this.kadenArvo;
    }

}
