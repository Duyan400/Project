
package agile;


public class ContratB {
    
    public static int calculContratB(int soin, int montant){
        
        int remboursement = 0;
        
        if (soin == 0) {
            if (((montant / 100) * 50) > 40) {
                remboursement = 40;
            }
        }
        if (soin == 100) {
            if (((montant / 100) * 50) > 50) {
                remboursement = 50;
            }
        }
        if (soin == 150) {
            remboursement = (montant / 100) * 0;
        }
        if (soin == 175) {
            remboursement = (montant / 100) * 75;
        }
        if (soin == 200) {
            remboursement = (montant / 100) * 100;
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = (montant / 100) * 50;
        }
        if (soin == 400) {
            remboursement = (montant / 100) * 0;
        }
        if (soin == 500) {
            if (((montant / 100) * 50) > 50) {
                remboursement = 50;
            }
        }
        if (soin == 600) {
            remboursement = (montant / 100) * 100;
        }
        if (soin == 700) {
            remboursement = (montant / 100) * 70;
        }
        
        return remboursement;
    }
    
}
