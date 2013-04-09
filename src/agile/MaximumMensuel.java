package agile;

import java.util.List;

public class MaximumMensuel {

    public static void maxMensuel(String[] tab, List<String> list) throws Exception {

        int maxSoin100 = 25000;
        int maxSoin175 = 20000;
        int maxSoin200 = 25000;
        int maxSoin500 = 15000;
        int maxSoin600 = 30000;

        for (int j = 0; j < LesGetters.getSoins().size(); j++) {

            for (int i = 0; i < tab.length; i++) {

                String soin = LesGetters.getSoins().get(j);

                if (soin.equals("100") && i == j) {

                    if (maxSoin100 - Dollar.transformerEnEntier(tab[i]) < 0) {
                        tab[i] = Dollar.trasnformerEnString(maxSoin100);
                    } else {
                        maxSoin100 = maxSoin100 - Dollar.transformerEnEntier(tab[i]);
                    }

                } else if (soin.equals("175") && i == j) {

                    if (maxSoin175 - Dollar.transformerEnEntier(tab[i]) < 0) {
                        tab[i] = Dollar.trasnformerEnString(maxSoin175);
                    } else {
                        maxSoin175 = maxSoin175 - Dollar.transformerEnEntier(tab[i]);
                    }
                } else if (soin.equals("200") && i == j) {

                    if (maxSoin200 - Dollar.transformerEnEntier(tab[i]) < 0) {
                        tab[i] = Dollar.trasnformerEnString(maxSoin200);
                    } else {
                        maxSoin200 = maxSoin200 - Dollar.transformerEnEntier(tab[i]);
                    }
                } else if (soin.equals("500") && i == j) {

                    if (maxSoin500 - Dollar.transformerEnEntier(tab[i]) < 0) {
                        tab[i] = Dollar.trasnformerEnString(maxSoin500);
                    } else {
                        maxSoin500 = maxSoin500 - Dollar.transformerEnEntier(tab[i]);
                    }
                } else if (soin.equals("600") && i == j) {

                    if (maxSoin600 - Dollar.transformerEnEntier(tab[i]) < 0) {
                        tab[i] = Dollar.trasnformerEnString(maxSoin600);
                    } else {
                        maxSoin600 = maxSoin600 - Dollar.transformerEnEntier(tab[i]);
                    }
                }
            }
        }
    }
}
