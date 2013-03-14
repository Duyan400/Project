

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlErreur {

    public static void enregistrer() {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("remboursements");
            doc.appendChild(rootElement);

            Element message = doc.createElement("message");
            if (Traitement.siElementDossierExiste() == false) {
                message.appendChild(doc.createTextNode("L'élément 'Dossier' est manquant."));
            } 
            else if (Traitement.siElementMoisExiste() == false) {
                message.appendChild(doc.createTextNode("L'élément 'mois' est manquant."));
            }
            else if (Traitement.siElementSoinExiste() == false) {
                message.appendChild(doc.createTextNode("L'élément 'soin' est manquant à une des reclamations."));
            }
            else if (Traitement.siElementDateExiste() == false) {
                message.appendChild(doc.createTextNode("L'élément 'date' est manquant à une des reclamations."));
            }
            else if (Traitement.siElementMontantExiste() == false) {
                message.appendChild(doc.createTextNode("L'élément 'montant' est manquant à une des reclamations."));
            }
            else {
            if (Traitement.validerContrat() == false) {
                message.appendChild(doc.createTextNode("Le Type du contrat est incorrect."));
            }
            if (Traitement.validerNumeroClient() == false) {
                message.appendChild(doc.createTextNode("Le numéro du client est invalide."));
            }
            if (Traitement.validerMois() == false) {
                message.appendChild(doc.createTextNode("Les dates entrées sont incorrectes."));
            }
            if (Traitement.validerNumeroSoin() == false) {
                message.appendChild(doc.createTextNode("Un numero de soin est invalide."));
            }
            if (Traitement.validerSigneDollar() == false) {
                message.appendChild(doc.createTextNode("Le signe du dollar est manquant."));
            }
            
            }

            rootElement.appendChild(message);

            // écriture du contenu dans le fichier xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Erreur.xml"));

            transformer.transform(source, result);
            System.out.println("Fichier enregistré");

        } catch (ParserConfigurationException pce) {
        } catch (TransformerException tfe) {
        }
    }
}