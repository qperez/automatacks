/**
 * Created by kiwhacks on 18/02/16.
 */
public class FabriqueVisiteur {
    public static final int TYPE_VISITEUR_1 = 1;
    public static final int TYPE_VISITEUR_2 = 2;

    public FabriqueVisiteur() {

    }

    public Visiteur getVisteur(int type) throws VisiteurInconnuException {
        Visiteur v = null;

        switch (type) {
            case TYPE_VISITEUR_1: v = ValiderAutomateVisiteur.getINSTANCE(); break;
            case TYPE_VISITEUR_2: v = SimulerAutomateVisiteur.getINSTANCE(); break;
            default: throw new VisiteurInconnuException();
        }
        return v;
    }
}
