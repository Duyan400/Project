package agile;

public class Conjoint {

    private int maxSoin100;
    private int maxSoin175;
    private int maxSoin200;
    private int maxSoin500;
    private int maxSoin600;

    public Conjoint() {
        maxSoin100 = 25000;
        maxSoin175 = 20000;
        maxSoin200 = 25000;
        maxSoin500 = 15000;
        maxSoin600 = 30000;
    }

   
    public String calculMaximum(String soin, String montant) {

        String resultat = new String();
        switch (soin) {
            case "100":
                if (maxSoin100 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(maxSoin100);
                } else {
                    maxSoin100 = maxSoin100 - Dollar.transformerEnEntier(montant);
                    resultat = montant;
                }
                break;
            case "175":
                if (maxSoin175 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(maxSoin175);
                } else {
                    maxSoin175 = maxSoin175 - Dollar.transformerEnEntier(montant);
                    resultat = montant;
                }
                break;
            case "200":
                if (maxSoin200 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(maxSoin200);
                } else {
                    maxSoin200 = maxSoin200 - Dollar.transformerEnEntier(montant);
                    resultat = montant;
                }
                break;
            case "500":
                if (maxSoin500 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(maxSoin500);
                } else {
                    maxSoin500 = maxSoin500 - Dollar.transformerEnEntier(montant);
                    resultat = montant;
                }
                break;
            case "600":
                if (maxSoin600 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(maxSoin600);
                } else {
                    maxSoin600 = maxSoin600 - Dollar.transformerEnEntier(montant);
                    resultat = montant;
                }
                break;
        }
        return resultat;
    }
}
