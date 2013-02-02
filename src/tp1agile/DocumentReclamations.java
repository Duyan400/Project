package tp1agile;

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

    private Document document;

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

    public List<String> getClientsList() {
        List<String> list = new ArrayList();
        NodeList clients = document.getElementsByTagName("client");
        for (int i = 0; i < clients.getLength(); i++) {
            Element clientNumber = (Element) clients.item(i);
            list.add(clientNumber.getTextContent());
        }
        return list;
    }

    public List<String> getContratsList() {
        List<String> list = new ArrayList();
        NodeList contrats = document.getElementsByTagName("contrat");
        for (int i = 0; i < contrats.getLength(); i++) {
            Element contratNumber = (Element) contrats.item(i);
            list.add(contratNumber.getTextContent());
        }
        return list;
    }

    public List<String> getSoinsList() {
        List<String> list = new ArrayList();
        NodeList soins = document.getElementsByTagName("soin");
        for (int i = 0; i < soins.getLength(); i++) {
            Element soinNumber = (Element) soins.item(i);
            list.add(soinNumber.getTextContent());
        }
        return list;
    }

    public List<String> getMontantsSoinsList() {
        List<String> list = new ArrayList();
        NodeList montantsSoins = document.getElementsByTagName("montant");
        for (int i = 0; i < montantsSoins.getLength(); i++) {
            Element montant = (Element) montantsSoins.item(i);
            list.add(montant.getTextContent());
        }
        return list;
    }

    public boolean validerNumeroClient() {
        boolean resultat = false;

        for (String clientNumber : getClientsList()) {
            if (clientNumber.length() > 6) {
                return false;
            }
            for (int i = 0; i < clientNumber.length(); i++) {
                if (clientNumber.charAt(i) > '9' || clientNumber.charAt(i) < '0') {
                    resultat = false;
                } else {
                    resultat = true;
                }
            }
        }
        return resultat;

    }

    public boolean validerContrat() {
        boolean resultat = false;
        for (String contratNumber : getContratsList()) {
            if (!"A".equals(contratNumber) && !"B".equals(contratNumber) && !"C".equals(contratNumber) && !"D".equals(contratNumber)) {
                resultat = false;
            } else {
                resultat = true;
            }
        }
        return resultat;
    }

    public boolean validerSigneDollar() {
        boolean resultat = false;


        for (String montant : getMontantsSoinsList()) {

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

    public boolean validerNumeroSoin() {
        boolean reponse ;
        int[] tab = {0, 100, 200, 400, 500, 600, 700};
        int[] tab2 = new int[100];
        int j = 300;
        for (int i = 0; i < tab2.length; i++) {
            tab2[i] = j;
            j = j + 1;
        }
        for (String numeroSoin : getSoinsList()) {
            int x = Integer.parseInt(numeroSoin);
            reponse=false;
               for (int a : tab) {
                System.out.println("x et a:" + x + " "  + a );
                if (x == a) {
                    reponse = true;
                    break;
                }
                System.out.println("premier for" + reponse );
            }
            if (reponse == false){
                for (int b : tab2) {
                    System.out.println("x et b:" + x + " "  + b );
                    if (x == b) {
                        reponse = true;
                        break;
                    }
                    System.out.println("deuxieme for" + reponse );
                }
                if (reponse == false) {
                    return false;
                }
            }
        }
        return true;
    }
}   
    

