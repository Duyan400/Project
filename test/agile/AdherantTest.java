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
public class AdherantTest {
    
    public AdherantTest() {
    }
    
   
    /**
     * Test of calculMaximum method, of class Adherant.
     */
    @Test
    public void testCalculMaximum() {
        System.out.println("calculMaximum");
        String soin = "100";
        String montant = "150.00";
        Adherant instance = new Adherant();
        String result = instance.calculMaximum(soin, montant);
        assertEquals("150.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("100.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("0.00", result);
        
        soin = "175";
        result = instance.calculMaximum(soin, montant);
        assertEquals("150.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("50.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("0.00", result);
        
        soin = "200";
        result = instance.calculMaximum(soin, montant);
        assertEquals("150.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("100.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("0.00", result);
        
        soin = "500";
        montant = "100.00";
        result = instance.calculMaximum(soin, montant);
        assertEquals("100.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("50.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("0.00", result);
        
        soin = "600";
        montant = "200.00";
        result = instance.calculMaximum(soin, montant);
        assertEquals("200.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("100.00", result);
        result = instance.calculMaximum(soin, montant);
        assertEquals("0.00", result);
        
    }
}
