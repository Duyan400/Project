/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {


        JSONObject objetJson = new JSONObject();
        String monFichier = args[0];
        String nomFichierMessageErreur = args[1];
        BufferedWriter out = ouvreFichierModeEcriture(nomFichierMessageErreur);

        Traitement.parserJson();
        boolean a = Traitement.siElementDossierExiste();
        boolean b = Traitement.siElementMoisExiste();
        boolean c = Traitement.siElementSoinExiste();
        boolean d = Traitement.siElementDateExiste();
        boolean e = Traitement.siElementMontantExiste();
        if (a == false || b == false || c == false || d == false || e == false) {
            objetJson = JSONErreur.enregistrer();
        } else {
            boolean f = Traitement.validerContrat();

            boolean g = Traitement.validerNumeroClient();

            boolean h = Traitement.validerMois();

            boolean i = Traitement.validerNumeroSoin();

            boolean j = Traitement.validerSigneDollar();

            if (f == false || g == false || h == false || i == false || j == false) {

                objetJson = JSONErreur.enregistrer();
                System.out.println ("Fichier enregistré");
            } else {
                Traitement.calcul();
                objetJson = JSONRemboursements.enregistrer();
                System.out.println ("Fichier enregistré");
            }

        }

        ecrire(objetJson, out);
    }

    public static BufferedWriter ouvreFichierModeEcriture(String nomFichierSortie) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter(nomFichierSortie));
        return out;
    }

    public static void ecrire(JSONObject order, BufferedWriter out) {
        try {

            out.write(order.toString());
            
            out.close();

        } catch (IOException e) {
        }
    }
}
