package agile;

import java.util.List;

public class CalculRemboursements {

    public static String[] calculerRemboursements() throws Exception {

        List<String> listeDeSoins = LesGetters.getSoins();
        List<String> listeDeMontants = LesGetters.getMontants();
        String[] tabRemboursements = new String[listeDeMontants.size()];
        int remboursement = 0;
        for (int z = 0; z < listeDeMontants.size(); z++) {

            String numeroSoin = listeDeSoins.get(z);
            int numeroSoinEntier = Integer.parseInt(numeroSoin);

            switch (LesGetters.getContrat()) {
                case 'A':
                    remboursement = ContratA.calculContratA(numeroSoinEntier, Dollar.transformerEnEntier(listeDeMontants.get(z)));
                    tabRemboursements[z] = Dollar.transformerEnString(remboursement);
                    break;

                case 'B':
                    remboursement = ContratB.calculContratB(numeroSoinEntier, Dollar.transformerEnEntier(listeDeMontants.get(z)));
                    tabRemboursements[z] = Dollar.transformerEnString(remboursement);
                    break;

                case 'C':
                    remboursement = ContratC.calculContratC(numeroSoinEntier, Dollar.transformerEnEntier(listeDeMontants.get(z)));
                    tabRemboursements[z] = Dollar.transformerEnString(remboursement);
                    break;

                case 'D':
                    remboursement = ContratD.calculContratD(numeroSoinEntier, Dollar.transformerEnEntier(listeDeMontants.get(z)));
                    tabRemboursements[z] = Dollar.transformerEnString(remboursement);
                    break;

                case 'E':
                    remboursement = ContratE.calculContratE(numeroSoinEntier, Dollar.transformerEnEntier(listeDeMontants.get(z)));
                    tabRemboursements[z] = Dollar.transformerEnString(remboursement);
                    break;
            }

        }

        MaximumMensuel.maxMensuel(tabRemboursements);
        return tabRemboursements;
    }
}
