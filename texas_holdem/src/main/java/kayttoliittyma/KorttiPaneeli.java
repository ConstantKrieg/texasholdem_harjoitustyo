/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tokito
 */
public class KorttiPaneeli extends JPanel{
    private String nimi;
    private JLabel k1;
    private JLabel k2;
    
    public KorttiPaneeli(String nimi){
        super(new GridLayout(1,3));
       // super(new FlowLayout());
        this.nimi = nimi;
        JLabel esittely = new JLabel(nimi);
        this.k1 = new JLabel("k1");
        this.k2 = new JLabel("k2");
        
        add(esittely);
        add(k1);
        add(k2);
    }

    public JLabel getK1() {
        return k1;
    }

    public JLabel getK2() {
        return k2;
    }
    
    
    
}
