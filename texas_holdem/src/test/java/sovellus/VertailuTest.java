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

    

    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
