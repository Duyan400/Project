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
        int compteur = 0;
        String numeroClient = LesGetters.getNumeroClient();
        if (numeroClient.length() != 6) {
            return false;
        } else {
            for (int i = 0; i < numeroClient.length(); i++) {
                if (numeroClient.charAt(i) > '9' || numeroClient.charAt(i) < '0') {
                    compteur++;
                }
            }
            if (compteur != 0) {
                return false;
            } else {
                return true;
            }
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

    public static boolean validerSigneDollar() throws Exception {
        int compteur = 0;
        boolean resultat = false;
        for (String montant : LesGetters.getMontants()) {
            if (montant.charAt(montant.length() - 1) != '$') {
                compteur++;
            }
        }
        if (compteur == 0) {
            resultat = true;
        }
        return resultat;
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

    public static boolean validerMois() throws Exception {
        int compteur = 0;
        for (String date : LesGetters.getDates()) {
            String date2 = new String();
            date2 = date2 + date.charAt(0);
            date2 = date2 + date.charAt(1);
            date2 = date2 + date.charAt(2);
            date2 = date2 + date.charAt(3);
            date2 = date2 + date.charAt(4);
            date2 = date2 + date.charAt(5);
            date2 = date2 + date.charAt(6);
            if (date2.equals(LesGetters.getMois())) {
                compteur = compteur + 1;
            }
        }
        if (compteur == LesGetters.getDates().size()) {
            return true;
        } else {
            return false;
        }
    }
}
