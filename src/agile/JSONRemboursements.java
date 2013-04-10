package agile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONRemboursements {

    public static JSONObject enregistrer() throws Exception {

        
        String dossierClient = LesGetters.getDossier();
        String numeroMois = LesGetters.getMois();
        String[] tab = CalculRemboursements.calculerRemboursements();

        JSONObject objetJson = new JSONObject();
        objetJson.put("dossier", dossierClient);

        objetJson.put("mois", numeroMois);

        JSONArray remboursements = new JSONArray();
        JSONObject objetJson2 = new JSONObject();

        for (int i = 0; i < tab.length; i++) {
            objetJson2.put("soin", LesGetters.getSoins().get(i));
            objetJson2.put("code", LesGetters.getCodes().get(i));
            objetJson2.put("date", LesGetters.getDates().get(i));
            objetJson2.put("montant", tab[i]);
            remboursements.add(objetJson2);
            objetJson.put("remboursements", remboursements);
        }

        objetJson.put("total", CalculTotalRemboursements.totalRemboursements());

        return objetJson;
    }
}
