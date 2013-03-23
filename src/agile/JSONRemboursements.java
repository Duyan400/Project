/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import net.sf.json.JSONObject;


public class JSONRemboursements  {
    
    
    
    public static JSONObject enregistrer() throws Exception {
        
       
    String totalRemb = "" + Traitement.totalRemboursements();
    String dossierClient = Traitement.getDossier();
    String numeroMois = Traitement.getMois();
    double[] tab = Traitement.calcul();
    
    JSONObject objetJson = new JSONObject();
    objetJson.put("dossier", dossierClient);
    
    objetJson.put("mois", numeroMois);
    
   
    
      return objetJson;  
    }
    
    
    
   
}

