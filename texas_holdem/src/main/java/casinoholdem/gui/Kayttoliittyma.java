/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import casinoholdem.gui.FoldinKuuntelija;
import casinoholdem.domain.Pakka;
import casinoholdem.domain.Poyta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import casinoholdem.Peli;

/**
 *
 * @author Kim
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton button;
    private Peli peli = new Peli();

    @Override
    public void run() {
        frame = new JFrame("Casino Hold'em");
        frame.setPreferredSize(new Dimension(1400, 900));
        frame.setResizable(false);
        frame.setBackground(new Color(15, 99, 0));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        OsallistujaKorttiPaneeli jakaja = new OsallistujaKorttiPaneeli("Jakaja");
        OsallistujaKorttiPaneeli pelaaja = new OsallistujaKorttiPaneeli("Pelaaja");
        PoytaPaneeli poyta = new PoytaPaneeli();
        PanostusPaneeli panostus = new PanostusPaneeli();
        PanostuksenKuuntelija pk = new PanostuksenKuuntelija(this.peli, jakaja, pelaaja, poyta, panostus);
        panostus.getPanostusNappi().addActionListener(pk);
        RaisenKuuntelija rk = new RaisenKuuntelija(this.peli, jakaja, pelaaja, poyta, panostus);
        panostus.getRaiseNappi().addActionListener(rk);
        OtsikkoPaneeli op = new OtsikkoPaneeli();
        SivuPaneeli sp = new SivuPaneeli();
        VoittotaulukkoPaneeli vtp = new VoittotaulukkoPaneeli();
        FoldinKuuntelija fk = new FoldinKuuntelija(this.peli, jakaja, pelaaja, poyta, panostus);
        panostus.getFoldNappi().addActionListener(fk);

        Box b = Box.createVerticalBox();

        b.add(jakaja);
        b.add(poyta);
        b.add(pelaaja);

        container.add(b, BorderLayout.CENTER);
        container.add(panostus, BorderLayout.SOUTH);
        container.add(sp, BorderLayout.WEST);
        container.add(op, BorderLayout.NORTH);
        container.add(vtp, BorderLayout.EAST);

        panostus.getPanostenMaara().setText("Pelimerkkejä: " + this.peli.getPlayer().getPanokset());

    }

}
