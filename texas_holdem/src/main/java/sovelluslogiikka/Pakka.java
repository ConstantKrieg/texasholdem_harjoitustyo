package sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pakka {

    private List<Kortti> pakka;

    public Pakka() {
        this.pakka = new ArrayList();

        for (Maa m : Maa.values()) {
            for (Arvo a : Arvo.values()) {
                pakka.add(new Kortti(m, a));
            }
        }

    }

    public int getKoko() {
        return this.pakka.size();
    }

    public List<Kortti> getPakka() {
        return this.pakka;
    }

    public void sekoitus() {
        Collections.shuffle(pakka);
    }

    public Kortti jaa() throws Exception {
        Kortti k = this.pakka.get(0);
        pakka.remove(0);
        if (k != null) {
            return k;
        }
        return null;
    }

    public void poltaKortti() {
        this.pakka.remove(0);
    }

    @Override
    public String toString() {
        String p = "";
        for (Kortti k : pakka) {
            System.out.println(k);
            p += k + " ";
        }
        return p;
    }

}
