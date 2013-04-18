
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
public class ContratCTest {
    
    public ContratCTest() {
    }
    
    
    /**
     * Test of calculContratC method, of class ContratC.
     */
    @Test
    public void testCalculContratC() {
        System.out.println("calculContratC");
        int montant = 10000;
        
        assertEquals(ContratC.calculContratC(0, montant), 9000);
        assertEquals(ContratC.calculContratC(100, montant), 9500);
        assertEquals(ContratC.calculContratC(150, montant), 8500);
        assertEquals(ContratC.calculContratC(175, montant), 9000); 
        assertEquals(ContratC.calculContratC(200, montant), 9000);
        assertEquals(ContratC.calculContratC(320, montant), 9000);
        assertEquals(ContratC.calculContratC(400, montant), 9000);
        assertEquals(ContratC.calculContratC(500, montant), 9000);
        assertEquals(ContratC.calculContratC(600, montant), 7500);
        assertEquals(ContratC.calculContratC(700, montant), 9000);
    }
}
