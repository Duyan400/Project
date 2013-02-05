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
        //VALIDATION NUMERO MOIS
        if (reclamations.validerMois() == false) {
            System.out.println("mois de reclamation invalide");
        } else {
            System.out.println("la date des reclamations est valide");
        }
        reclamations.calcul();
        
        
        REMBOURSEMENT remboursement = new REMBOURSEMENT();
        remboursement.setSoin(reclamations.getSoins().get(0));
        remboursement.setDate(reclamations.getDates().get(0));
        remboursement.setMontant(reclamations.getMontants().get(0));
        
        
        
        WriteXMLFile.test();
        
        
        

    }
    
        
}
