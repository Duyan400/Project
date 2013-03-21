

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
//testestestest
        String in = args[0];
        String out = args[1];
        Traitement reclamations = new Traitement(in);
        
        Traitement.siElementSoinExiste();
        
        boolean a = Traitement.siElementDossierExiste();
        boolean b = Traitement.siElementMoisExiste();
        boolean c = Traitement.siElementSoinExiste();
        boolean d = Traitement.siElementDateExiste();
        boolean e = Traitement.siElementMontantExiste();
        if (a == false || b == false || c == false || d == false || e == false)
        {
            XmlErreur.enregistrer();
        }
        else
        {
        boolean f = Traitement.validerContrat();
        boolean g = Traitement.validerNumeroClient();
        boolean h = Traitement.validerMois();
        boolean i = Traitement.validerNumeroSoin();
        boolean j = Traitement.validerSigneDollar();
        
        

        if (f == true && g == true && h == true && i == true && j == true) {
            reclamations.calcul();
            XmlRemboursements.enregistrer();
        } else {
            XmlErreur.enregistrer();
        }

    }
        
    }
}