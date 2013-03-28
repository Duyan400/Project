/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONRemboursements {

    public static JSONObject enregistrer() throws Exception {


        String totalRemb = "" + Traitement.totalRemboursements();
        String dossierClient = Traitement.getDossier();
        String numeroMois = Traitement.getMois();
        double[] tab = Traitement.calcul();

        JSONObject objetJson = new JSONObject();
        objetJson.put("dossier", dossierClient);

        objetJson.put("mois", numeroMois);

        JSONArray remboursements = new JSONArray();
        JSONObject objetJson2 = new JSONObject();

        for (int i = 0; i < tab.length; i++) {
            objetJson2.put("soin", Traitement.getSoins().get(i));
            objetJson2.put("date", Traitement.getDates().get(i));
            objetJson2.put("montant", Traitement.calcul()[i] + "$");
            remboursements.add(objetJson2);
            objetJson.put("remboursements", remboursements);
        }
        
        objetJson.put("total", Traitement.totalRemboursements() + "$");

        return objetJson;
    }
}
