/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tokito
 */
public class JakajaTest {
    
    public JakajaTest() {
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
    
    
    
     @Test
     public void mahtuukoPoytaanToimiiJosMahtuu(){
         
         Jakaja j = new Jakaja();
         j.setKasi(Kasi.KOLMOSET);
         
         assertEquals(true, j.mahtuukoPoytaan());
     } 
     
     @Test
     public void mahtuukoPoytaanToimiiJosEiMahdu(){
         
         Jakaja j = new Jakaja();
         j.setKasi(Kasi.KICKER);
         
         assertEquals(false, j.mahtuukoPoytaan());
     } 
     
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
