package tpagile;

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

public class DocumentReclamations {

    // pour l'affichage de réels avec deux décimales
    private static Document document;

    /**
     *
     * @param documentFilePath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public DocumentReclamations(String documentFilePath)
            throws ParserConfigurationException, SAXException, IOException {
        parseXmlDocument(documentFilePath);
    }

    private void parseXmlDocument(String documentFilePath)
            throws ParserConfigurationException, SAXException, IOException {
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

    public static String getDossier() {
        String dossierClient = new String();
        List<String> list = new ArrayList();
        NodeList dossiers;
        dossiers = document.getElementsByTagName("dossier");
        for (int i = 0; i < dossiers.getLength(); i++) {
            Element dossierNumber = (Element) dossiers.item(i);
            list.add(dossierNumber.getTextContent());
            dossierClient = list.get(0);
        }
        return dossierClient;
    }

    public static int getNumeroClient() {

        String dossier = getDossier();
        String numeroClient = "";
        int numeroClientInt = 0;
        for (int i = 1; i < dossier.length(); i++) {
            numeroClient = numeroClient + dossier.charAt(i);
        }

        numeroClientInt = Integer.parseInt(numeroClient);

        return numeroClientInt;
    }

    public static char getContrat() {
        char c = getDossier().charAt(0);
        return c;
    }

    public static String getMois() {
        String mois = new String();
        List<String> list = new ArrayList();
        NodeList leMois = document.getElementsByTagName("mois");
        for (int i = 0; i < leMois.getLength(); i++) {
            Element moisNumber = (Element) leMois.item(i);
            list.add(moisNumber.getTextContent());
            mois = list.get(0);
        }
        return mois;
    }

    public static List<String> getSoins() {
        List<String> list = new ArrayList();
        NodeList soins = document.getElementsByTagName("soin");
        for (int i = 0; i < soins.getLength(); i++) {
            Element soinNumber = (Element) soins.item(i);
            list.add(soinNumber.getTextContent());
        }
        return list;
    }

    public static List<String> getDates() {
        List<String> list = new ArrayList();
        NodeList dates = document.getElementsByTagName("date");
        for (int i = 0; i < dates.getLength(); i++) {
            Element dateNumber = (Element) dates.item(i);
            list.add(dateNumber.getTextContent());
        }
        return list;
    }

    public static List<String> getMontants() {
        List<String> list = new ArrayList();
        NodeList montantsSoins = document.getElementsByTagName("montant");
        for (int i = 0; i < montantsSoins.getLength(); i++) {
            Element montant = (Element) montantsSoins.item(i);
            list.add(montant.getTextContent());
        }
        return list;
    }

    public static boolean validerNumeroClient() {
        boolean resultat = false;
        int compteur = 0;
        int clientNumberInt = getNumeroClient();
        String clientNumber = Integer.toString(clientNumberInt);

        if (clientNumber.length() != 6) {
            resultat = false;
        } else {
            for (int i = 0; i < clientNumber.length(); i++) {
                char c = clientNumber.charAt(i);
                if (c > '9' || c < '0') {

                    compteur++;
                }
            }

            if (compteur != 0) {
                resultat = false;
            } else {
                resultat = true;
            }
        }




        return resultat;
    }

    public static boolean validerContrat() {
        boolean resultat = false;
        char contratLetter = getContrat();
        if (contratLetter != 'A' && contratLetter != 'B' && contratLetter != 'C' && contratLetter != 'D' && contratLetter != 'E') {
            resultat = false;
        } else {
            resultat = true;
        }

        return resultat;
    }

    public static boolean validerSigneDollar() {
        boolean resultat = false;


        for (String montant : getMontants()) {

            char c = montant.charAt(montant.length() - 1);
            if (c != '$') {
                resultat = false;
                break;
            } else {
                resultat = true;
            }
        }



        return resultat;
    }

    public static boolean validerNumeroSoin() {
        int j = 300;
        int compteur = 0;
        boolean reponse = false;
        int[] tab = {0, 100, 150, 175, 200, 400, 500, 600, 700};
        int[] tab2 = new int[100];
        for (int i = 0; i < tab2.length; i++) {


            tab2[i] = j;
            j = j + 1;

        }


        for (String numeroSoin : getSoins()) {
            int x = Integer.parseInt(numeroSoin);

            for (int a = 0; a < tab.length; a++) {
                int b = tab[a];
                if (x == b) {
                    compteur = compteur + 1;
                }

            }
            for (int c = 0; c < tab2.length; c++) {
                int d = tab2[c];
                if (x == d) {
                    compteur = compteur + 1;
                }
            }

        }



        if (compteur == getSoins().size()) {
            reponse = true;
        } else {
            reponse = false;
        }
        return reponse;
    }

    public static boolean validerMois() {


        boolean resultat = false;
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
            resultat = true;
        }

        return resultat;
    }

    // SECTION DES CALCUL DE REMBOURSEMENT
    public static double[] calcul() {



        int compteurTab = 0;

        List<String> listeDeSoins = getSoins();
        List<String> listeDeMontants = getMontants();

        double refund = 0;

        double[] tabRemboursements = new double[listeDeMontants.size()];


        for (int z = 0; z < listeDeMontants.size(); z++) {
            String numeroSoin = listeDeSoins.get(z);
            String montantVirgule = listeDeMontants.get(z);
            int x = Integer.parseInt(numeroSoin);


            montantVirgule = montantVirgule.substring(0, montantVirgule.length() - 1);
            String montantPoint = montantVirgule.replaceAll(",", ".");

            double y = Double.parseDouble(montantPoint);


            switch (getContrat()) {

                case 'A':

                    if (x == 0 || x == 200 || x == 500) {
                        refund = (y / 100) * 25;

                        tabRemboursements[compteurTab] = refund;

                    }

                    if (x == 100) {
                        refund = (y / 100) * 35;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 150) {
                        refund = (y / 100) * 0;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 175) {
                        refund = (y / 100) * 50;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 400 || x == 700 || (x >= 300 && x <= 399)) {
                        refund = (y / 100) * 0;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 600) {
                        refund = (y / 100) * 40;
                        tabRemboursements[compteurTab] = refund;
                    }
                    break;

                case 'B':

                    if (x == 0) {
                        refund = (y / 100) * 50;
                        if (refund > 40) {
                            refund = 40;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 100) {
                        refund = (y / 100) * 50;
                        if (refund > 50) {
                            refund = 50;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 150) {
                        refund = (y / 100) * 0;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 175) {
                        refund = (y / 100) * 75;
                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 200) {
                        refund = (y / 100) * 100;

                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x >= 300 && x <= 399) {
                        refund = (y / 100) * 50;
                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 400) {
                        refund = (y / 100) * 0;
                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 500) {
                        refund = (y / 100) * 50;
                        if (refund > 50) {
                            refund = 50;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 600) {
                        refund = (y / 100) * 100;
                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 700) {
                        refund = (y / 100) * 70;
                        tabRemboursements[compteurTab] = refund;


                    }
                    break;

                case 'C':

                    if (x == 100) {
                        refund = (y / 100) * 95;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 150) {
                        refund = (y / 100) * 85;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 175) {
                        refund = (y / 100) * 90;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 600) {
                        refund = (y / 100) * 75;

                        tabRemboursements[compteurTab] = refund;
                    } else {
                        refund = (y / 100) * 90;
                        tabRemboursements[compteurTab] = refund;
                    }
                    break;

                case 'D':

                    if (x == 0) {
                        refund = (y / 100) * 100;
                        if (refund > 85) {
                            refund = 85;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 100) {
                        refund = (y / 100) * 100;
                        if (refund > 75) {
                            refund = 75;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 150) {
                        refund = (y / 100) * 100;
                        if (refund > 150) {
                            refund = 150;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 175) {
                        refund = (y / 100) * 95;

                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 200) {
                        refund = (y / 100) * 100;
                        if (refund > 100) {
                            refund = 100;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x >= 300 && x <= 399) {
                        refund = (y / 100) * 100;
                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 400) {
                        refund = (y / 100) * 100;
                        if (refund > 65) {
                            refund = 65;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 500) {
                        refund = (y / 100) * 100;

                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 600) {
                        refund = (y / 100) * 100;
                        if (refund > 100) {
                            refund = 100;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 700) {
                        refund = (y / 100) * 100;
                        if (refund > 90) {
                            refund = 90;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                case 'E':

                    if (x == 0) {
                        refund = (y / 100) * 15;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 100) {
                        refund = (y / 100.0) * 25;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 150) {
                        refund = (y / 100.0) * 15;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x == 175) {
                        refund = (y / 100) * 25;
                        if (refund > 20) {
                            refund = 20;
                            tabRemboursements[compteurTab] = refund;
                        }
                    }

                    if (x == 200) {
                        refund = (y / 100) * 12;

                        tabRemboursements[compteurTab] = refund;
                    }

                    if (x >= 300 && x <= 399) {
                        refund = (y / 100) * 60;
                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 400) {
                        refund = (y / 100) * 25;
                        if (refund > 15) {
                            refund = 15;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 500) {
                        refund = (y / 100) * 30;
                        if (refund > 20) {
                            refund = 20;
                            tabRemboursements[compteurTab] = refund;
                        }

                    }

                    if (x == 600) {
                        refund = (y / 100) * 15;

                        tabRemboursements[compteurTab] = refund;


                    }

                    if (x == 700) {
                        refund = (y / 100) * 22;

                        tabRemboursements[compteurTab] = refund;


                    }


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
}
