package tpagile;

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

public class WriteXMLErreur {

    public static void test() {



        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("remboursement");
            doc.appendChild(rootElement);


            Element message = doc.createElement("message");
            if (DocumentReclamations.validerContrat() == false) {
                message.appendChild(doc.createTextNode("Le Type du contrat est incorrect."));
            }
            if (DocumentReclamations.validerNumeroClient() == false) {
                message.appendChild(doc.createTextNode("Le numéro du client est invalide."));
            }
            if (DocumentReclamations.validerMois() == false) {
                message.appendChild(doc.createTextNode("Les dates entrées sont incorrectes."));
            }
            if (DocumentReclamations.validerNumeroSoin() == false) {
                message.appendChild(doc.createTextNode("Un numero de soin est invalide."));
            }
            if (DocumentReclamations.validerSigneDollar() == false) {
                message.appendChild(doc.createTextNode("Le signe du dollar est manquant."));
            }

            rootElement.appendChild(message);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Erreur.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");



        } catch (ParserConfigurationException pce) {
        } catch (TransformerException tfe) {
        }

    }
}