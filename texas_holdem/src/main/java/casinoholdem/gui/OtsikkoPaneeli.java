/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kim
 */
public class OtsikkoPaneeli extends JPanel {

    private JLabel o;
    private JLabel hertta;
    private JLabel pata;
    private JLabel risti;
    private JLabel ruutu;

    public OtsikkoPaneeli() {
        super(new FlowLayout());
        this.o = new JLabel();
        this.hertta = new JLabel();
        this.pata = new JLabel();
        this.ruutu = new JLabel();
        this.risti = new JLabel();

        asetaTekstit();
        asetaFontit();
        asetaVarit();

        add(this.hertta);
        add(this.pata);
        add(this.o);
        add(this.risti);
        add(this.ruutu);

    }

    private void asetaTekstit() {
        String otsikko = "Casino Hold'em";

        String hertta2 = "\u2665";
        String pata2 = "\u2660";
        String risti2 = "\u2663";
        String ruutu2 = "\u2666";

        this.hertta.setText(hertta2);
        this.risti.setText(risti2);
        this.ruutu.setText(ruutu2);
        this.pata.setText(pata2);
        this.o.setText(otsikko);
    }

    private void asetaFontit() {
        Font f = new Font("Unicorn", Font.BOLD, 35);
        this.o.setFont(f);
        this.hertta.setFont(f);
        this.pata.setFont(f);
        this.risti.setFont(f);
        this.ruutu.setFont(f);
    }

    private void asetaVarit() {
        this.o.setOpaque(true);
        this.setOpaque(true);
        this.hertta.setOpaque(true);
        this.ruutu.setOpaque(true);
        this.pata.setOpaque(true);
        this.risti.setOpaque(true);

        Color punainen = new Color(148, 7, 43);

        this.setBackground(punainen);
        this.o.setBackground(punainen);

        Color keltainen = new Color(201, 172, 6);

        this.o.setForeground(keltainen);
        this.hertta.setForeground(Color.RED);
        this.ruutu.setForeground(Color.RED);
        this.pata.setForeground(Color.BLACK);
        this.risti.setForeground(Color.BLACK);
    }

}
