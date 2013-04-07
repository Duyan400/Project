
package agile;


public class ContratC {
    
    public static int calculContratC(int soin, int montant){
        
        int remboursement = 0;
        
         if (soin == 100) {
            remboursement = (montant / 100) * 95;
        }
        if (soin == 150) {
            remboursement = (montant / 100) * 85;
        }
        if (soin == 175) {
            remboursement = (montant / 100) * 90;
        }
        if (soin == 600) {
            remboursement = (montant / 100) * 75;
        } else {
            remboursement = (montant / 100) * 90;
        }
        
        return remboursement;
        
    }
        
        
    
}
