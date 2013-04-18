package agile;

public class ContratE {

    public static int calculContratE(int soin, int montant) {
        int remboursement = 0;

        if (soin == 0) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 15);
        }
        if (soin == 100) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 25);
        }
        if (soin == 150) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 15);
        }
        if (soin == 175) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 25);
            if (remboursement > 2000) {
                remboursement = 2000;
            }
        }
        if (soin == 200) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 12);
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 60);
        }
        if (soin == 400) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 25);
            if (remboursement > 1500) {
                remboursement = 1500;
            }
        }
        if (soin == 500) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 30);
            if (remboursement > 2000) {
                remboursement = 2000;
            }
        }
        if (soin == 600) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 15);
        }
        if (soin == 700) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 22);
        }
        return remboursement;
    }
}