package agile;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class LesGetters {

    public static String getDossier() throws Exception {
        String dossier = Main.parserJson(Main.entree).getString("dossier");
        return dossier;
    }

    public static String getNumeroClient() throws Exception {
        String dossier = getDossier();
        String numeroClient = dossier.substring(1);
        return numeroClient;
    }

    public static char getContrat() throws Exception {
        String dossier = getDossier();
        char TypeContrat = dossier.charAt(0);
        return TypeContrat;
    }

    public static String getMois() throws Exception {
        String mois = Main.parserJson(Main.entree).getString("mois");
        return mois;
    }

    public static List<String> getSoins() throws JSONException, Exception {
        List<String> liste = new ArrayList();

        try {
            JSONArray lesReclamations = Main.parserJson(Main.entree).getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject uneReclamation = lesReclamations.getJSONObject(i);
                String leSoin = uneReclamation.getString("soin");
                liste.add(leSoin);
            }
        } catch (JSONException e) {
        }
        return liste;
    }

    public static List<String> getCodes() throws Exception {
        List<String> liste = new ArrayList();

        try {
            JSONArray lesReclamations = Main.parserJson(Main.entree).getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject code = lesReclamations.getJSONObject(i);
                String leCode = code.getString("code");
                liste.add(leCode);
            }
        } catch (JSONException e) {
        }
        return liste;
    }

    public static List<String> getDates() throws Exception {
        List<String> liste = new ArrayList();

        try {
            JSONArray lesReclamations = Main.parserJson(Main.entree).getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject date = lesReclamations.getJSONObject(i);
                String laDate = date.getString("date");
                liste.add(laDate);
            }
        } catch (JSONException e) {
        }
        return liste;
    }

    public static List<String> getMontants() throws Exception {
        List<String> liste = new ArrayList();

        try {
            JSONArray lesReclamations = Main.parserJson(Main.entree).getJSONArray("reclamations");
            for (int i = 0; i < lesReclamations.size(); i++) {
                JSONObject montant = lesReclamations.getJSONObject(i);
                String leMontant = montant.getString("montant");
                liste.add(leMontant);
            }
        } catch (JSONException e) {
        }
        return liste;
    }
}