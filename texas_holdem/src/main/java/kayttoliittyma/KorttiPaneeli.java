/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kim
 */
public class KorttiPaneeli extends JPanel{
    
    
    private JLabel kortti1;
    private JLabel kortti2;
    
    
    public KorttiPaneeli(){
        Box box = Box.createHorizontalBox();
        
        kortti1 = new JLabel("k1");
        kortti2 = new JLabel("k2");
        
        kortti1.setAlignmentX((LEFT_ALIGNMENT));
        box.add(kortti1);
        kortti2.setAlignmentX((RIGHT_ALIGNMENT));
        box.add(kortti2);
        
        add(box);
        
    }

    public JLabel getKortti1() {
        return kortti1;
    }

    public JLabel getKortti2() {
        return kortti2;
    }
    
    
}

