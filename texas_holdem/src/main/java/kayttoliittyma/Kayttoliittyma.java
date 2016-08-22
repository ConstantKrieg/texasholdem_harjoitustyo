/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Kim
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton button;

    @Override
    public void run() {
        frame = new JFrame("Casino Hold'em");
        frame.setPreferredSize(new Dimension(1200, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        
        Box laatikko = Box.createVerticalBox();
        
        KorttiPaneeli jakaja = new KorttiPaneeli();
        laatikko.add(jakaja);
        
        PoytaKorttiPaneeli poyta = new PoytaKorttiPaneeli();
        laatikko.add(poyta);
        
        KorttiPaneeli pelaaja = new KorttiPaneeli();
        laatikko.add(pelaaja);
        
        container.add(laatikko, BorderLayout.CENTER);
        container.add(alaValikko(), BorderLayout.SOUTH);
        
        
        
    }

    private JPanel alaValikko() {
        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        JButton uusiPeli = new JButton("Uusi peli");
        
        paneeli.add(uusiPeli);
        JButton ohjeet = new JButton("Ohjeet");
        paneeli.add(ohjeet);
        
        return paneeli;

    }
    
    

}
