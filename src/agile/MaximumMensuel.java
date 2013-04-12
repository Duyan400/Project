package agile;

import java.util.ArrayList;

public class MaximumMensuel {

    public static void maxMensuel(String[] tab) throws Exception {

        ArrayList<String> codesEnfants = new ArrayList();
        ArrayList<Enfant> lesEnfants = new ArrayList();
        int compteur = 0;

        for (int i = 0; i < tab.length; i++) {
            String leMontant = tab[i];
            String leSoin = LesGetters.getSoins().get(i);
            String leCode = LesGetters.getCodes().get(i);
            if (leCode.charAt(0) == 'A') {
                Adherant adherant = new Adherant();
                String resultat = adherant.calculMaximum(leSoin, leMontant);
                tab[i] = resultat;
            }
            if (leCode.charAt(0) == 'C') {
                Conjoint conjoint = new Conjoint();
                String resultat = conjoint.calculMaximum(leSoin, leMontant);
                tab[i] = resultat;
            }
            if (leCode.charAt(0) == 'E') {
                if (!codesEnfants.contains(leCode)) {
                    codesEnfants.add(leCode);
                    Enfant enfant = new Enfant();
                    enfant.setCode(leCode);
                    lesEnfants.add(enfant);
                    String resultat = enfant.calculMaximum(leSoin, leMontant);
                    tab[i] = resultat;

                }
                if (codesEnfants.contains(leCode)) {
                    for (int j = 0; j < lesEnfants.size(); j++) {
                        if (lesEnfants.get(j).getCode().equals(leCode)) {
                            compteur = j;
                        }
                    }
                    String resultat = lesEnfants.get(compteur).calculMaximum(leSoin, leMontant);
                    tab[i] = resultat;
                }
            }
        }
    }
}
