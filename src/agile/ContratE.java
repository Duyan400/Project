package agile;

public class ContratE {

    public static int calculContratE(int soin, int montant) {

        int remboursement = 0;

        if (soin == 0) {
            remboursement = (montant / 100) * 15;
        }
        if (soin == 100) {
            remboursement = (montant / 100) * 25;
        }
        if (soin == 150) {
            remboursement = (montant / 100) * 15;
        }
        if (soin == 175) {
            if (((montant / 100) * 25) > 20) {
                remboursement = 20;
            }
        }
        if (soin == 200) {
            remboursement = (montant / 100) * 12;
        }
        if (soin >= 300 && soin <= 399) {
            remboursement = (montant / 100) * 60;
        }
        if (soin == 400) {
            if (((montant / 100) * 25) > 15) {
                remboursement = 15;
            }
        }
        if (soin == 500) {
            if (((montant / 100) * 30) > 20) {
                remboursement = 20;
            }
        }
        if (soin == 600) {
            remboursement = (montant / 100) * 15;
        }
        if (soin == 700) {
            remboursement = (montant / 100) * 22;
        }

        return remboursement;
    }
}
