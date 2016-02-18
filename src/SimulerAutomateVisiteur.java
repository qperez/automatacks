import java.util.ArrayList;

/**
 * Created by kiwhacks on 16/02/16.
 */
public class SimulerAutomateVisiteur implements Visiteur {
    Label event;

    private SimulerAutomateVisiteur() {
    }

    private static SimulerAutomateVisiteur INSTANCE = null;

    public static SimulerAutomateVisiteur getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new SimulerAutomateVisiteur();
        return INSTANCE;
    }

    @Override
    public Object visit(Etat etat) {
        return null;
    }

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

    @Override
    public Object visit(Transition transition) {
        return transition.getEtiquette().getEtiquette();
    }

    public Label getEvent() {
        return event;
    }

    public void setEvent(Label event) {
        this.event = event;
    }

}
