package agile;

public class Enfant {

    private int maxSoin100;
    private int maxSoin175;
    private int maxSoin200;
    private int maxSoin500;
    private int maxSoin600;
    private String code;

    public Enfant() {
        this.maxSoin100 = 25000;
        this.maxSoin175 = 20000;
        this.maxSoin200 = 25000;
        this.maxSoin500 = 15000;
        this.maxSoin600 = 30000;
        this.code = "";
    }
    
    public void setMaxSoin100(int nouveauMax) {
        this.maxSoin100 = nouveauMax;
    }
    
    public void setMaxSoin175(int nouveauMax) {
        this.maxSoin175 = nouveauMax;
    }
    
    public void setMaxSoin200(int nouveauMax) {
        this.maxSoin200 = nouveauMax;
    }
    
    public void setMaxSoin500(int nouveauMax) {
        this.maxSoin500 = nouveauMax;
    }
    
    public void setMaxSoin600(int nouveauMax) {
        this.maxSoin600 = nouveauMax;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return this.code;
    }

    public String calculMaximum(String soin, String montant) {

        String resultat = new String();
        switch (soin) {
            case "100":
                if (this.maxSoin100 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(this.maxSoin100);
                } else {
                    this.maxSoin100 = this.maxSoin100 - Dollar.transformerEnEntier(montant);

                }
                break;
            case "175":
                if (this.maxSoin175 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(this.maxSoin175);
                } else {
                    this.maxSoin175 = this.maxSoin175 - Dollar.transformerEnEntier(montant);
                }
                break;
            case "200":
                if (this.maxSoin200 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(this.maxSoin200);
                } else {
                    this.maxSoin200 = this.maxSoin200 - Dollar.transformerEnEntier(montant);
                }
                break;
            case "500":
                if (this.maxSoin500 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(this.maxSoin500);
                } else {
                    this.maxSoin500 = this.maxSoin500 - Dollar.transformerEnEntier(montant);
                }
                break;
            case "600":
                if (maxSoin600 - Dollar.transformerEnEntier(montant) < 0) {
                    resultat = Dollar.transformerEnString(this.maxSoin600);
                } else {
                    this.maxSoin600 = this.maxSoin600 - Dollar.transformerEnEntier(montant);
                }
                break;
        }
        return resultat;
    }
}
