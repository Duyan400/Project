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
 
public class WriteXMLFile {
    
   static String numeroClient = DocumentReclamations.getClient();
   static String numeroMois = DocumentReclamations.getMois();
   static double [] tab = DocumentReclamations.calcul();
   
	public static void test() {
            
            
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("remboursement");
		doc.appendChild(rootElement);
                
                Element client = doc.createElement("client");
		client.appendChild(doc.createTextNode(numeroClient));
		rootElement.appendChild(client);
                
                Element mois = doc.createElement("mois");
		mois.appendChild(doc.createTextNode(numeroMois));
		rootElement.appendChild(mois);
 
		
                
                for (int i=0; i<tab.length; i++)
                {  
                    
                
                // remboursement elements
		Element remboursement = doc.createElement("remboursement");
		rootElement.appendChild(remboursement);
 
		
 
 
		
		Element soin = doc.createElement("soin");
		soin.appendChild(doc.createTextNode(DocumentReclamations.getSoins().get(i)));
		remboursement.appendChild(soin);
 
		
		Element date = doc.createElement("date");
		date.appendChild(doc.createTextNode(DocumentReclamations.getDates().get(i)));
		remboursement.appendChild(date);
 
		
		Element montant = doc.createElement("montant");
                String s = new String();
                s = "" + tab[i];
		montant.appendChild(doc.createTextNode(s));
		remboursement.appendChild(montant);
 
		
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("remboursements.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
                
                }
 
	  } catch (ParserConfigurationException pce) {
	  } catch (TransformerException tfe) {
	  }
          
          }
          
          
	
}