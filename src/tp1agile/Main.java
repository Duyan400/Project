/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1agile;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author lamjedslim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentReclamations reclamations = new DocumentReclamations("src/tp1agile/reclamations.xml");

        for (String clientNumber : reclamations.getClientsList()) {
            System.out.println(clientNumber);
        }

        for (String contratNumber : reclamations.getContratsList()) {
            System.out.println(contratNumber);
        }

        for (String soinNumber : reclamations.getSoinsList()) {
            System.out.println(soinNumber);
        }

        for (String montant : reclamations.getMontantsSoinsList()) {
            System.out.println(montant);
        }

//TEST DES VALIDATIONS
//VALIDATION NUMERO CLIENT
        if (reclamations.validerNumeroClient() == false) {
            System.out.println("numero client invalide");

        } else {
            System.out.println("numero client valide");
        }
//VALIDATION CONTRAT A B C D
        if (reclamations.validerContrat() == false) {
            System.out.println("contrat invalide");
        } else {
            System.out.println("contrat valide");
        }
//VALIDATION SIGNE $ APRES CHAQUE MONTANT
        if (reclamations.validerSigneDollar() == false) {
            System.out.println("il manque signe dollar");
        } else {
            System.out.println("montant valide");
        }
//VALIDATION NUMERO SOIN
        if (reclamations.validerNumeroSoin() == false) {
            System.out.println("numero de soin invalide");
        } else {
            System.out.println("numero de soin valide");
        }


    }
}