/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Kim
 */
public class VoittotaulukkoPaneeli extends JPanel {

    private final JLabel varisuora;
    private final JLabel neloset;
    private final JLabel tayskasi;
    private final JLabel vari;
    private final JLabel muut;
    private final JLabel otsikko;
    private final JLabel jakajaInfo; // Jaettu kahtia jotta sivupaneeli ei olisi liian leveä
    private final JLabel jakajaInfo2;

    public VoittotaulukkoPaneeli() {
        super(new GridLayout(8, 1));
        this.jakajaInfo = new JLabel(" Jakajalla oltava vähintään ", SwingConstants.CENTER);
        this.jakajaInfo2 = new JLabel(" nelospari mahtuakseen peliin ", SwingConstants.CENTER);
        this.otsikko = new JLabel("Voittotaulukko", SwingConstants.CENTER);
        this.varisuora = new JLabel("Värisuora 20:1", SwingConstants.CENTER);
        this.neloset = new JLabel("Neloset 10:1", SwingConstants.CENTER);
        this.tayskasi = new JLabel("Täyskäsi 3:1", SwingConstants.CENTER);
        this.vari = new JLabel("Väri 2:1", SwingConstants.CENTER);
        this.muut = new JLabel(" Suora tai huonompi 1:1 ", SwingConstants.CENTER);

        asetaFontit();
        asetaVarit();

        add(this.jakajaInfo);
        add(this.jakajaInfo2);
        add(this.otsikko);
        add(this.varisuora);
        add(this.neloset);
        add(this.tayskasi);
        add(this.vari);
        add(this.muut);
    }

    private void asetaFontit() {
        Font f = new Font("Unicorn", Font.BOLD, 17);
        this.jakajaInfo.setFont(new Font("Unicorn", Font.BOLD, 20));
        this.jakajaInfo2.setFont(new Font("Unicorn", Font.BOLD, 20));
        this.otsikko.setFont(new Font("Unicorn", Font.BOLD, 25));
        this.varisuora.setFont(f);
        this.neloset.setFont(f);
        this.tayskasi.setFont(f);
        this.vari.setFont(f);
        this.muut.setFont(f);

    }

    private void asetaVarit() {
        this.otsikko.setOpaque(true);
        this.varisuora.setOpaque(true);
        this.neloset.setOpaque(true);
        this.tayskasi.setOpaque(true);
        this.vari.setOpaque(true);
        this.muut.setOpaque(true);
        this.jakajaInfo.setOpaque(true);
        this.jakajaInfo2.setOpaque(true);
        this.setOpaque(true);

        Color punainen = new Color(148, 7, 43);

        this.jakajaInfo.setBackground(punainen);
        this.jakajaInfo2.setBackground(punainen);
        this.otsikko.setBackground(punainen);
        this.varisuora.setBackground(punainen);
        this.neloset.setBackground(punainen);
        this.tayskasi.setBackground(punainen);
        this.vari.setBackground(punainen);
        this.muut.setBackground(punainen);
        this.setBackground(punainen);

        Color keltainen = new Color(201, 172, 6);

        this.jakajaInfo.setForeground(keltainen);
        this.jakajaInfo2.setForeground(keltainen);
        this.otsikko.setForeground(keltainen);
        this.varisuora.setForeground(keltainen);
        this.neloset.setForeground(keltainen);
        this.tayskasi.setForeground(keltainen);
        this.vari.setForeground(keltainen);
        this.muut.setForeground(keltainen);

    }
}
