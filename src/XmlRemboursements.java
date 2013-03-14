

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

public class XmlRemboursements {

    static String totalRemb = "" + Traitement.totalRemboursements();
    static String dossierClient = Traitement.getDossier();
    static String numeroMois = Traitement.getMois();
    static double[] tab = Traitement.calcul();

    public static void enregistrer() {



        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("remboursements");
            doc.appendChild(rootElement);

            Element dossier = doc.createElement("dossier");
            dossier.appendChild(doc.createTextNode(dossierClient));
            rootElement.appendChild(dossier);

            Element mois = doc.createElement("mois");
            mois.appendChild(doc.createTextNode(numeroMois));
            rootElement.appendChild(mois);



            for (int i = 0; i < tab.length; i++) {

                Element remboursement = doc.createElement("remboursement");
                rootElement.appendChild(remboursement);

                Element soin = doc.createElement("soin");
                soin.appendChild(doc.createTextNode(Traitement.getSoins().get(i)));
                remboursement.appendChild(soin);

                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode(Traitement.getDates().get(i)));
                remboursement.appendChild(date);


                Element montant = doc.createElement("montant");
                String s = new String();
                s = "" + (tab[i]) + "$";
                montant.appendChild(doc.createTextNode(s));
                remboursement.appendChild(montant);

            }

            Element total = doc.createElement("total");
            total.appendChild(doc.createTextNode(totalRemb));
            rootElement.appendChild(total);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("remboursements.xml"));

            transformer.transform(source, result);
            System.out.println("Fichier enregistré!");

        } catch (ParserConfigurationException pce) {
        } catch (TransformerException tfe) {
        }

    }
}