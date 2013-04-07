package agile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Main {

    public static String entree = new String();
    public static String sortie = new String();

    public static void main(String[] args) throws Exception {
        
        entree = args[0];
        sortie = args[1];

        

    }

    //------------------------------------------------------------------------------  
    public static BufferedWriter ouvreFichierPourEcriture(String sortie) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter(sortie));
        return out;
    }
    //------------------------------------------------------------------------------ 

    public static JSONObject parserJson(String fichierEntree) throws Exception {
        String jsonTxt = FileReader.loadFileIntoString(fichierEntree);
        JSONObject reclamations = (JSONObject) JSONSerializer.toJSON(jsonTxt);
        return reclamations;
    }
    //------------------------------------------------------------------------------
}
