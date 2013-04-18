
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
public class ContratATest {
    
    public ContratATest() {
    }
      /**
     * Test of calculContratA method, of class ContratA.
     */
    @Test
    public void testCalculContratA() {
        System.out.println("calculContratA");
        int montant = 10000;
        
        assertEquals(ContratA.calculContratA(0, montant), 2500);
        assertEquals(ContratA.calculContratA(100, montant), 3500);
        assertEquals(ContratA.calculContratA(150, montant), 0);
        assertEquals(ContratA.calculContratA(175, montant), 5000);  
        assertEquals(ContratA.calculContratA(200, montant), 2500);
        assertEquals(ContratA.calculContratA(320, montant), 0);
        assertEquals(ContratA.calculContratA(400, montant), 0);
        assertEquals(ContratA.calculContratA(500, montant), 2500);
        assertEquals(ContratA.calculContratA(600, montant), 4000);
        assertEquals(ContratA.calculContratA(700, montant), 0);
    }
    
}
