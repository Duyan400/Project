package agile;

import net.sf.json.JSONObject;

public class JSONErreur {
    
     public static JSONObject enregistrer() throws Exception {
        JSONObject jsonErreur = new JSONObject();

        if (Validations.siElementDossierExiste() == false) {
            jsonErreur.put("message", "L'élément 'Dossier' est manquant.");
        } else if (Validations.siElementMoisExiste() == false) {
            jsonErreur.put("message", "L'élément 'mois' est manquant.");
        } else if (Validations.siElementSoinExiste() == false) {
            jsonErreur.put("message", "L'élément 'soin' est manquant à une des réclamations.");
        } else if (Validations.siElementDateExiste() == false) {
            jsonErreur.put("message", "L'élément 'date' est manquant à une des réclamations.");
        } else if (Validations.siElementMontantExiste() == false) {
            jsonErreur.put("message", "L'élément 'montant' est manquant à une des réclamations.");
        } else {                                                        // élément 'code' manquant à ajouter
            if (Validations.validerContrat() == false) {
                jsonErreur.put("message", "Le type du contrat est incorrect.");
            }
            if (Validations.validerNumeroClient() == false) {
                jsonErreur.put("message", "Le numéro du client est invalide.");
            }
            if (Validations.validerMois() == false) {
                jsonErreur.put("message", "Les dates entrées sont incorrectes.");
            }
            if (Validations.validerNumeroSoin() == false) {
                jsonErreur.put("message", "Un numero de soin est invalide.");
            }
            if (Validations.validerSyntaxeMontant() == false) {
                jsonErreur.put("message", "Il y a un problème dans la syntaxe du montant.");
            }
        }

        return jsonErreur;
    }
}
