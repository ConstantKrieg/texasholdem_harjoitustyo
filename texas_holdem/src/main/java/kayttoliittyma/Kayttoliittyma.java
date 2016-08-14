/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
        JPanel pelialusta = luoPelialusta();
        container.add(pelialusta);
    }

    public JPanel luoPelialusta() {
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 5;
        c.weighty = 5;
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;

        JLabel jakaja1 = new JLabel("jakaja1");
        c.gridx = 1;
        c.gridy = 0;
        pane.add(jakaja1, c);

        JLabel jakaja2 = new JLabel("jakaja2");
        c.gridx = 2;
        c.gridy = 0;
        pane.add(jakaja2, c);
        
        c.anchor = GridBagConstraints.LINE_START;

        JLabel flop1 = new JLabel("flop1");
        c.gridx = 5;
        c.gridy = 1;
        pane.add(flop1, c);
        
        JLabel flop2 = new JLabel("flop2");
        c.gridx = 4;
        c.gridy = 1;
        pane.add(flop2, c);
        
        JLabel flop3 = new JLabel("flop3");
        c.gridx = 3;
        c.gridy = 1;
        pane.add(flop3, c);
        
        JLabel turn = new JLabel("turn");
        c.gridx = 2;
        c.gridy = 1;
        pane.add(turn, c);
        
        JLabel river = new JLabel("river");
        c.gridx = 1;
        c.gridy = 1;
        pane.add(river, c);
        
        c.anchor = GridBagConstraints.CENTER;
        
        JLabel pelaaja1 = new JLabel("pelaaja1");
        c.gridx = 1;
        c.gridy = 2;
        pane.add(pelaaja1, c);
        
        JLabel pelaaja2 = new JLabel("pelaaja2");
        c.gridx = 2;
        c.gridy = 2;
        pane.add(pelaaja2, c);
        
        

        return pane;
    }

}
