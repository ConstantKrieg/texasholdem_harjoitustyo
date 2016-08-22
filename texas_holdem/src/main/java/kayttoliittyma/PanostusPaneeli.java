/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tokito
 */
public class PanostusPaneeli extends JPanel{
    
    private JTextField panostuskentta;
    private JButton panostusNappi;
    private JButton raiseNappi;
    private JButton foldNappi;
    
    
    public PanostusPaneeli(){
        super(new FlowLayout());
        this.panostuskentta = new JTextField(4);
        this.panostusNappi = new JButton("Panosta");
        this.raiseNappi = new JButton("Raise");
        this.foldNappi = new JButton ("Fold");
        
        this.raiseNappi.setEnabled(false);
        this.foldNappi.setEnabled(false);
        
        
        add(this.panostuskentta);
        add(this.panostusNappi);
        add(this.raiseNappi);
        add(this.foldNappi);
        
    }

    public JTextField getPanostuskentta() {
        return panostuskentta;
    }

    public JButton getPanostusNappi() {
        return panostusNappi;
    }

    public JButton getRaiseNappi() {
        return raiseNappi;
    }

    public JButton getFoldNappi() {
        return foldNappi;
    }
    
    
    
}
