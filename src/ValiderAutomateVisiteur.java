import java.util.ArrayList;
import java.util.logging.ErrorManager;

/**
 * Created by kiwhacks on 07/02/16.
 */
public class ValiderAutomateVisiteur implements Visiteur {
    // Constructeur
    private ValiderAutomateVisiteur(){}

    // Singleton
    private static ValiderAutomateVisiteur INSTANCE = null;
    public static ValiderAutomateVisiteur getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new ValiderAutomateVisiteur();
        return INSTANCE;
    }

    public ArrayList<Error> listError = new ArrayList<>();

    //Réécriture des méthodes héritées

    // Retourne le nom de l'état
    public Object visit(Etat etat) {
        return etat.getNom();
    }

    // Retourne le contenu de l'étiquette
    public Object visit(Transition transition) {
        return transition.getEtiquette();
    }

    // Méthode pour traiter les contraintes de l'automate
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

    // Retourne true si l'automate est valide, false sinon
    public Object visit(Automate automate) {
        for (Etat e : automate.getListeEtats()) {
            if (!plusieursEtatsAvecMemeNom(automate, e)) listError.add(new Error("Il y a déjà un etat avec ce nom" + e.getNom()));
            if (!plusieursTransitionsAvecMemeLabel(automate)) listError.add(new Error("Il y a plusieurs transitions avec le même automate"));

            boolean estInitial = false;
            //Là y'a souçis je pense la variable "estInitial" vaut false donc on passe pas dans la conditionnelle ;-)
            if (estInitial)
                    if (e.isEstInitial()) return false;
            else
                    if (e.isEstInitial()) estInitial = true;

            if (!estInitial) {
                boolean aTransition = false;
                for (Transition t : automate.getListeTransitions()) {
                    if (t.getSource() == e) aTransition = true; break;
                }
                if (!aTransition) listError.add(new Error("Il n'y a pas de transition"));;
            }

            if (nombreTransitionsSortanteEtat(automate, e) == 0 && !e.isEstFinal())
                listError.add(new Error("L'état non-initial" + e.getNom() + "doit être cible d'au moins une transition"));
        }
        return true;
    }

    public Object visit(Label label) {
        return true;
    }
}
