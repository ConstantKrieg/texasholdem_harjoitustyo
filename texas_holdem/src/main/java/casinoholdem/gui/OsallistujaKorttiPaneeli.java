
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author tokito
 */
public class OsallistujaKorttiPaneeli extends JPanel {

    private JLabel tayte;
    private JLabel tayte2;
    private String nimi;
    private JLabel kadenKertoja;
    private JLabel k1;
    private JLabel k2;
    private Color vari;

    public OsallistujaKorttiPaneeli(String nimi) {
        super(new GridLayout(1, 5));
        this.vari = new Color(15, 99, 0);
        this.setBackground(vari);
        this.nimi = nimi;
        this.tayte = new JLabel();
        this.tayte2 = new JLabel();
        this.kadenKertoja = new JLabel("", SwingConstants.CENTER);

        this.k1 = new JLabel("", SwingConstants.CENTER);
        this.k2 = new JLabel("", SwingConstants.CENTER);

        this.k1.setOpaque(true);
        this.k2.setOpaque(true);
        this.tayte.setOpaque(true);
        this.tayte2.setOpaque(true);
        this.kadenKertoja.setOpaque(true);

        asetaVari();
        luoReunat();
        asetaFontit();

        add(tayte2);
        add(k1);
        add(tayte);
        add(k2);
        add(kadenKertoja);
    }

    private void luoReunat() {
        javax.swing.border.Border reuna = BorderFactory.createLineBorder(vari, 20);
        Color vari2 = new Color(201, 172, 6);
        javax.swing.border.Border reuna2 = BorderFactory.createLineBorder(vari2, 3);
        this.k1.setBorder(reuna);
        this.k2.setBorder(reuna);
        this.k1.setBorder(reuna2);
        this.k2.setBorder(reuna2);

    }

    public void asetaVari() {

        this.tayte2.setBackground(vari);
        this.k1.setBackground(vari);
        this.k2.setBackground(vari);
        this.kadenKertoja.setBackground(vari);
        this.tayte.setBackground(vari);

    }

    public void laitaKortinTakakansi() {
        javax.swing.border.Border reuna = BorderFactory.createLineBorder(Color.WHITE, 10);
        Color takavari = new Color(28, 73, 199);
        this.k1.setBackground(takavari);
        this.k2.setBackground(takavari);
        this.k1.setText("\u2749");
        this.k2.setText("\u2749");

        this.k1.setForeground(Color.WHITE);
        this.k2.setForeground(Color.WHITE);
    }

    public void asetaVariKorttienJakamiseksi() {
        this.k1.setBackground(Color.WHITE);
        this.k2.setBackground(Color.WHITE);
    }

    private void asetaFontit() {
        this.k1.setFont(new Font(null, Font.PLAIN, 65));
        this.k2.setFont(new Font(null, Font.PLAIN, 65));
        this.kadenKertoja.setFont(new Font(null, Font.PLAIN, 30));

        Color vari2 = new Color(201, 172, 6);
        this.kadenKertoja.setForeground(vari2);

    }

    public JLabel getK1() {
        return k1;
    }

    public JLabel getKadenKertoja() {
        return kadenKertoja;
    }

    public JLabel getK2() {
        return k2;
    }

}
