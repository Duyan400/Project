package agile;

public class ContratC {

    public static int calculContratC(int soin, int montant) {
        int remboursement = 0;

        if (soin == 100) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 95);
        } else if (soin == 150) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 85);
        } else if (soin == 175) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 90);
        } else if (soin == 600) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 75);
        } else {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 90);
        }
        return remboursement;
    }
}