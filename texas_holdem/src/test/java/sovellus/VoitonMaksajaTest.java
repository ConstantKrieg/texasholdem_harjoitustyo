/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import domain.Arvo;
import domain.Kasi;
import domain.Kortti;
import domain.Maa;
import domain.Pakka;
import domain.Poyta;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static sovellus.Vertailu.kaikkiKortit;

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
        
        int apu = vm.maksaVoitot();

        assertEquals(200, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(600, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(700, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(300, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(400, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(800, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(1500, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(1100, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(5100, apu);
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
        
        int apu = vm.maksaVoitot();

        assertEquals(5500, apu);
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
