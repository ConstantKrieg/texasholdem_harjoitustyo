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
import javax.swing.JTextArea;
import sovellus.Peli;

/**
 *
 * @author Kim
 */
public class PanostuksenKuuntelija implements ActionListener{
    
    private Peli peli;
    private JTextArea pkortti1;
    private JTextArea pkortti2;
    private JTextArea flopKortti1;
    private JTextArea flopKortti2;
    private JTextArea flopKortti3;
    
    public PanostuksenKuuntelija(Peli p, JTextArea pkortti1, JTextArea pkortti2, JTextArea flop1, JTextArea flop2, JTextArea flop3){
        this.peli = p;
        this.pkortti1 = pkortti1;
        this.pkortti2 = pkortti2;
        this.flopKortti1 = flop1;
        this.flopKortti2 = flop2;
        this.flopKortti3 = flop3;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Kortti> lista =this.peli.getPlayer().getTaskut(); //Tulostaa pelaajan kortit tekstikenttiin
        this.pkortti1.setText(lista.get(0).toString());
        this.pkortti2.setText(lista.get(1).toString());
        
        Kortti[] flop = this.peli.getTable().getFlop();
        this.flopKortti1.setText(flop[0].toString());
        this.flopKortti2.setText(flop[1].toString());
        this.flopKortti3.setText(flop[2].toString());
    }
    
}
