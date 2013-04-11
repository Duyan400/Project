package agile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Main {

    public static String entree = new String();
    public static String sortie = new String();

    public static void main(String[] args) throws Exception {

        entree = args[0];
        sortie = args[1];
        String fichier = new String();

        JSONObject objetJson = new JSONObject();
        BufferedWriter out = Main.ouvreFichierPourEcriture(sortie);

        boolean a = Validations.siElementDossierExiste();
        boolean b = Validations.siElementMoisExiste();
        boolean c = Validations.siElementSoinExiste();
        boolean d = Validations.siElementDateExiste();
        boolean e = Validations.siElementMontantExiste();
        boolean f = Validations.siElementCodeExiste();
        boolean g = Validations.validerUnSeulAdherant();
        boolean h = Validations.validerUnSeulConjoint();
        boolean i = Validations.validerContrat();
        boolean j = Validations.validerNumeroClient();
        boolean k = Validations.validerMois();
        boolean l = Validations.validerNumeroSoin();
        boolean m = Validations.validerSyntaxeMontant();
        boolean n = Validations.validerCode();

        if (a == false || b == false || c == false || d == false || e == false || f == false || g == false) {
            objetJson = JSONErreur.enregistrer();
            System.out.println("Fichier enregistré");
        }
        else if (h == false || i == false || j == false || k == false || l == false || m == false || n == false) {
            objetJson = JSONErreur.enregistrer();
            System.out.println("Fichier enregistré");
        } else {
            objetJson = JSONRemboursements.enregistrer();
            System.out.println("Fichier enregistré");
        }

        ecrire(objetJson, out);
    }

    public static BufferedWriter ouvreFichierPourEcriture(String sortie) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter(sortie));
        return out;
    }

    public static JSONObject parserJson(String fichierEntree) throws Exception {
        String jsonTxt = FileReader.loadFileIntoString(fichierEntree);
        JSONObject reclamations = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        return reclamations;
    }

    public static void ecrire(JSONObject order, BufferedWriter out) {
        try {

            out.write(order.toString());

            out.close();

        } catch (IOException e) {
        }
    }
}
