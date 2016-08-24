/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import domain.Pakka;
import domain.Poyta;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sovellus.Peli;

/**
 *
 * @author Kim
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton button;
    private Pakka pakka1 = new Pakka();
    private Poyta poyta1 = new Poyta();
    private Peli peli = new Peli(pakka1, poyta1);

    @Override
    public void run() {
        frame = new JFrame("Casino Hold'em");
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setResizable(false);
        

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }

    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        OsallistujaKorttiPaneeli jakaja = new OsallistujaKorttiPaneeli("Jakaja");
        OsallistujaKorttiPaneeli pelaaja = new OsallistujaKorttiPaneeli("Pelaaja");
        PoytaPaneeli poyta = new PoytaPaneeli();
        PanostusPaneeli panostus = new PanostusPaneeli();
        PanostuksenKuuntelija pk = new PanostuksenKuuntelija(this.peli, jakaja, pelaaja, poyta, panostus);
        panostus.getPanostusNappi().addActionListener(pk);
        RaisenKuuntelija rk = new RaisenKuuntelija(this.peli, jakaja, pelaaja, poyta, panostus);
        panostus.getRaiseNappi().addActionListener(rk);
        
        container.add(jakaja);
        container.add(poyta);
        container.add(pelaaja);
        container.add(panostus);
        //container.add(alavalikko());
    }
    
    private JPanel alavalikko(){
        JPanel paneeli = new JPanel(new GridLayout(1,3));
        JButton uusiPeli = new JButton("Uusi peli");
        JButton ohjeet = new JButton("Ohjeet");
        
        
        paneeli.add(uusiPeli);
        paneeli.add(ohjeet);
        
        return paneeli;
    }

    

}
