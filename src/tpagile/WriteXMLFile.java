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
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class WriteXMLFile {
 
	public static void test() {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("remboursement");
		doc.appendChild(rootElement);
                
                Element client = doc.createElement("client");
		client.appendChild(doc.createTextNode("bonjour"));
		rootElement.appendChild(client);
                
                Element mois = doc.createElement("mois");
		mois.appendChild(doc.createTextNode("bonjour"));
		rootElement.appendChild(mois);
 
		// remboursement elements
		Element remboursement = doc.createElement("remboursement");
		rootElement.appendChild(remboursement);
 
		
 
 
		// firstname elements
		Element firstname = doc.createElement("soin");
		firstname.appendChild(doc.createTextNode("bonjour"));
		remboursement.appendChild(firstname);
 
		// lastname elements
		Element date = doc.createElement("date");
		date.appendChild(doc.createTextNode("mook kim"));
		remboursement.appendChild(date);
 
		// nickname elements
		Element montant = doc.createElement("montant");
		montant.appendChild(doc.createTextNode("mkyong"));
		remboursement.appendChild(montant);
 
		
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}