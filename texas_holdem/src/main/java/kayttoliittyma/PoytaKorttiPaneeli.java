/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kim
 */
public class PoytaKorttiPaneeli extends JPanel{
    
    private JLabel flop1;
    private JLabel flop2;
    private JLabel flop3;
    private JLabel turn;
    private JLabel river;
    
    public PoytaKorttiPaneeli(){
        super(new GridLayout(1, 5));
        flop1 = new JLabel("f1");
        flop2 = new JLabel("f2");
        flop3 = new JLabel("f3");
        turn = new JLabel("t");
        river = new JLabel("r");
        
        add(flop1);
        add(flop2);
        add(flop3);
        add(turn);
        add(river);
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
