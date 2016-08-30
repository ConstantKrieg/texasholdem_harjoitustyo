
/* To change this license header, choose License Headers in Project Properties.
 / * To change this template file, choose Tools | Templates
 / * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.VoitonMaksaja;
import casinoholdem.Peli;
import casinoholdem.domain.Arvo;
import casinoholdem.domain.Kasi;
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
import static casinoholdem.Vertailu.kaikkiKortit;

/**
 *
 * @author Kim
 */
public class VoitonMaksajaTest {

    public VoitonMaksajaTest() {
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
    public void voitonmaksuToimiiJosJakajEiPoydassaJaKasiAlleVari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.PARI);
        p.setAnte(100);
        p.setVoittaja(2);

        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 100);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaPoydassaJaKasiAlleVari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.PARI);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(1);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 300);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaPoydassaJaKasiVari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.VARI);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(1);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 400);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaEiPoydassaJaKasiVari() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.VARI);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(2);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 200);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaEiPoydassaJaKasiTayskasi() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.TAYSKASI);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(2);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 300);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaPoydassaJaKasiTayskasi() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.TAYSKASI);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(1);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 500);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaPoydassaJaKasiNeloset() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.NELOSET);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(1);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 1200);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaEiPoydassaJaKasiNeloset() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.NELOSET);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(2);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 1000);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaEiPoydassaJaKasiVarisuora() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.VARISUORA);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(2);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 2000);
    }

    @Test
    public void voitonmaksuToimiiJosJakajaPoydassaJaKasiVarisuora() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
        VoitonMaksaja vm = new VoitonMaksaja(p);

        p.getPlayer().setKasi(Kasi.VARISUORA);
        p.setAnte(100);
        p.setRaise(200);
        p.setVoittaja(1);
        vm.maksaVoitot();
        int apu = vm.getVoitto();

        assertEquals(apu, 2200);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
