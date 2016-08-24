/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
//import javafx.scene.paint.Color;
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

    private JLabel esittely;
    private JLabel flop1;
    private JLabel flop2;
    private JLabel flop3;
    private JLabel turn;
    private JLabel river;
    private Color vari;

    public PoytaPaneeli() {
        super(new GridLayout(1, 6));
        //super(new FlowLayout());

        this.vari = new Color(148, 7, 43);

        this.setBackground(vari);
        esittely = new JLabel("Pöytäkortit");
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

        add(esittely);
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
        esittely.setFont(new Font("Unicorn", Font.ITALIC, 33));
        Color vari2 = new Color(201, 172, 6);
        esittely.setForeground(vari2);

        this.flop1.setFont(new Font(null, Font.PLAIN, 75));
        this.flop2.setFont(new Font(null, Font.PLAIN, 75));
        this.flop3.setFont(new Font(null, Font.PLAIN, 75));
        this.turn.setFont(new Font(null, Font.PLAIN, 75));
        this.river.setFont(new Font(null, Font.PLAIN, 75));
    }

    private void luoReunat() {
        javax.swing.border.Border reuna = BorderFactory.createLineBorder(vari, 12);
        Color vari2 = new Color(201, 172, 6);
        javax.swing.border.Border reuna2 = BorderFactory.createLineBorder(vari2, 3);
        this.flop1.setBorder(reuna);
        this.flop2.setBorder(reuna);
        this.flop3.setBorder(reuna);
        this.turn.setBorder(reuna);
        this.river.setBorder(reuna);
        this.flop1.setBorder(reuna2);
        this.flop2.setBorder(reuna2);
        this.flop3.setBorder(reuna2);
        this.turn.setBorder(reuna2);
        this.river.setBorder(reuna2);
    }

    private void asetaVari() {
        Color v = new Color(15, 99, 0);

        this.flop1.setBackground(v);
        this.flop2.setBackground(v);
        this.flop3.setBackground(v);
        this.turn.setBackground(v);
        this.river.setBackground(v);
    }

    public void asetaVariFlopille() {
        this.flop1.setBackground(Color.WHITE);
        this.flop2.setBackground(Color.WHITE);
        this.flop3.setBackground(Color.WHITE);
    }

    public void asetaVariTurnilleJaRiverille() {
        this.turn.setBackground(Color.WHITE);
        this.river.setBackground(Color.WHITE);
    }

}
