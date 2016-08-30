/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Kim
 */
public class SivuPaneeli extends JPanel {

    private JLabel jakaja;
    private JLabel pelaaja;
    private JLabel poyta;

    public SivuPaneeli() {
        super(new GridLayout(3, 1));

        this.jakaja = new JLabel("Dealer", SwingConstants.CENTER);
        this.poyta = new JLabel("Table", SwingConstants.CENTER);
        this.pelaaja = new JLabel("Player", SwingConstants.CENTER);

        asetaVarit();

        add(this.jakaja);
        add(this.poyta);
        add(this.pelaaja);

    }

    private void asetaVarit() {
        this.jakaja.setOpaque(true);
        this.poyta.setOpaque(true);
        this.pelaaja.setOpaque(true);

        Color punainen = new Color(148, 7, 43);
        this.jakaja.setBackground(punainen);
        this.pelaaja.setBackground(punainen);
        this.poyta.setBackground(punainen);

        Color keltainen = new Color(201, 172, 6);
        this.jakaja.setForeground(keltainen);
        this.poyta.setForeground(keltainen);
        this.pelaaja.setForeground(keltainen);

        Font f = new Font("Unicorn", Font.BOLD, 25);

        this.jakaja.setFont(f);
        this.poyta.setFont(f);
        this.pelaaja.setFont(f);

    }
}
