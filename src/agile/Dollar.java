package agile;

public class Dollar {

    public static int transformerEnEntier(String montant) {
        montant = montant.replace(",", "");
        montant = montant.replace(".", "");
        montant = montant.replace("$", "");
        Integer montantEntier = Integer.parseInt(montant);
        return montantEntier;
    }

    public static int additionner(int nombre, int additionneur) {
        nombre = nombre + additionneur;
        return nombre;
    }

    public static int soustraire(int nombre, int soustracteur) {
        nombre = nombre - soustracteur;
        return nombre;
    }

    public static int multiplier(int nombre, int multiplicateur) {
        nombre = nombre * multiplicateur;
        return nombre;
    }

    public static int diviser(int nombre, int diviseur) {
        nombre = nombre / diviseur;
        return nombre;
    }

    public static int modulo(int nombre, int moduleur) {
        nombre = nombre % moduleur;
        return nombre;
    }

    public static String trasnformerEnString(int montant) {
        int dollar = montant / 100;
        int cents = montant % 100;
        String montantFinalString = dollar + "." + cents;
        return montantFinalString;
    }
}
