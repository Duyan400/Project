package agile;

public class Enfant {

    private int maxSoin100;
    private int maxSoin175;
    private int maxSoin200;
    private int maxSoin500;
    private int maxSoin600;
    private String code;

    public Enfant() {
        maxSoin100 = 25000;
        maxSoin175 = 20000;
        maxSoin200 = 25000;
        maxSoin500 = 15000;
        maxSoin600 = 30000;
        code = "";
    }

    public int getMaxSoin100() {
        return maxSoin100;
    }

    public void setMaxSoin100(int nouveauMax) {
        maxSoin100 = nouveauMax;
    }

    public void setMaxSoin175(int nouveauMax) {
        maxSoin175 = nouveauMax;
    }

    public void setMaxSoin200(int nouveauMax) {
        maxSoin200 = nouveauMax;
    }

    public void setMaxSoin500(int nouveauMax) {
        maxSoin500 = nouveauMax;
    }

    public void setMaxSoin600(int nouveauMax) {
        maxSoin600 = nouveauMax;
    }

    public void setCode(String leCode) {
        code = leCode;
    }

    public String getCode() {
        return code;
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
