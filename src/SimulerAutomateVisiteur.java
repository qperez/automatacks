import java.util.ArrayList;

/**
 * Created by kiwhacks on 16/02/16.
 */
public class SimulerAutomateVisiteur implements Visiteur {
    Label event;

    // Constructeur
    private SimulerAutomateVisiteur() {
    }

    // Singleton
    private static SimulerAutomateVisiteur INSTANCE = null;
    public static SimulerAutomateVisiteur getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new SimulerAutomateVisiteur();
        return INSTANCE;
    }

    // Réécriture des fonctions héritées
    @Override
    public Object visit(Etat etat) {
        return null;
    }

    // Retourne true si il y a une transition portant le nom donné partant de l'état courant
    @Override
    public Object visit(Automate automate) {
        Etat etatCourant = automate.getEtatCourant();
        ArrayList<Transition> transitions = automate.getListeTransitions();
        for (Transition T : transitions) {
            if (etatCourant == T.getSource()) {
                if (T.accept(this) == this.event.getEtiquette()) {
                    automate.setEtatCourant(T.getCible());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object visit(Label label) {
        return null;
    }

    // Retourne le contenu de l'étiquette
    @Override
    public Object visit(Transition transition) {
        return transition.getEtiquette().getEtiquette();
    }

    // Retourne le nom de l'évênement
    public Label getEvent() {
        return event;
    }

    // Affecte le nom de l'évênement
    public void setEvent(Label event) {
        this.event = event;
    }

}
