package agile;

public class Dollar {

    public static int transformerEnEntier(String montant) {
        montant = montant.replace(",", "");
        montant = montant.replace(".", "");
        montant = montant.replace("$", "");
        int montantEntier = Integer.parseInt(montant);
        return montantEntier;
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

    public static String transformerEnString(int montant) {
        String montantFinalString = new String();
        int dollar = montant / 100;
        int cents = montant % 100;
        if (cents == 0) {
            montantFinalString = dollar + "." + cents + "0";
        } else {
            montantFinalString = dollar + "." + cents;
        }
        return montantFinalString;
    }
}
