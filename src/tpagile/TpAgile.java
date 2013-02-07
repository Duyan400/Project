/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpagile;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author lamjedslim
 */
public class TpAgile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
        // TODO code application logic here

        DocumentReclamations reclamations = new DocumentReclamations("reclamations.xml");
        boolean a = DocumentReclamations.validerNumeroClient();
        boolean b = DocumentReclamations.validerContrat();
        boolean c = DocumentReclamations.validerSigneDollar();
        boolean d = DocumentReclamations.validerNumeroSoin();
        boolean e = DocumentReclamations.validerMois();


        reclamations.calcul();
        
        if (a==true && b==true && c==true && d==true && e==true  )
        {
           WriteXMLFile.test(); 
        }
        else
        {
            WriteXMLErreur.test();
        }
        
        
        
            
        

    
}

}
