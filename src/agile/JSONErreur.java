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
        } else if (Validations.siElementCodeExiste() == false) {
            jsonErreur.put("message", "L'élément 'code' est manquant à une des réclamations.");
        } else if (Validations.siElementDateExiste() == false) {
            jsonErreur.put("message", "L'élément 'date' est manquant à une des réclamations.");
        } else if (Validations.siElementMontantExiste() == false) {
            jsonErreur.put("message", "L'élément 'montant' est manquant à une des réclamations.");
        } else if (Validations.validerContrat() == false) {
            jsonErreur.put("message", "Le type du contrat est incorrect.");
        } else if (Validations.validerNumeroClient() == false) {
            jsonErreur.put("message", "Le numéro du client est invalide.");
        } else if (Validations.validerCode() == false) {
            jsonErreur.put("message", "Le code d'une des réclamations est incorrect.");
        } else if (Validations.validerMois() == false) {
            jsonErreur.put("message", "Les dates entrées sont incorrectes.");
        } else if (Validations.validerNumeroSoin() == false) {
            jsonErreur.put("message", "Un numero de soin est incorrect.");
        } else if (Validations.validerSyntaxeMontant() == false) {
            jsonErreur.put("message", "Il y a un problème dans la syntaxe du montant.");
        } else if (Validations.validerUnSeulAdherant() == false) {
            jsonErreur.put("message", "Un seul adhérant est permis par fiche de reclamations.");
        } else if (Validations.validerUnSeulConjoint() == false) {
            jsonErreur.put("message", "Un seul conjoint est permis par fiche de reclamations.");
        }

        return jsonErreur;
    }
}