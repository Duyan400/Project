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

    public static int diviser(int nombre, int diviseur) throws ArithmeticException {
        try{
            nombre = nombre / diviseur;
        }catch (ArithmeticException e){
            System.out.println("Division par zéro impossible ");
        }
        return nombre;
    }

    public static int modulo(int nombre, int moduleur) throws ArithmeticException {
       try{
        
        nombre = nombre % moduleur;
       }catch(ArithmeticException e){
           System.out.print("Modulo par zéro impossible");
       }
        
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
