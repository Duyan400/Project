/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

import net.sf.json.JSONObject;


public class JSONErreur {

    public static JSONObject enregistrer() throws Exception {

        JSONObject json = new JSONObject();

        if (Traitement.siElementDossierExiste() == false) {
            json.put("message", "L'élément 'Dossier' est manquant.");
        } else if (Traitement.siElementMoisExiste() == false) {
            json.put("message", "L'élément 'mois' est manquant.");
        } else if (Traitement.siElementSoinExiste() == false) {
            json.put("message", "L'élément 'soin' est manquant à une des réclamations.");
        } else if (Traitement.siElementDateExiste() == false) {
            json.put("message", "L'élément 'date' est manquant à une des réclamations.");
        } else if (Traitement.siElementMontantExiste() == false) {
            json.put("message", "L'élément 'montant' est manquant à une des réclamations.");
        } else {
            if (Traitement.validerContrat() == false) {
                json.put("message", "Le Type du contrat est incorrect.");
            }
            if (Traitement.validerNumeroClient() == false) {
                json.put("message", "Le numéro du client est invalide.");

            }
            if (Traitement.validerMois() == false) {
                json.put("message", "Les dates entrées sont incorrectes.");
            }
            if (Traitement.validerNumeroSoin() == false) {
                json.put("message", "Un numero de soin est invalide.");
            }
            if (Traitement.validerSigneDollar() == false) {
                json.put("message", "Le signe du dollar est manquant.");
            }
        }

        return json;
    }
}

