package tpagile;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class TpAgile {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {


        String in = args[0];
        String out = args[1];
        DocumentReclamations reclamations = new DocumentReclamations(in);


        boolean a = DocumentReclamations.validerContrat();
        boolean b = DocumentReclamations.validerNumeroClient();
        boolean c = DocumentReclamations.validerMois();
        boolean d = DocumentReclamations.validerNumeroSoin();
        boolean e = DocumentReclamations.validerSigneDollar();


        reclamations.calcul();

        if (a == true && b == true && c == true && d == true && e == true) {
            WriteXMLFile.test();
        } else {
            WriteXMLErreur.test();
        }

    }
}
