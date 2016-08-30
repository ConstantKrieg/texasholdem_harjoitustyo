/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import casinoholdem.Peli;

/**
 *
 * @author Kim
 */
public class FoldinKuuntelija implements ActionListener {

    private Peli peli;
    private OsallistujaKorttiPaneeli jakaja;
    private OsallistujaKorttiPaneeli pelaaja;
    private PoytaPaneeli poyta;
    private PanostusPaneeli panostus;

    public FoldinKuuntelija(Peli p, OsallistujaKorttiPaneeli jakaja, OsallistujaKorttiPaneeli pelaaja, PoytaPaneeli poyta, PanostusPaneeli panostus) {
        this.peli = p;
        this.jakaja = jakaja;
        this.pelaaja = pelaaja;
        this.poyta = poyta;
        this.panostus = panostus;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panostus.getStatus().setText("Luovutit");
        tyhjennaPoyta();
        this.panostus.getPanostuskentta().setEnabled(true);
        this.panostus.getPanostusNappi().setEnabled(true);
        this.panostus.getRaiseNappi().setEnabled(false);
        this.panostus.getFoldNappi().setEnabled(false);
    }

    private void tyhjennaPoyta() {
        this.panostus.getStatus().setText("");

        this.poyta.asetaVari();
        this.jakaja.asetaVari();
        this.pelaaja.asetaVari();
        this.jakaja.getK1().setText("");
        this.jakaja.getK2().setText("");
        this.poyta.getTurn().setText("");
        this.poyta.getRiver().setText("");
        this.pelaaja.getK1().setText("");
        this.pelaaja.getK2().setText("");
        this.poyta.getFlop1().setText("");
        this.poyta.getFlop2().setText("");
        this.poyta.getFlop3().setText("");
    }

}
