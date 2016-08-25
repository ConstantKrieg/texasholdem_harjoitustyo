/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tokito
 */
public class PanostusPaneeli extends JPanel {

    private JTextField panostuskentta;
    private JButton panostusNappi;
    private JButton raiseNappi;
    private JButton foldNappi;
    private JLabel panostenMaara;
    private JLabel status;
    private JLabel info;
    private Color vari;

    public PanostusPaneeli() {
        super(new FlowLayout());
        //super(new GridLayout(1,6));
        this.vari = new Color(148, 7, 43);
        this.setBackground(vari);
        this.panostuskentta = new JTextField(4);
        this.panostusNappi = new JButton("Panosta");
        this.raiseNappi = new JButton("Raise");
        this.foldNappi = new JButton("Fold");
        this.panostenMaara = new JLabel("");
        this.status = new JLabel();
        this.info = new JLabel("Panoksen oltava kokonaisluku | ");
        this.setAlignmentY(CENTER_ALIGNMENT);

        this.raiseNappi.setEnabled(false);
        this.foldNappi.setEnabled(false);
        asetaVarit();

        add(info);
        add(this.status);
        add(this.panostuskentta);
        add(this.panostusNappi);
        add(this.raiseNappi);
        add(this.foldNappi);
        add(this.panostenMaara);

    }

    private void asetaVarit() {
        Font f = new Font("Unicorn", Font.BOLD, 18);
        Color c = new Color(201, 172, 6);
        this.info.setFont(f);
        this.info.setForeground(c);
        this.status.setFont(f);
        this.status.setForeground(c);
        this.panostenMaara.setFont(f);
        this.panostenMaara.setForeground(c);

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
