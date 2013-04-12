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
            char premierCarac = leCode.charAt(0);

            switch (premierCarac) {
                case 'A':
                    Adherant adherant = new Adherant();
                    String resultat1 = adherant.calculMaximum(leSoin, leMontant);
                    tab[i] = resultat1;
                    break;
                //---------------------------------------------------------------   
                case 'C':
                    Conjoint conjoint = new Conjoint();
                    String resultat2 = conjoint.calculMaximum(leSoin, leMontant);
                    tab[i] = resultat2;
                    break;
                //----------------------------------------------------------------
                case 'E':
                    if (!codesEnfants.contains(leCode)) {
                        codesEnfants.add(leCode);
                        Enfant enfant = new Enfant();
                        String resultat3 = enfant.calculMaximum(leSoin, leMontant);
                        tab[i] = resultat3;
                        lesEnfants.add(enfant);
                        break;
                    }

                    if (codesEnfants.contains(leCode)) {
                        for (int k = 0; k < lesEnfants.size(); k++) {
                            if (lesEnfants.get(k).getCode().equals(leCode)) {
                                compteur = k;
                            }
                        }

                        String resultat4 = lesEnfants.get(compteur).calculMaximum(leSoin, leMontant);

                        tab[i] = resultat4;

                    }
            }

        }


    }
}
