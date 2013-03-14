

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Traitement {

    private static Document document;

    public Traitement(String documentFilePath) throws ParserConfigurationException, SAXException, IOException {
        parseXmlDocument(documentFilePath);
    }

    private void parseXmlDocument(String documentFilePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentFactory = initializeDocumentFactory();
        DocumentBuilder parser = documentFactory.newDocumentBuilder();
        document = parser.parse(documentFilePath);
    }

    private DocumentBuilderFactory initializeDocumentFactory() {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setIgnoringComments(true);
        documentFactory.setCoalescing(true);
        documentFactory.setNamespaceAware(true);
        return documentFactory;
    }

    public static boolean siElementDossierExiste() {
        if (document.getElementsByTagName("dossier").getLength() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean siElementMoisExiste() {
        if (document.getElementsByTagName("mois").getLength() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean siElementSoinExiste() {
        int nbReclamations = document.getElementsByTagName("reclamation").getLength();

        if (document.getElementsByTagName("soin").getLength() != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementDateExiste() {
        int nbReclamations = document.getElementsByTagName("reclamation").getLength();

        if (document.getElementsByTagName("date").getLength() != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean siElementMontantExiste() {
        int nbReclamations = document.getElementsByTagName("reclamation").getLength();

        if (document.getElementsByTagName("montant").getLength() != nbReclamations) {
            return false;
        } else {
            return true;
        }
    }

    public static NodeList getElementDossier() {

        NodeList dossiers = document.getElementsByTagName("dossier");
        return dossiers;
    }

    public static String getDossier() {
        String dossierClient = new String();
        List<String> liste = new ArrayList();
        NodeList dossier = getElementDossier();
        for (int i = 0; i < dossier.getLength(); i++) {
            Element numeroDossier = (Element) dossier.item(i);
            liste.add(numeroDossier.getTextContent());
            dossierClient = liste.get(0);
        }
        return dossierClient;
    }

    public static int getNumeroClient() {
        String dossier = getDossier();
        String numeroClient = "";

        for (int i = 1; i < dossier.length(); i++) {
            numeroClient = numeroClient + dossier.charAt(i);
        }
        return Integer.parseInt(numeroClient);
    }

    public static char getContrat() {
        char c = getDossier().charAt(0);
        return c;
    }

    public static String getMois() {
        String mois = new String();
        List<String> liste = new ArrayList();
        NodeList leMois = document.getElementsByTagName("mois");
        for (int i = 0; i < leMois.getLength(); i++) {
            Element moisNumber = (Element) leMois.item(i);
            liste.add(moisNumber.getTextContent());
            mois = liste.get(0);
        }
        return mois;
    }

    public static List<String> getSoins() {
        List<String> liste = new ArrayList();
        NodeList soins = document.getElementsByTagName("soin");
        for (int i = 0; i < soins.getLength(); i++) {
            Element numeroSoin = (Element) soins.item(i);
            liste.add(numeroSoin.getTextContent());
        }
        return liste;
    }

    public static List<String> getDates() {
        List<String> liste = new ArrayList();
        NodeList dates = document.getElementsByTagName("date");
        for (int i = 0; i < dates.getLength(); i++) {
            Element laDate = (Element) dates.item(i);
            liste.add(laDate.getTextContent());
        }
        return liste;
    }

    public static List<String> getMontants() {
        List<String> liste = new ArrayList();
        NodeList lesMontants = document.getElementsByTagName("montant");
        for (int i = 0; i < lesMontants.getLength(); i++) {
            Element montant = (Element) lesMontants.item(i);
            liste.add(montant.getTextContent());
        }
        return liste;
    }

    public static boolean validerNumeroClient() {
        int compteur = 0;
        int numeroClientInt = getNumeroClient();
        String numeroClient = Integer.toString(numeroClientInt);

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

    public static boolean validerContrat() {
        char typeContrat = getContrat();

        if (typeContrat != 'A' && typeContrat != 'B' && typeContrat != 'C' && typeContrat != 'D' && typeContrat != 'E') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validerSigneDollar() {
        boolean resultat = false;

        for (String montant : getMontants()) {
            if (montant.charAt(montant.length() - 1) != '$') {
                resultat = false;
            } else {
                resultat = true;
            }
        }
        return resultat;
    }

    public static boolean validerNumeroSoin() {
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

    public static boolean validerMois() {
        int compteur = 0;

        for (String date : getDates()) {
            String date2 = new String();
            date2 = date2 + (date.charAt(0));
            date2 = date2 + (date.charAt(1));
            date2 = date2 + (date.charAt(2));
            date2 = date2 + (date.charAt(3));
            date2 = date2 + (date.charAt(4));
            date2 = date2 + (date.charAt(5));
            date2 = date2 + (date.charAt(6));

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

    public static double[] calcul() {
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

    public static double totalRemboursements() {
        double total = 0;
        for (int i = 0; i < calcul().length; i++) {
            total = total + calcul()[i];
        }
        return total;
    }

    public static void remboursementContratA(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) {
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

    public static void remboursementContratB(int numeroSoinEntier, double y, double[] tabRemboursements, int compteurTab) {
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

    public static void remboursementContratC(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) {
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

    public static void remboursementContratD(int numeroSoinEntier, double y, double[] tabRemboursements, int compteurTab) {
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

    public static void remboursementContratE(int numeroSoinEntier, double[] tabRemboursements, int compteurTab, double y) {
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