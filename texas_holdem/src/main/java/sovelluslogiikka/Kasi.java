package sovelluslogiikka;

public enum Kasi {

    KICKER(1), PARI(2), KAKSIPARIA(3),
    KOLMOSET(3), SUORA(4), VARI(5),
    TAYSKASI(6), NELOSET(7), VARISUORA(8);

    private final int kadenArvo;

    private Kasi(int arvo) {
        this.kadenArvo = arvo;
    }

    public int getKadenArvo() {
        return this.kadenArvo;
    }

}
