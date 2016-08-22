/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javafx.scene.paint.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tokito
 */
public class PoytaPaneeli extends JPanel {

    private JLabel flop1;
    private JLabel flop2;
    private JLabel flop3;
    private JLabel turn;
    private JLabel river;

    public PoytaPaneeli() {
        super(new GridLayout(1, 6));
//          super(new FlowLayout(FlowLayout.CENTER));
        
        JLabel esittely = new JLabel("Pöytäkortit");
        this.flop1 = new JLabel("flop1");
        this.flop2 = new JLabel("flop2");
        this.flop3 = new JLabel("flop3");
        this.turn = new JLabel("turn");
        this.river = new JLabel("river");

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

    

}
