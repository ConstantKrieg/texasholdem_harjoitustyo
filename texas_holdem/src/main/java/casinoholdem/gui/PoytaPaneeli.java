/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 *
 * @author tokito
 */
public class PoytaPaneeli extends JPanel {

    private final JLabel flop1;
    private final JLabel flop2;
    private final JLabel flop3;
    private final JLabel turn;
    private final JLabel river;
    private final Color vari;

    public PoytaPaneeli() {
        super(new GridLayout(1, 5));
        this.vari = new Color(148, 7, 43);
        this.setBackground(vari);

        this.flop1 = new JLabel("", SwingConstants.CENTER);
        this.flop2 = new JLabel("", SwingConstants.CENTER);
        this.flop3 = new JLabel("", SwingConstants.CENTER);
        this.turn = new JLabel("", SwingConstants.CENTER);
        this.river = new JLabel("", SwingConstants.CENTER);

        this.flop1.setOpaque(true);
        this.flop2.setOpaque(true);
        this.flop3.setOpaque(true);
        this.turn.setOpaque(true);
        this.river.setOpaque(true);

        asetaFontit();
        luoReunat();
        asetaVari();

        add(river);
        add(turn);
        add(flop1);
        add(flop2);
        add(flop3);
    }

    public JLabel getFlop1() {
        return flop1;
    }

    public JLabel getFlop2() {
        return flop2;
    }

    public JLabel getFlop3() {
        return flop3;
    }

    public JLabel getTurn() {
        return turn;
    }

    public JLabel getRiver() {
        return river;
    }

    private void asetaFontit() {

        Color vari2 = new Color(201, 172, 6);

        this.flop1.setFont(new Font(null, Font.PLAIN, 75));
        this.flop2.setFont(new Font(null, Font.PLAIN, 75));
        this.flop3.setFont(new Font(null, Font.PLAIN, 75));
        this.turn.setFont(new Font(null, Font.PLAIN, 75));
        this.river.setFont(new Font(null, Font.PLAIN, 75));
    }

    private void luoReunat() {
        Color vari2 = new Color(201, 172, 6);
        javax.swing.border.Border reuna2 = BorderFactory.createLineBorder(vari2, 3);

        this.flop1.setBorder(reuna2);
        this.flop2.setBorder(reuna2);
        this.flop3.setBorder(reuna2);
        this.turn.setBorder(reuna2);
        this.river.setBorder(reuna2);
    }

    public void asetaVari() {
        Color v = new Color(15, 99, 0);

        this.flop1.setBackground(v);
        this.flop2.setBackground(v);
        this.flop3.setBackground(v);
        this.turn.setBackground(v);
        this.river.setBackground(v);
    }

    public void asetaVariFlopille(Color c) {
        this.flop1.setBackground(c);
        this.flop2.setBackground(c);
        this.flop3.setBackground(c);
    }

    public void asetaVariTurnilleJaRiverille() {
        this.turn.setBackground(Color.WHITE);
        this.river.setBackground(Color.WHITE);
    }

    public void laitaKortinTakakansiTurnilleJaRiverille() {
        javax.swing.border.Border taka = BorderFactory.createLineBorder(Color.WHITE, 10);
        Color takavari = new Color(28, 73, 199);
        this.turn.setBackground(takavari);
        this.river.setBackground(takavari);
        this.turn.setText("\u2749");
        this.river.setText("\u2749");

        Font f = new Font("Unicorn", Font.PLAIN, 75);
        this.turn.setFont(f);
        this.river.setFont(f);

        this.turn.setForeground(Color.WHITE);
        this.river.setForeground(Color.WHITE);
    }

}
