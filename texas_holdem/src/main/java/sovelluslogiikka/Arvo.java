package sovelluslogiikka;

public enum Arvo {

    KAKSI(2), KOLME(3), NELJÄ(4),
    VIISI(5), KUUSI(6), SEISKA(7),
    KASI(8), YSI(9), KYMPPI(10),
    J(11), Q(12), K(13), A(14);

    private final int arvonumero;

    private Arvo(int arvonumero) {
        this.arvonumero = arvonumero;
    }

    public int getArvo() {
        return arvonumero;
    }

    public String getArvonimi() {
        return this.name();
    }

}
