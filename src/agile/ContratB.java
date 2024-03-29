package agile;

public class ContratB {

    public static int calculContratB(int soin, int montant) {
        int remboursement = 0;

        if (soin == 0) {
            remboursement = Dollar.diviser(montant, 2);
            if (remboursement > 4000){
                remboursement = 4000;
            }
        }
        if (soin == 100) {
            remboursement = Dollar.diviser(montant, 2);
            if (remboursement > 5000) {
                remboursement = 5000;
            }
        }
        if (soin == 150) {
            remboursement = 0;
        }
        if (soin == 175) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 75);
        }
        if (soin == 200) {
            remboursement = montant;
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = Dollar.diviser(montant, 2);
        }
        if (soin == 400) {
            remboursement = 0;
        }
        if (soin == 500) {
            remboursement = Dollar.diviser(montant, 2);
            if (remboursement > 5000) {
                remboursement = 5000;
            }
        }
        if (soin == 600) {
            remboursement = montant;
        }
        if (soin == 700) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 70);
        }
        return remboursement;
    }
}
