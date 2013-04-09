
package agile;


public class CalculTotalRemboursements {
    
    public static String totalRemboursements() throws Exception {
        
        String[] tab = CalculRemboursements.calculerRemboursements();
        int total = 0;
        String totalString = new String();
        for (int i=0; i<tab.length; i++)
        {
            total = total + Dollar.transformerEnEntier(tab[i]);
        }
        
        totalString = Dollar.trasnformerEnString(total);
        
        return totalString;
    }
    
}
