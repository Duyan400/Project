
package agile;

import java.math.BigDecimal;

public class Dollar {
    
    
    public static int convertirEnCents(String montant)
    {
        BigDecimal dollars = new BigDecimal(montant);
        int cents = dollars.multiply(new BigDecimal(100)).intValue();
        return cents;
    }
    
    public static String calculSecuritaire(int montant)
    {
        String montantFinal = "";
        int divisionPar100 = montant / 100;
        int modulo100 = montant %  100;
        montantFinal = "" + divisionPar100 + "." + modulo100;
      
        return montantFinal;  
    }
    
    public static int additionner(int a, int b)
    {
        int resultat = a + b;
        return resultat;
    }
    
    public static int diviser(int a, int b)
    {
        int resultat = a / b;
        return resultat;
    }
    
    public static int multiplier(int a, int b)
    {
        int resultat = a * b;
        return resultat;
    }
    
    
}
