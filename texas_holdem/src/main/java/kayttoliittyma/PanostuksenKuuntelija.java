/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import domain.Kortti;
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
    private KorttiPaneeli jakaja;
    private KorttiPaneeli pelaaja;
    private PoytaPaneeli poyta;
    private PanostusPaneeli panostus;

    public PanostuksenKuuntelija(Peli p, KorttiPaneeli jakaja, KorttiPaneeli pelaaja, PoytaPaneeli poyta, PanostusPaneeli panostus) {
        this.peli = p;
        this.jakaja = jakaja;
        this.pelaaja = pelaaja;
        this.poyta = poyta;
        this.panostus = panostus;
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        int panostus = Integer.parseInt(this.panostus.getPanostuskentta().getText());
        this.peli.setAnte(panostus);
        
        
        try {
            this.peli.jaaKortit();
        } catch (Exception ex) {
            Logger.getLogger(PanostuksenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.pelaaja.getK1().setText(this.peli.getPlayer().getTaskut().get(0).toString());
        this.pelaaja.getK2().setText(this.peli.getPlayer().getTaskut().get(1).toString());
        
        Kortti[] flop = this.peli.getTable().getFlop();
        this.poyta.getFlop1().setText(flop[0].toString());
        this.poyta.getFlop2().setText(flop[1].toString());
        this.poyta.getFlop3().setText(flop[2].toString());
      
        this.jakaja.getK1().setText("");
        this.jakaja.getK2().setText("");
        this.poyta.getTurn().setText("Turn");
        this.poyta.getRiver().setText("River");
        
        this.panostus.getPanostuskentta().setEnabled(false);
        this.panostus.getPanostusNappi().setEnabled(false);
        this.panostus.getRaiseNappi().setEnabled(true);
        this.panostus.getFoldNappi().setEnabled(true);
        
    }

}
