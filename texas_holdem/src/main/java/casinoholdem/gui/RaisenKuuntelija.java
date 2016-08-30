/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import casinoholdem.gui.PoytaPaneeli;
import casinoholdem.gui.PanostusPaneeli;
import casinoholdem.gui.OsallistujaKorttiPaneeli;
import casinoholdem.domain.Maa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import casinoholdem.Peli;

/**
 *
 * @author tokito
 */
public class RaisenKuuntelija implements ActionListener {

    private Peli peli;
    private OsallistujaKorttiPaneeli jakaja;
    private OsallistujaKorttiPaneeli pelaaja;
    private PoytaPaneeli poyta;
    private PanostusPaneeli panostus;

    public RaisenKuuntelija(Peli p, OsallistujaKorttiPaneeli jakaja, OsallistujaKorttiPaneeli pelaaja, PoytaPaneeli poyta, PanostusPaneeli panostus) {
        this.peli = p;
        this.jakaja = jakaja;
        this.pelaaja = pelaaja;
        this.poyta = poyta;
        this.panostus = panostus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int raise = this.peli.getAnte() + this.peli.getAnte();
        this.peli.setRaise(raise);
        this.peli.getPlayer().panosta(raise);
        this.poyta.asetaVariTurnilleJaRiverille();
        this.jakaja.asetaVariKorttienJakamiseksi();
        asetaVarit();

        this.peli.paataVoittaja();
        asetaTekstit();
        this.peli.maksaVoitot();

        if (this.peli.getVoittaja() >= 1) {
            this.panostus.getStatus().setText("Voitit ");
        } else if (this.peli.getVoittaja() == 0) {
            this.panostus.getStatus().setText("Tasapeli");
        } else {
            this.panostus.getStatus().setText("Jakaja voittaa");
        }

        this.panostus.getPanostenMaara().setText("Pelimerkkejä: " + this.peli.getPlayer().getPanokset());

        asetaNapit();
    }

    private void asetaVarit() {
        this.poyta.getTurn().setForeground(this.peli.getTable().getTurn().getVari());
        this.poyta.getRiver().setForeground(this.peli.getTable().getRiver().getVari());
        this.jakaja.getK1().setForeground(this.peli.getDealer().getTaskut().get(0).getVari());
        this.jakaja.getK2().setForeground(this.peli.getDealer().getTaskut().get(1).getVari());

    }

    private void asetaTekstit() {
        this.jakaja.getK1().setText(this.peli.getDealer().getTaskut().get(0).toString());
        this.jakaja.getK2().setText(this.peli.getDealer().getTaskut().get(1).toString());

        this.poyta.getTurn().setText(this.peli.getTable().getTurn().toString());
        this.poyta.getRiver().setText(this.peli.getTable().getRiver().toString());

        this.pelaaja.getKadenKertoja().setText(this.peli.getPlayer().getKasi().toString());

        if (this.peli.getDealer().mahtuukoPoytaan()) {
            this.jakaja.getKadenKertoja().setText(this.peli.getDealer().getKasi().toString());
        } else {
            this.jakaja.getKadenKertoja().setText("Ei pöydässä");
        }

    }

    private void asetaNapit() {
        this.panostus.getRaiseNappi().setEnabled(false);
        this.panostus.getFoldNappi().setEnabled(false);
        this.panostus.getPanostuskentta().setEnabled(true);
        this.panostus.getPanostusNappi().setEnabled(true);
    }

}
