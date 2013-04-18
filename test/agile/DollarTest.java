
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
public class DollarTest {
    
    public DollarTest() {
    }
    
   
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of transformerEnEntier method, of class Dollar.
     */
    @Test
    public void testTransformerEnEntier() {
        System.out.println("transformerEnEntier");
        String montant = "123";
        int expResult = 123;
        int result = Dollar.transformerEnEntier(montant);
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of multiplier method, of class Dollar.
     */
    @Test
    public void testMultiplier() {
        System.out.println("multiplier");
        int nombre = 50;
        int multiplicateur = 2;
        int expResult = 100;
        int result = Dollar.multiplier(nombre, multiplicateur);
        assertEquals(expResult, result);
        
        assertEquals(Dollar.multiplier(nombre, 0), 0);
        
    }

    /**
     * Test of diviser method, of class Dollar.
     */
    @Test
    public void testDiviser() throws ArithmeticException {
        System.out.println("diviser");
        int nombre = 50;
        int diviseur = 2;
        int expResult = 25;
        int result = Dollar.diviser(nombre, diviseur);
        assertEquals(expResult, result);
        
        assertFalse(Dollar.diviser(nombre, 0)== 0);
    }

    /**
     * Test of modulo method, of class Dollar.
     */
    @Test
    public void testModulo() throws ArithmeticException {
        System.out.println("modulo");
        int nombre = 50;
        int moduleur = 3;
        int expResult = 2;
        int result = Dollar.modulo(nombre, moduleur);
        assertEquals(expResult, result);
      
        assertFalse(Dollar.modulo(nombre, 0) == 0); 
      
    }

    /**
     * Test of transformerEnString method, of class Dollar.
     */
    @Test
    public void testTransformerEnString() {
        System.out.println("transformerEnString");
        int montant = 123;
        String expResult = "1.23";
        String result = Dollar.transformerEnString(montant);
        assertEquals(expResult, result);
      
    }
}
