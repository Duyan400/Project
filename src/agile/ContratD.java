package agile;

public class ContratD {

    public static int calculContratD(int soin, int montant) {
        int remboursement = 0;

        if (soin == 0) {
            remboursement = montant;
            if (remboursement > 8500) {
                remboursement = 8500;
            }
        }
        if (soin == 100) {
            remboursement = montant;
            if (remboursement > 7500) {
                remboursement = 7500;
            }
        }
        if (soin == 150) {
            remboursement = montant;
            if (remboursement > 15000) {
                remboursement = 15000;
            }
        }
        if (soin == 175) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 95);
        }
        if (soin == 200) {
            remboursement = montant;
            if (remboursement > 10000) {
                remboursement = 10000;
            }
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = montant;
        }
        if (soin == 400) {
            remboursement = montant;
            if (remboursement > 6500) {
                remboursement = 6500;
            }
        }
        if (soin == 500) {
            remboursement = montant;
        }
        if (soin == 600) {
            remboursement = montant;
            if (remboursement > 10000) {
                remboursement = 10000;
            }
        }
        if (soin == 700) {
            remboursement = montant;
            if (remboursement > 9000) {
                remboursement = 9000;
            }
        }
        return remboursement;
    }
}