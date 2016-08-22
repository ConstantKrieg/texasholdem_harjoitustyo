/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sovellus.Peli;

/**
 *
 * @author tokito
 */
public class RaisenKuuntelija implements ActionListener{
    private Peli peli;
    private KorttiPaneeli jakaja;
    private KorttiPaneeli pelaaja;
    private PoytaPaneeli poyta;
    private PanostusPaneeli panostus;
    
    public RaisenKuuntelija(Peli p, KorttiPaneeli jakaja, KorttiPaneeli pelaaja, PoytaPaneeli poyta, PanostusPaneeli panostus){
        this.peli = p;
        this.jakaja = jakaja;
        this.pelaaja = pelaaja;
        this.poyta = poyta;
        this.panostus = panostus;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.setRaise(this.peli.getAnte() * 2);
        this.jakaja.getK1().setText(this.peli.getDealer().getTaskut().get(0).toString());
        this.jakaja.getK2().setText(this.peli.getDealer().getTaskut().get(1).toString());
        
        this.poyta.getTurn().setText(this.peli.getTable().getTurn().toString());
        this.poyta.getRiver().setText(this.peli.getTable().getRiver().toString());
        
        this.peli.paataVoittaja();
        this.peli.getDealer().maksaVoitot(peli);
        
        this.panostus.getRaiseNappi().setEnabled(false);
        this.panostus.getFoldNappi().setEnabled(false);
        this.panostus.getPanostuskentta().setEnabled(true);
        this.panostus.getPanostusNappi().setEnabled(true);
    }
    
}
