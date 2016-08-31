/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.TasapelinKasittelija;
import casinoholdem.Vertailu;
import casinoholdem.KadenTarkistaja;
import casinoholdem.Peli;
import casinoholdem.domain.Arvo;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Maa;
import casinoholdem.domain.Pakka;
import casinoholdem.domain.Poyta;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Kim
 */
public class TasapelinKasittelijaTest {
    
    public TasapelinKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tieBreakerKickerillaToimiiJosTasapeli() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(0, apu);
    }

    @Test
    public void tieBreakerKickerillaToimiiJosVoittaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }

    @Test
    public void tieBreakerKickerillaToimiiJosHaviaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }
    
    @Test
    public void tieBreakerParillaToimiiJosTasapeli() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.KOLME);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.KAKSI);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(0, apu);
    }
    
    @Test
    public void tieBreakerParillaToimiiJosHaviaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.KOLME);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }
    
    @Test
    public void tieBreakerParillaToimiiJosVoittaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KASI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }
    
    @Test
    public void tieBreakerSuorallaToimiiJosTasapeli() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(0, apu);
    }
    
    @Test
    public void tieBreakerSuorallaToimiiJosVoittaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.YSI);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }
    
    @Test
    public void tieBreakerSuorallaToimiiJosHaviaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }

    @Test
    public void tieBreakerVarillaToimiiJosVoittaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti j1 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.HERTTA, Arvo.KAKSI);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }
    
    @Test
    public void tieBreakerVarillaToimiiJosHaviaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti j1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j2 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }
    
    @Test
    public void tieBreakerTayskadellaToimiiJosHaviaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti j1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti p2 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.A);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.SEISKA);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }
    
    
    @Test
    public void tieBreakerTayskadellaToimiiJosVoittaa() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.PATA, Arvo.A);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.Q);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.SEISKA);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }
    
    
    @Test
    public void tieBreakerKahdellaParillaToimiiJosTasapeli() throws Exception {
        

        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.Q);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.A);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.Q);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(0, apu);
    }
    
    @Test
    public void tieBreakerKahdellaParillaToimiiJosVoittaa() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.K);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.SEISKA);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.Q);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(1, apu);
    }
    
    @Test
    public void tieBreakerKahdellaParillaToimiiJosHaviaa() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);
        TasapelinKasittelija tk = new TasapelinKasittelija(p, v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.A);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti j2 = new Kortti(Maa.PATA, Arvo.SEISKA);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.Q);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);
        
        List<Kortti> pelaaja = p.kaikkiKortit(p.getPlayer().getTaskut(), p.getTable().getKortit());
        List<Kortti> jakaja = p.kaikkiKortit(p.getDealer().getTaskut(), p.getTable().getKortit());
        kt.tarkistaKasi(p.getPlayer());
        kt.tarkistaKasi(p.getDealer());
        int apu = tk.kaynnistaTarkistus();

        assertEquals(-1, apu);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
