/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    private JLabel panostenMaara;
    private JLabel status;
    private JLabel tayte;
    private Color vari;
    
    public PanostusPaneeli(){
        super(new FlowLayout());
        //super(new GridLayout(1,6));
        this.vari = new Color(15,99,0);
        this.setBackground(vari);
        this.panostuskentta = new JTextField(4);
        this.panostusNappi = new JButton("Panosta");
        this.raiseNappi = new JButton("Raise");
        this.foldNappi = new JButton ("Fold");
        this.panostenMaara = new JLabel("");
        this.status = new JLabel();
        this.tayte = new JLabel();
        this.setAlignmentY(CENTER_ALIGNMENT);
        
        this.raiseNappi.setEnabled(false);
        this.foldNappi.setEnabled(false);
        
        add(tayte);
        add(this.status);
        add(this.panostuskentta);
        add(this.panostusNappi);
        add(this.raiseNappi);
        add(this.foldNappi);
        add(this.panostenMaara);
        
    }

    public JTextField getPanostuskentta() {
        return panostuskentta;
    }

    public JLabel getStatus() {
        return status;
    }

    public JButton getPanostusNappi() {
        return panostusNappi;
    }

    public JButton getRaiseNappi() {
        return raiseNappi;
    }

    public JLabel getPanostenMaara() {
        return panostenMaara;
    }

    public JButton getFoldNappi() {
        return foldNappi;
    }
    
    
    
}
