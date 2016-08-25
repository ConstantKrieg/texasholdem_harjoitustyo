/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/*
 * @author Kim Luokka saa Peli-olion jonka kautta se maksaa mahdolliset voitot
 * pelaajalle.
 */
public class VoitonMaksaja {

    private Peli game;

    /**
     * Konstruktori.
     * @param p Käytettävä peli
     */
    public VoitonMaksaja(Peli p) {
        this.game = p;
    }

    /**
     * Metodi maksaa panoksen ja käden mukaisesti voiton pelaajalle.
     *
     * @return Kokonaisluku joka on voiton määrä
     *
     */
    public int maksaVoitot() {
        int voitto = 0;
        int veto = 0;
        if (this.game.getVoittaja() == 1) { //tarkistaa onko jakaja pöydässä. Jos on niin maksaa myös raisen 1:1 suhteella.
            veto = this.game.getRaise() * 2;
        }
        if (this.game.getVoittaja() > 0) {        //Maksaa voittotaulukon mukaisesti voitot tarkistettuaan käden arvon
            if (this.game.getPlayer().getKasi().getKadenArvo() < 6) {
                voitto = this.game.getAnte() * 2 + veto;
                this.game.getPlayer().vastaanotaVoitot(voitto);
            } else if (this.game.getPlayer().getKasi().getKadenArvo() == 6) {
                voitto = this.game.getAnte() * 3 + veto;
                this.game.getPlayer().vastaanotaVoitot(voitto);
            } else if (this.game.getPlayer().getKasi().getKadenArvo() == 7) {
                voitto = this.game.getAnte() * 4 + veto;
                this.game.getPlayer().vastaanotaVoitot(voitto);
            } else if (this.game.getPlayer().getKasi().getKadenArvo() == 8) {
                voitto = this.game.getAnte() * 11 + veto;
                this.game.getPlayer().vastaanotaVoitot(voitto);
            } else if (this.game.getPlayer().getKasi().getKadenArvo() == 9) {
                voitto = this.game.getAnte() * 51 + veto;
                this.game.getPlayer().vastaanotaVoitot(voitto);
            }
        } else if (this.game.getVoittaja() == 0) {
            if (this.game.getRaise() > 0) {
                voitto = this.game.getAnte() + this.game.getRaise();
                this.game.getPlayer().vastaanotaVoitot(voitto);
            } else {
                voitto = this.game.getAnte();
                this.game.getPlayer().vastaanotaVoitot(this.game.getAnte());
            }
        }
        return voitto;
    }
}
