/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dfa
 */
public class ContratBTest {
    
    public ContratBTest() {
    }
    /**
     * Test of calculContratB method, of class ContratB.
     */
    @Test
    public void testCalculContratB() {
        System.out.println("calculContratB");
          int montant = 10000;
          int montant2 = 5000;
          int montant3 = 20000;
        
        assertEquals(ContratB.calculContratB(0, montant), 4000);
        assertEquals(ContratB.calculContratB(0, montant2), 2500);
        assertEquals(ContratB.calculContratB(0, montant3), 4000);
        
        assertEquals(ContratB.calculContratB(100, montant), 5000);
        assertEquals(ContratB.calculContratB(100, montant2), 2500);
        assertEquals(ContratB.calculContratB(100, montant3), 5000);
        
        assertEquals(ContratB.calculContratB(150, montant), 0);
        assertEquals(ContratB.calculContratB(175, montant), 7500);  
        assertEquals(ContratB.calculContratB(200, montant), 10000);
        assertEquals(ContratB.calculContratB(320, montant), 5000);
        assertEquals(ContratB.calculContratB(400, montant), 0);
        
        assertEquals(ContratB.calculContratB(500, montant), 5000);
        assertEquals(ContratB.calculContratB(500, montant2), 2500);
        assertEquals(ContratB.calculContratB(500, montant3), 5000);
        
        assertEquals(ContratB.calculContratB(600, montant), 10000);
        assertEquals(ContratB.calculContratB(700, montant), 7000);
        
    }
}
