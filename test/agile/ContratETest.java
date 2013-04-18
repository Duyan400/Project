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
public class ContratETest {
    
    public ContratETest() {
    }
    
    
    /**
     * Test of calculContratE method, of class ContratE.
     */
    @Test
    public void testCalculContratE() {
        System.out.println("calculContratE");
         int montant = 10000;
         int montant2 = 5000;
         int montant3 = 20000;
        
        assertEquals(ContratE.calculContratE(0, montant), 1500);
        assertEquals(ContratE.calculContratE(100, montant), 2500);
        assertEquals(ContratE.calculContratE(150, montant), 1500);
        
        assertEquals(ContratE.calculContratE(175, montant), 2000); 
        assertEquals(ContratE.calculContratE(175, montant2), 1250);
        assertEquals(ContratE.calculContratE(175, montant3), 2000);
        
        assertEquals(ContratE.calculContratE(200, montant), 1200);
        assertEquals(ContratE.calculContratE(320, montant), 6000);
        
        assertEquals(ContratE.calculContratE(400, montant), 1500);
        assertEquals(ContratE.calculContratE(400, montant2), 1250);
        assertEquals(ContratE.calculContratE(400, montant3), 1500);
        
        assertEquals(ContratE.calculContratE(500, montant), 2000);
        assertEquals(ContratE.calculContratE(500, montant2), 1500);
        assertEquals(ContratE.calculContratE(500, montant3), 2000);
        
        assertEquals(ContratE.calculContratE(600, montant), 1500);
        assertEquals(ContratE.calculContratE(700, montant), 2200);
    }
}
