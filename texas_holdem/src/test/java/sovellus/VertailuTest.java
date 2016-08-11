/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Arvo;
import domain.Kortti;
import domain.Maa;
import domain.Pakka;
import domain.Poyta;

/**
 *
 * @author Kim
 */
public class VertailuTest {

    public VertailuTest() {
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
    public void samojenTarkistusToimiiJosKolmoset() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k2 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.SEISKA);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);

        int testi = v.tarkistaSamat(3, lista);
        assertEquals(13, testi);

    }

    @Test
    public void varinTarkastusToimii() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.SEISKA);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);

        List<Kortti> l = v.tarkistaVari(lista);
        Boolean testi = false;

        if (!l.isEmpty()) {
            testi = true;
        }

        assertEquals(true, testi);
    }

    @Test
    public void varinTarkastusToimiiJosEiPade() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k2 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.SEISKA);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);

        List<Kortti> l = v.tarkistaVari(lista);
        Boolean testi = false;

        if (!l.isEmpty()) {
            testi = true;
        }

        assertEquals(false, testi);
    }

    @Test
    public void suoranKokoaminenToimii() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti k2 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.RUUTU, Arvo.KYMPPI);
        Kortti k6 = new Kortti(Maa.PATA, Arvo.SEISKA);
        Kortti k7 = new Kortti(Maa.RISTI, Arvo.KUUSI);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);
        lista.add(k6);
        lista.add(k7);

        int suora = v.onkoSuora(lista);
        Boolean x = false;
        if (suora > 0) {
            x = true;
        }
        assertEquals(true, x);
    }

    @Test
    public void varisuoranTarkastusToimii() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti k6 = new Kortti(Maa.PATA, Arvo.SEISKA);
        Kortti k7 = new Kortti(Maa.RISTI, Arvo.KUUSI);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);
        lista.add(k6);
        lista.add(k7);

        int x = v.tarkistaVarisuora(lista);
        Boolean y = false;

        if (x > 0) {
            y = true;
        }
        assertEquals(true, y);
    }

    @Test
    public void tayskadentarkistusToimii() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k2 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.A);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);

        int[] testi = v.tarkistaTayskasi(lista);
        boolean t = false;
        if (testi[0] > 0 && testi[1] > 0) {
            t = true;
        }
        assertEquals(true, t);
    }

    @Test
    public void tayskadentarkistusToimiiJosVaara() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k2 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k3 = new Kortti(Maa.RISTI, Arvo.K);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.A);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);

        int[] testi = v.tarkistaTayskasi(lista);
        boolean t = false;
        if (testi[0] > 0 && testi[1] > 0) {
            t = true;
        }
        assertEquals(false, t);
    }

    @Test
    public void kahdenParinTarkastusToimii() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        List<Kortti> lista = new ArrayList();
        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti k6 = new Kortti(Maa.PATA, Arvo.SEISKA);
        Kortti k7 = new Kortti(Maa.RISTI, Arvo.KUUSI);

        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
        lista.add(k5);
        lista.add(k6);
        lista.add(k7);

        int[] x = v.tarkistaKaksiParia(lista);
        Boolean y = false;

        if (x[0] > 0 && x[1] > 0) {
            y = true;
        }
        assertEquals(true, y);
    }

    @Test
    public void kadenTarkastusToimiiJosPari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.A);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 2 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosKaksiParia() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 3 && p.getPlayer().getKorkeinKortti() == 13) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosKolmoset() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 3 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosSuora() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.KYMPPI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 4 && p.getPlayer().getKorkeinKortti() == 14) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosVari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        assertEquals(5, apu);

    }

    @Test
    public void kadenTarkastusToimiiJosTayskasi() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 6 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosNeloset() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.RUUTU, Arvo.K);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 7 && p.getPlayer().getKorkeinKortti() == 13) {
            x = true;
        }

        assertEquals(true, x);

    }

    @Test
    public void kadenTarkastusToimiiJosVarisuora() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);
        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 8 && p.getPlayer().getKorkeinKortti() == 14) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void tieBreakerKickerillaToimiiJosTasapeli() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

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

        v.tarkistaKasi(p.getPlayer());
        int apu = v.tieBreakerKickerilla(p.getDealer(), p.getPlayer());

        assertEquals(0, apu);
    }

    @Test
    public void tieBreakerKickerillaToimiiJosVoittaa() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

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
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KAKSI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = v.tieBreakerKickerilla(p.getDealer(), p.getPlayer());

        assertEquals(1, apu);
    }

    @Test
    public void tieBreakerKickerillaToimiiJosHaviaa() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        Vertailu v = new Vertailu(p);

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
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KAKSI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        v.tarkistaKasi(p.getPlayer());
        int apu = v.tieBreakerKickerilla(p.getDealer(), p.getPlayer());

        assertEquals(-1, apu);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
