package agile;

public class ContratA {

    public static int calculContratA(int soin, int montant) {
        int remboursement = 0;

        if (soin == 0 || soin == 200 || soin == 500) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 25);
        }
        if (soin == 100) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 35);
        }
        if (soin == 150) {
            remboursement = 0;
        }
        if (soin == 175) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 50);
        }
        if (soin == 400 || soin == 700 || (soin >= 300 && soin <= 399)) {
            remboursement = 0;
        }
        if (soin == 600) {
            remboursement = Dollar.diviser(montant, 100);
            remboursement = Dollar.multiplier(remboursement, 40);
        }

        return remboursement;
    }
}