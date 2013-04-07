package agile;

public class ContratD {
    
    public static int calculContratD(int soin , int montant ){
        
        int remboursement = 0 ; 
        
        if (soin == 0) {
            if (((montant / 100) * 100) > 85) {
                remboursement = 85;
            }
        }
        if (soin == 100) {
            if (((montant / 100) * 100) > 75) {
                remboursement = 75;
            }
        }
        if (soin == 150) {
            if (((montant / 100) * 100) > 150) {
                remboursement = 150;
            }
        }
        if (soin == 175) {
            remboursement = (montant / 100) * 95;
        }
        if (soin == 200) {
            if (((montant / 100) * 100) > 100) {
                remboursement = 100;
            }
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = (montant / 100) * 100;
        }
        if (soin == 400) {
            if (((montant / 100) * 100) > 65) {
                remboursement = 65;
            }
        }
        if (soin == 500) {
            remboursement = (montant / 100) * 100;
        }
        if (soin == 600) {
            if (((montant / 100) * 100) > 100) {
                remboursement = 100;
            }
        }
        if (soin == 700) {
            if (((montant / 100) * 100) > 90) {
                remboursement = 90;
            }
        }
        
        return remboursement;
    }
}
        
        
    
    

