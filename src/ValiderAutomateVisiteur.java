/**
 * Created by kiwhacks on 07/02/16.
 */
public class ValiderAutomateVisiteur implements Visiteur {
    public Object visit(Etat etat) {
        return etat.getNom();
    }

    public Object visit(Transition transition) {
        return transition.getEtiquette();
    }

    public boolean plusieursEtatsAvecMemeNom(Automate a, Etat e) {
        for (Etat ebis : a.getListeEtats()) {
            if (!e.equals(ebis) && e.accept(this) == ebis.accept(this)) return false;
        }
        return true;
    }

    public boolean plusieursTransitionsAvecMemeLabel(Automate a) {
        for (Transition t1 : a.getListeTransitions()) {
            for (Transition t2 : a.getListeTransitions()) {
                if (!t1.equals(t2) && t1.accept(this) == t2.accept(this)) return false;
            }
        }
        return true;
    }

    public int nombreTransitionsSortanteEtat(Automate a, Etat e) {
        int nbTransitions = 0;
        for (Transition t : a.getListeTransitions()) {
            if (t.getSource() == e) nbTransitions++;
        }
        return nbTransitions;
    }

    public Object visit(Automate automate) {
        for (Etat e : automate.getListeEtats()) {
            if (!plusieursEtatsAvecMemeNom(automate, e)) return false;
            if (!plusieursTransitionsAvecMemeLabel(automate)) return false;

            boolean estInitial = false;
            if (estInitial)
                    if (e.isEstInitial()) return false;
            else
                    if (e.isEstInitial()) estInitial = true;

            if (!estInitial) {
                boolean aTransition = false;
                for (Transition t : automate.getListeTransitions()) {
                    if (t.getSource() == e) aTransition = true; break;
                }
                if (!aTransition) return false;
            }

            if (nombreTransitionsSortanteEtat(automate, e) == 0 && !e.isEstFinal()) return false;
        }
        return true;
    }

    public Object visit(Label label) {
        return true;
    }
}
