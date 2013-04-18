
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
public class ContratDTest {
    
    public ContratDTest() {
    }
    
    /**
     * Test of calculContratD method, of class ContratD.
     */
    @Test
    public void testCalculContratD() {
        System.out.println("calculContratD");
        int montant = 10000;
        int montant2 = 5000;
        int montant3 = 20000;
          
        assertEquals(ContratD.calculContratD(0, montant), 8500);
        assertEquals(ContratD.calculContratD(0, montant2), 5000);
        assertEquals(ContratD.calculContratD(0, montant3), 8500);
        
        assertEquals(ContratD.calculContratD(100, montant), 7500);
        assertEquals(ContratD.calculContratD(100, montant2), 5000);
        assertEquals(ContratD.calculContratD(100, montant3), 7500);
        
        assertEquals(ContratD.calculContratD(150, montant), 10000);
        assertEquals(ContratD.calculContratD(150, montant2), 5000);
        assertEquals(ContratD.calculContratD(150, montant3), 15000);
        
        assertEquals(ContratD.calculContratD(175, montant), 9500);
        
        assertEquals(ContratD.calculContratD(200, montant), 10000);
        assertEquals(ContratD.calculContratD(200, montant2), 5000);
        assertEquals(ContratD.calculContratD(200, montant3), 10000);
        
        assertEquals(ContratD.calculContratD(320, montant), 10000);
        
        assertEquals(ContratD.calculContratD(400, montant), 6500);
        assertEquals(ContratD.calculContratD(400, montant2), 5000);
        assertEquals(ContratD.calculContratD(400, montant3), 6500);
        
        assertEquals(ContratD.calculContratD(500, montant), 10000);
        
        assertEquals(ContratD.calculContratD(600, montant), 10000);
        assertEquals(ContratD.calculContratD(600, montant2), 5000);
        assertEquals(ContratD.calculContratD(600, montant3), 10000);
        
        assertEquals(ContratD.calculContratD(700, montant), 9000);
        assertEquals(ContratD.calculContratD(700, montant2), 5000);
        assertEquals(ContratD.calculContratD(700, montant3), 9000);
    }
}
