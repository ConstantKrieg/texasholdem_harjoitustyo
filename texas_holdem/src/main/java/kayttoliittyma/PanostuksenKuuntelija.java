/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import domain.Kortti;
import domain.Maa;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import sovellus.Peli;

/**
 *
 * @author Kim
 */
public class PanostuksenKuuntelija implements ActionListener {

    private Peli peli;
    private OsallistujaKorttiPaneeli jakaja;
    private OsallistujaKorttiPaneeli pelaaja;
    private PoytaPaneeli poyta;
    private PanostusPaneeli panostus;

    public PanostuksenKuuntelija(Peli p, OsallistujaKorttiPaneeli jakaja, OsallistujaKorttiPaneeli pelaaja, PoytaPaneeli poyta, PanostusPaneeli panostus) {
        this.peli = p;
        this.jakaja = jakaja;
        this.pelaaja = pelaaja;
        this.poyta = poyta;
        this.panostus = panostus;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.pelaaja.getK1().setText("");
        this.pelaaja.getK2().setText("");
        this.poyta.getFlop1().setText("");
        this.poyta.getFlop2().setText("");
        this.poyta.getFlop3().setText("");

        int panostus = Integer.parseInt(this.panostus.getPanostuskentta().getText());
        if (peli.getPlayer().panosta(panostus)) {
            this.peli.setAnte(panostus);
            this.panostus.getPanostenMaara().setText("Pelimerkkejä: " + this.peli.getPlayer().getPanokset() + "");

            try {
                this.peli.jaaKortit();
            } catch (Exception ex) {
                Logger.getLogger(PanostuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }

            Kortti[] flop = this.peli.getTable().getFlop();
            tarkistaVarit(flop);
            asetaTekstit(flop);
            saadaNapit();
        }
    }

    private void tarkistaVarit(Kortti[] flop) {

        if (this.peli.getPlayer().getTaskut().get(0).getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getPlayer().getTaskut().get(0).getMaa().equals(Maa.RUUTU.getMaa())) {
            this.pelaaja.getK1().setForeground(Color.red);
        } else {
            this.pelaaja.getK1().setForeground(Color.BLACK);
        }
        if (this.peli.getPlayer().getTaskut().get(1).getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getPlayer().getTaskut().get(1).getMaa().equals(Maa.RUUTU.getMaa())) {
            this.pelaaja.getK2().setForeground(Color.red);
        } else {
            this.pelaaja.getK2().setForeground(Color.BLACK);
        }

        if (flop[0].getMaa().equals(Maa.HERTTA.getMaa()) || flop[0].getMaa().equals(Maa.RUUTU.getMaa())) {
            this.poyta.getFlop1().setForeground(Color.red);
        } else {
            this.poyta.getFlop1().setForeground(Color.BLACK);
        }
        if (flop[1].getMaa().equals(Maa.HERTTA.getMaa()) || flop[1].getMaa().equals(Maa.RUUTU.getMaa())) {
            this.poyta.getFlop2().setForeground(Color.red);
        } else {
            this.poyta.getFlop2().setForeground(Color.BLACK);
        }
        if (flop[2].getMaa().equals(Maa.HERTTA.getMaa()) || flop[2].getMaa().equals(Maa.RUUTU.getMaa())) {
            this.poyta.getFlop3().setForeground(Color.red);
        } else {
            this.poyta.getFlop3().setForeground(Color.BLACK);
        }
    }

    private void saadaNapit() {
        this.panostus.getPanostuskentta().setEnabled(false);
        this.panostus.getPanostusNappi().setEnabled(false);
        this.panostus.getRaiseNappi().setEnabled(true);
        this.panostus.getFoldNappi().setEnabled(true);
    }

    private void asetaTekstit(Kortti[] flop) {
        this.pelaaja.getK1().setText(this.peli.getPlayer().getTaskut().get(0).toString());
        this.pelaaja.getK2().setText(this.peli.getPlayer().getTaskut().get(1).toString());

        this.poyta.getFlop1().setText(flop[0].toString());
        this.poyta.getFlop2().setText(flop[1].toString());
        this.poyta.getFlop3().setText(flop[2].toString());

        this.jakaja.getK1().setText("");
        this.jakaja.getK2().setText("");
        this.poyta.getTurn().setText("");
        this.poyta.getRiver().setText("");
        this.panostus.getStatus().setText("");
    }

}
