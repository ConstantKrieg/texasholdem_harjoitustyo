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

        int panostus = 0;
        
        try{
            panostus = Integer.parseInt(this.panostus.getPanostuskentta().getText());
        } catch (Exception e2){
            return;
        }
        if (peli.getPlayer().panosta(panostus)) {
            this.peli.setAnte(panostus);
            this.panostus.getPanostenMaara().setText("Pelimerkkejä: " + this.peli.getPlayer().getPanokset() + "");

            try {
                this.peli.jaaKortit();
            } catch (Exception ex) {
                Logger.getLogger(PanostuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.pelaaja.asetaVariKorttienJakamiseksi();
            this.poyta.asetaVariFlopille();
            Kortti[] flop = this.peli.getTable().getFlop();
            tarkistaVarit(flop);
            asetaTekstit(flop);
            saadaNapit();
        }
    }

    private void tarkistaVarit(Kortti[] flop) {
          this.pelaaja.getK1().setForeground(this.peli.getPlayer().getTaskut().get(0).getVari());
          this.pelaaja.getK2().setForeground(this.peli.getPlayer().getTaskut().get(1).getVari());
          this.poyta.getFlop1().setForeground(flop[0].getVari());
          this.poyta.getFlop2().setForeground(flop[1].getVari());
          this.poyta.getFlop3().setForeground(flop[2].getVari());
    }

    private void saadaNapit() {
        this.panostus.getPanostuskentta().setEnabled(false);
        this.panostus.getPanostusNappi().setEnabled(false);
        this.panostus.getRaiseNappi().setEnabled(true);
        this.panostus.getFoldNappi().setEnabled(true);
    }

    private void asetaTekstit(Kortti[] flop) {
        String taka = "\u1F0A0";
        
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
