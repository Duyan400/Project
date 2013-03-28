package agile;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Traitement {

    public static JSONObject reclamations;
    

    public static void parserJson() throws Exception {
        String json = FileReader.loadFileIntoString("1.json");
        reclamations = JSONObject.fromObject(json);
    }

    public static boolean siElementDossierExiste() throws Exception {
        String json = FileReader.loadFileIntoString("1.json");
        reclamations = JSONObject.fromObject(json);
        if (reclamations.has("dossier")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean siElementMoisExiste() throws Exception {
        if (reclamations.has("mois")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean siElementSoinExiste() throws Exception {
        parserJson();
        int nbReclamations = reclamations.getJSONArray("reclamations").size();
        int nbSoins = getSoins().size();
        if (nbSoins != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementDateExiste() throws Exception {
        parserJson();
        int nbReclamations = reclamations.getJSONArray("reclamations").size();
        int nbDates = getDates().size();
        if (nbDates != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementMontantExiste() throws Exception {
        parserJson();
        int nbReclamations = reclamations.getJSONArray("reclamations").size();
        int nbMontants = getMontants().size();
        if (nbMontants != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static String getDossier() throws Exception {
        parserJson();
        String dossier = reclamations.getString("dossier");
        return dossier;
    }

    public static String getNumeroClient() throws Exception {
        String dossier = getDossier();
        String numeroClient = dossier.substring(1);
        return numeroClient;
    }

    public static char getContrat() throws Exception {
        String dossier = getDossier();
        char TypeContrat = dossier.charAt(0);
        return TypeContrat;
    }

    public static String getMois() throws Exception {
        String mois = reclamations.getString("mois");
        return mois;
    }

    public static List<String> getSoins() throws JSONException, Exception {
        parserJson();
        List<String> liste = new ArrayList();
        try {
            JSONArray lesReclamations = reclamations.getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject uneReclamation = lesReclamations.getJSONObject(i);
                {
                    String leSoin = uneReclamation.getString("soin");
                    liste.add(leSoin);
                }
            }
        } catch (JSONException e) {
        }
        return liste;
    }

    public static List<String> getDates() throws Exception {
        parserJson();
        List<String> liste = new ArrayList();
        try {
            JSONArray lesReclamations = reclamations.getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject date = lesReclamations.getJSONObject(i);
                String laDate = date.getString("date");
                liste.add(laDate);
            }
        } catch (JSONException e) {
        }
        return liste;
    }

    public static List<String> getMontants() throws Exception {
        parserJson();
        List<String> liste = new ArrayList();
        try {
            JSONArray lesReclamations = reclamations.getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject montant = lesReclamations.getJSONObject(i);
                String leMontant = montant.getString("montant");
                liste.add(leMontant);
            }
        } catch (JSONException e) {
        }
        
        return liste;
    }

    public static boolean validerNumeroClient() throws Exception {
        int compteur = 0;
        String numeroClient = getNumeroClient();
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
        char typeContrat = getContrat();
        if (typeContrat != 'A' && typeContrat != 'B' && typeContrat != 'C' && typeContrat != 'D' && typeContrat != 'E') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validerSigneDollar() throws Exception {
        int compteur = 0;
        boolean resultat = false;
        for (String montant : getMontants()) {
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
        for (String numeroSoin : getSoins()) {
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
        if (compteur == getSoins().size()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validerMois() throws Exception {
        int compteur = 0;
        for (String date : getDates()) {
            String date2 = new String();
            date2 = date2 + date.charAt(0);
            date2 = date2 + date.charAt(1);
            date2 = date2 + date.charAt(2);
            date2 = date2 + date.charAt(3);
            date2 = date2 + date.charAt(4);
            date2 = date2 + date.charAt(5);
            date2 = date2 + date.charAt(6);
            if (date2.equals(getMois())) {
                compteur = compteur + 1;
            }
        }
        if (compteur == getDates().size()) {
            return true;
        } else {
            return false;
        }
    }

    public static double[] calcul() throws Exception {
        int compteurTab = 0;
        List<String> listeDeSoins = getSoins();
        List<String> listeDeMontants = getMontants();
        double[] tabRemboursements = new double[listeDeMontants.size()];
        for (int z = 0; z < listeDeMontants.size(); z++) {
            String numeroSoin = listeDeSoins.get(z);
            int numeroSoinEntier = Integer.parseInt(numeroSoin);
            String montantVirgule = listeDeMontants.get(z);
            montantVirgule = montantVirgule.substring(0, montantVirgule.length() - 1);
            String montantPoint = montantVirgule.replaceAll(",", ".");
            double montantDouble = Double.parseDouble(montantPoint);
            

            switch (getContrat()) {
                case 'A':
                    remboursementContratA(numeroSoinEntier, tabRemboursements, compteurTab, montantDouble);
                    break;

                case 'B':
                    remboursementContratB(numeroSoinEntier, montantDouble, tabRemboursements, compteurTab);
                    break;

                case 'C':
                    remboursementContratC(numeroSoinEntier, tabRemboursements, compteurTab, montantDouble);
                    break;

                case 'D':
                    remboursementContratD(numeroSoinEntier, montantDouble, tabRemboursements, compteurTab);
                    break;

                case 'E':
                    remboursementContratE(numeroSoinEntier, tabRemboursements, compteurTab, montantDouble);
                    break;
            }
            compteurTab++;
        }
        return tabRemboursements;
    }

    public static double totalRemboursements() throws Exception {
        double total = 0;
        double totalSoin100 = 0;
        double totalSoin175 = 0;
        double totalSoin200 = 0;
        double totalSoin500 = 0;
        double totalSoin600 = 0;
        double totalSoinAutre = 0;
        for (int i = 0; i < calcul().length; i++) {

            for (int j = 0; j < getSoins().size(); j++) {
                String soin = getSoins().get(j);
                if (soin.equals("100") && i == j) {
                    totalSoin100 = totalSoin100 + calcul()[i];
                } else if (soin.equals("175") && i == j) {
                    totalSoin175 = totalSoin175 + calcul()[i];
                } else if (soin.equals("200") && i == j) {
                    totalSoin200 = totalSoin200 + calcul()[i];
                } else if (soin.equals("500") && i == j) {
                    totalSoin500 = totalSoin500 + calcul()[i];
                } else if (soin.equals("600") && i == j) {
                    totalSoin600 = totalSoin600 + calcul()[i];
                } else if (!"100".equals(soin) && !"175".equals(soin) && !"200".equals(soin) && !"500".equals(soin) && !"600".equals(soin) && i == j) {
                    totalSoinAutre = totalSoinAutre + calcul()[i];
                }
            }
        }
        if (totalSoin100 > 250) {
            totalSoin100 = 250;
        }
        if (totalSoin175 > 200) {
            totalSoin175 = 200;
        }
        if (totalSoin200 > 250) {
            totalSoin200 = 250;
        }
        if (totalSoin500 > 150) {
            totalSoin500 = 150;
        }
        if (totalSoin600 > 300) {
            totalSoin600 = 300;
        }

        total = total + totalSoin100 + totalSoin175 + totalSoin200 + totalSoin500 + totalSoin600 + totalSoinAutre;
        return total;
    }

    public static void remboursementContratA(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) throws Exception {
        if (numeroSoinEntier == 0 || numeroSoinEntier == 200 || numeroSoinEntier == 500) {
            tabRemboursements[compteurTab] = (y / 100) * 25;
        }
        if (numeroSoinEntier == 100) {
            tabRemboursements[compteurTab] = (y / 100) * 35;
        }
        if (numeroSoinEntier == 150) {
            tabRemboursements[compteurTab] = (y / 100) * 0;
        }
        if (numeroSoinEntier == 175) {
            tabRemboursements[compteurTab] = (y / 100) * 50;
        }
        if (numeroSoinEntier == 400 || numeroSoinEntier == 700 || (numeroSoinEntier >= 300 && numeroSoinEntier <= 399)) {
            tabRemboursements[compteurTab] = (y / 100) * 0;
        }
        if (numeroSoinEntier == 600) {
            tabRemboursements[compteurTab] = (y / 100) * 40;
        }
    }

    public static void remboursementContratB(int numeroSoinEntier, double y, double[] tabRemboursements, int compteurTab) throws Exception {
        if (numeroSoinEntier == 0) {
            if (((y / 100) * 50) > 40) {
                tabRemboursements[compteurTab] = 40;
            }
        }
        if (numeroSoinEntier == 100) {
            if (((y / 100) * 50) > 50) {
                tabRemboursements[compteurTab] = 50;
            }
        }
        if (numeroSoinEntier == 150) {
            tabRemboursements[compteurTab] = (y / 100) * 0;
        }
        if (numeroSoinEntier == 175) {
            tabRemboursements[compteurTab] = (y / 100) * 75;
        }
        if (numeroSoinEntier == 200) {
            tabRemboursements[compteurTab] = (y / 100) * 100;
        }
        if (numeroSoinEntier >= 300 && numeroSoinEntier <= 399) {
            tabRemboursements[compteurTab] = (y / 100) * 50;
        }
        if (numeroSoinEntier == 400) {
            tabRemboursements[compteurTab] = (y / 100) * 0;
        }
        if (numeroSoinEntier == 500) {
            if (((y / 100) * 50) > 50) {
                tabRemboursements[compteurTab] = 50;
            }
        }
        if (numeroSoinEntier == 600) {
            tabRemboursements[compteurTab] = (y / 100) * 100;
        }
        if (numeroSoinEntier == 700) {
            tabRemboursements[compteurTab] = (y / 100) * 70;
        }
    }

    public static void remboursementContratC(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) throws Exception {
        if (numeroSoinEntier == 100) {
            tabRemboursements[compteurTab] = (y / 100) * 95;
        }
        if (numeroSoinEntier == 150) {
            tabRemboursements[compteurTab] = (y / 100) * 85;
        }
        if (numeroSoinEntier == 175) {
            tabRemboursements[compteurTab] = (y / 100) * 90;
        }
        if (numeroSoinEntier == 600) {
            tabRemboursements[compteurTab] = (y / 100) * 75;
        } else {
            tabRemboursements[compteurTab] = (y / 100) * 90;
        }
    }

    public static void remboursementContratD(int numeroSoinEntier, double y, double[] tabRemboursements, int compteurTab) throws Exception {
        if (numeroSoinEntier == 0) {
            if (((y / 100) * 100) > 85) {
                tabRemboursements[compteurTab] = 85;
            }
        }
        if (numeroSoinEntier == 100) {
            if (((y / 100) * 100) > 75) {
                tabRemboursements[compteurTab] = 75;
            }
        }
        if (numeroSoinEntier == 150) {
            if (((y / 100) * 100) > 150) {
                tabRemboursements[compteurTab] = 150;
            }
        }
        if (numeroSoinEntier == 175) {
            tabRemboursements[compteurTab] = (y / 100) * 95;
        }
        if (numeroSoinEntier == 200) {
            if (((y / 100) * 100) > 100) {
                tabRemboursements[compteurTab] = 100;
            }
        }
        if (numeroSoinEntier >= 300 && numeroSoinEntier <= 399) {
            tabRemboursements[compteurTab] = (y / 100) * 100;
        }
        if (numeroSoinEntier == 400) {
            if (((y / 100) * 100) > 65) {
                tabRemboursements[compteurTab] = 65;
            }
        }
        if (numeroSoinEntier == 500) {
            tabRemboursements[compteurTab] = (y / 100) * 100;
        }
        if (numeroSoinEntier == 600) {
            if (((y / 100) * 100) > 100) {
                tabRemboursements[compteurTab] = 100;
            }
        }
        if (numeroSoinEntier == 700) {
            if (((y / 100) * 100) > 90) {
                tabRemboursements[compteurTab] = 90;
            }
        }
    }

    public static void remboursementContratE(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) throws Exception {
        if (numeroSoinEntier == 0) {
            tabRemboursements[compteurTab] = (y / 100) * 15;
        }
        if (numeroSoinEntier == 100) {
            tabRemboursements[compteurTab] = (y / 100.0) * 25;
        }
        if (numeroSoinEntier == 150) {
            tabRemboursements[compteurTab] = (y / 100.0) * 15;
        }
        if (numeroSoinEntier == 175) {
            if (((y / 100) * 25) > 20) {
                tabRemboursements[compteurTab] = 20;
            }
        }
        if (numeroSoinEntier == 200) {
            tabRemboursements[compteurTab] = (y / 100) * 12;
        }
        if (numeroSoinEntier >= 300 && numeroSoinEntier <= 399) {
            tabRemboursements[compteurTab] = (y / 100) * 60;
        }
        if (numeroSoinEntier == 400) {
            if (((y / 100) * 25) > 15) {
                tabRemboursements[compteurTab] = 15;
            }
        }
        if (numeroSoinEntier == 500) {
            if (((y / 100) * 30) > 20) {
                tabRemboursements[compteurTab] = 20;
            }
        }
        if (numeroSoinEntier == 600) {
            tabRemboursements[compteurTab] = (y / 100) * 15;
        }
        if (numeroSoinEntier == 700) {
            tabRemboursements[compteurTab] = (y / 100) * 22;
        }
    }
}
