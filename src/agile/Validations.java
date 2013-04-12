package agile;

public class Validations {

    public static boolean siElementDossierExiste() throws Exception {
        return (Main.parserJson(Main.entree).has("dossier"));
    }

    public static boolean siElementMoisExiste() throws Exception {
        return (Main.parserJson(Main.entree).has("mois"));
    }

    public static boolean siElementSoinExiste() throws Exception {
        int nbReclamations = (Main.parserJson(Main.entree)).getJSONArray("reclamations").size();
        int nbSoins = LesGetters.getSoins().size();
        if (nbSoins != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementCodeExiste() throws Exception {
        int nbReclamations = (Main.parserJson(Main.entree)).getJSONArray("reclamations").size();
        int nbCodes = LesGetters.getCodes().size();
        if (nbCodes != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementDateExiste() throws Exception {
        int nbReclamations = (Main.parserJson(Main.entree)).getJSONArray("reclamations").size();
        int nbDates = LesGetters.getDates().size();
        if (nbDates != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementMontantExiste() throws Exception {
        int nbReclamations = (Main.parserJson(Main.entree)).getJSONArray("reclamations").size();
        int nbMontants = LesGetters.getMontants().size();
        if (nbMontants != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validerNumeroClient() throws Exception {
        String numeroClient = LesGetters.getNumeroClient();
        if (numeroClient.length() != 6) {
            return false;
        } else {
            for (int i = 0; i < numeroClient.length(); i++) {
                if (numeroClient.charAt(i) > '9' || numeroClient.charAt(i) < '0') {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean validerContrat() throws Exception {
        char typeContrat = LesGetters.getContrat();
        if (typeContrat != 'A' && typeContrat != 'B' && typeContrat != 'C' && typeContrat != 'D' && typeContrat != 'E') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validerSyntaxeMontant() throws Exception {
        boolean resultat = false;
        for (String montant : LesGetters.getMontants()) {
            resultat = boucleValiderSyntaxeMontant(montant);
        }
        return resultat;
    }

    public static boolean boucleValiderSyntaxeMontant(String montant) {
        if (montant.charAt(montant.length() - 1) != '$') {
            return false;
        } else if (montant.charAt(montant.length() - 2) < '0' || montant.charAt(montant.length() - 2) > '9') {
            return false;
        } else if (montant.charAt(montant.length() - 3) < '0' || montant.charAt(montant.length() - 3) > '9') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validerNumeroSoin() throws Exception {
        int j = 300;
        int compteur = 0;
        int[] tab = {0, 100, 150, 175, 200, 400, 500, 600, 700};
        int[] tab2 = new int[100];
        for (int i = 0; i < tab2.length; i++) {
            tab2[i] = j;
            j = j + 1;
        }
        for (String numeroSoin : LesGetters.getSoins()) {
            int numeroSoinEntier = Integer.parseInt(numeroSoin);

            for (int a = 0; a < tab.length; a++) {
                if (numeroSoinEntier == tab[a]) {
                    compteur = compteur + 1;
                }
            }
            for (int c = 0; c < tab2.length; c++) {
                if (numeroSoinEntier == tab2[c]) {
                    compteur = compteur + 1;
                }
            }
        }
        if (compteur == LesGetters.getSoins().size()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validerCode() throws Exception {

        int compteur = 0;

        for (String code : LesGetters.getCodes()) {
            if (code.charAt(0) == 'A' || code.charAt(0) == 'C') {
                compteur++;
            }
            if (code.charAt(0) == 'E' || code.charAt(0) == 'H') {
                String chaine = code.substring(1);
                boolean resultat = (validerChiffresCode(chaine));
                if (resultat == true) {
                    compteur++;
                }
            }
        }
        if (compteur == LesGetters.getCodes().size()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validerChiffresCode(String chaine) throws Exception {
        int compteur = 0;
        for (int i = 0; i < chaine.length(); i++) {
            if (chaine.charAt(i) > '0' && chaine.charAt(i) <= '9') {
                compteur++;
            }
        }
        if (compteur == chaine.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validerMois() throws Exception {
        int compteur = 0;
        for (String date : LesGetters.getDates()) {
            String date2 = new String();
            for (int i = 0; i < 7; i++) {
                date2 = date2 + date.charAt(i);
            }
            if (date2.equals(LesGetters.getMois())) {
                compteur++;
            }
        }
        if (compteur == LesGetters.getDates().size()) {
            return true;
        }
        return false;
    }

    public static boolean validerUnSeulAdherant() throws Exception {

        int compteur = 0;

        for (int i = 0; i < LesGetters.getCodes().size(); i++) {
            String leCode = LesGetters.getCodes().get(i);
            if (leCode.equals("A")) {
                compteur++;
            }
        }

        if (compteur > 1) {
            return false;
        } else {
            return true;
        }
    }
    
     public static boolean validerUnSeulConjoint() throws Exception {

        int compteur = 0;

        for (int i = 0; i < LesGetters.getCodes().size(); i++) {
            String leCode = LesGetters.getCodes().get(i);
            if (leCode.equals("C")) {
                compteur++;
            }
        }

        if (compteur > 1) {
            return false;
        } else {
            return true;
        }
    }
}