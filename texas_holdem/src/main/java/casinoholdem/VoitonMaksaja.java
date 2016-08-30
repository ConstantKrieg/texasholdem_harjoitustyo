/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

/*
 * @author Kim Luokka saa Peli-olion jonka kautta se maksaa mahdolliset voitot
 * pelaajalle.
 */
public class VoitonMaksaja {

    private Peli game;
    private int panokset;
    private int voitto;

    /**
     * Konstruktori.
     *
     * @param p Käytettävä peli
     */
    public VoitonMaksaja(Peli p) {
        this.game = p;
        this.panokset = this.game.getAnte() + this.game.getRaise();

        this.voitto = 0;
    }

    /**
     * Metodi tarkistaa luokan peliolion voittajan ja maksaa voittotaulukon
     * mukaisesti pelaajalle voitot.
     */
    public void maksaVoitot() {
        if (this.game.getVoittaja() != -1) {
            this.game.getPlayer().vastaanotaVoitot(this.panokset);
        }
        if (this.game.getVoittaja() > 0) {
            maksaVarisuora();
            maksaNeloset();
            maksaTayskasi();
            maksaVari();
            maksaMuut();
            lisaaRaise();
            this.game.getPlayer().vastaanotaVoitot(this.voitto);
        }

    }

    public int getVoitto() {
        return voitto;
    }

    private void maksaVarisuora() {
        if (this.game.getPlayer().getKasi().getKadenArvo() == 9) {
            this.voitto = 20 * this.game.getAnte();
        }
    }

    private void maksaNeloset() {
        if (this.game.getPlayer().getKasi().getKadenArvo() == 8) {
            this.voitto = 10 * this.game.getAnte();
        }
    }

    private void maksaTayskasi() {
        if (this.game.getPlayer().getKasi().getKadenArvo() == 7) {
            this.voitto = 3 * this.game.getAnte();
        }

    }

    private void maksaVari() {
        if (this.game.getPlayer().getKasi().getKadenArvo() == 6) {
            this.voitto = 2 * this.game.getAnte();
        }
    }

    private void maksaMuut() {
        if (this.game.getPlayer().getKasi().getKadenArvo() < 6) {
            this.voitto = this.game.getAnte();
        }
    }

    private void lisaaRaise() {
        if (this.game.getVoittaja() == 1) {
            this.voitto += this.game.getRaise();
        }
    }

}
