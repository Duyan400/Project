package agile;

public class MaximumMensuel {

    public static void maxMensuel(String[] tab) throws Exception {

        for (int i = 0; i < tab.length; i++) {
            String leMontant = tab[i];
            String leSoin = LesGetters.getSoins().get(i);
            String leCode = LesGetters.getCodes().get(i);
            if (leCode.charAt(0) == 'A') {
                Adherant adherant = new Adherant();
                String resultat = adherant.calculMaximum(leSoin, leMontant);
                tab[i] = resultat;
            } else if (leCode.charAt(0) == 'C') {
                Conjoint conjoint = new Conjoint();
                String resultat = conjoint.calculMaximum(leSoin, leMontant);
                tab[i] = resultat;
            }
        }
    }
}
