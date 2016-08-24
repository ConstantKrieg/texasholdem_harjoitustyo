/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import domain.Maa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sovellus.Peli;

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
        int raise = this.peli.getAnte() * 2;
        this.peli.setRaise(raise);
        this.peli.getPlayer().panosta(raise);

        asetaVarit();
        asetaTekstit();
        

        this.peli.paataVoittaja();

        if (this.peli.getVoittaja() >= 1) {
            this.panostus.getStatus().setText("Voitit " + this.peli.getDealer().maksaVoitot(peli));
        } else if (this.peli.getVoittaja() == 0) {
            this.panostus.getStatus().setText("Tasapeli");
        } else {
            this.panostus.getStatus().setText("Jakaja voittaa");
        }

        this.panostus.getPanostenMaara().setText("Pelimerkkejä: " + this.peli.getPlayer().getPanokset() + "");
        
        asetaNapit();
    }
    
    private void asetaVarit(){
        if (this.peli.getDealer().getTaskut().get(0).getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getDealer().getTaskut().get(0).getMaa().equals(Maa.RUUTU.getMaa())) {
            this.jakaja.getK1().setForeground(Color.red);
        } else {
            this.jakaja.getK1().setForeground(Color.BLACK);
        }
        if (this.peli.getDealer().getTaskut().get(1).getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getDealer().getTaskut().get(1).getMaa().equals(Maa.RUUTU.getMaa())) {
            this.jakaja.getK2().setForeground(Color.red);
        } else {
            this.jakaja.getK2().setForeground(Color.BLACK);
        }
        
        if(this.peli.getTable().getTurn().getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getTable().getTurn().getMaa().equals(Maa.RUUTU.getMaa())){
            this.poyta.getTurn().setForeground(Color.red);
        } else {
            this.poyta.getTurn().setForeground(Color.BLACK);
        }
        
        if(this.peli.getTable().getRiver().getMaa().equals(Maa.HERTTA.getMaa()) || this.peli.getTable().getRiver().getMaa().equals(Maa.RUUTU.getMaa())){
            this.poyta.getRiver().setForeground(Color.red);
        } else {
            this.poyta.getRiver().setForeground(Color.BLACK);
        }
        
    }
    
    private void asetaTekstit(){
        this.jakaja.getK1().setText(this.peli.getDealer().getTaskut().get(0).toString());
        this.jakaja.getK2().setText(this.peli.getDealer().getTaskut().get(1).toString());

        this.poyta.getTurn().setText(this.peli.getTable().getTurn().toString());
        this.poyta.getRiver().setText(this.peli.getTable().getRiver().toString());
    }
    
    private void asetaNapit(){
        this.panostus.getRaiseNappi().setEnabled(false);
        this.panostus.getFoldNappi().setEnabled(false);
        this.panostus.getPanostuskentta().setEnabled(true);
        this.panostus.getPanostusNappi().setEnabled(true);
    }
}
