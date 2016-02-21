import java.util.ArrayList;

/**
 * Created by kiwhacks on 01/02/16.
 */
public class Automate {
    private ArrayList<Etat> listeEtats;
    private ArrayList<Transition> listeTransitions;
    private Etat etatCourant;

    public Automate() {

    }

    public Automate(ArrayList<Etat> listeEtats, ArrayList<Transition> listeTransitions, Etat etatCourant)
            throws AucunEtatInitialException, PlusieursEtatsInitiauxException {
        if (!etatCourant.isEstInitial()) {
            for (Etat e : listeEtats) {
                if (e.isEstInitial()) break;
            }
            throw new AucunEtatInitialException();
        } else {
            for (Etat e : listeEtats) {
                if (e!=etatCourant && e.isEstInitial()) throw new PlusieursEtatsInitiauxException();
            }
        }
        this.listeEtats = listeEtats;
        this.listeTransitions = listeTransitions;
        this.etatCourant = etatCourant;
    }

    public void ajouterEtat(Etat e)
            throws AjouterEtatException, AucunEtatInitialException, PlusieursEtatsInitiauxException {
        if (!e.isEstInitial()) {
            for (Etat etat : listeEtats) {
                if (e.isEstInitial()) break;
            }
            throw new AucunEtatInitialException();
        } else {
            for (Etat etat : listeEtats) {
                if (e.isEstInitial()) throw new PlusieursEtatsInitiauxException();
            }
        }
        if (!listeEtats.contains(e)) listeEtats.add(e);
        else throw new AjouterEtatException();
    }

    public void ajouterTransition(Transition t) throws AjouterTransitionException {
        if (!listeEtats.contains(t)) listeTransitions.add(t);
        else throw new AjouterTransitionException();
    }

    public ArrayList<Etat> getListeEtats() {
        return listeEtats;
    }

    public void setListeEtats(ArrayList<Etat> listeEtats) {
        this.listeEtats = listeEtats;
    }

    public ArrayList<Transition> getListeTransitions() {
        return listeTransitions;
    }

    public void setListeTransitions(ArrayList<Transition> listeTransitions) {
        this.listeTransitions = listeTransitions;
    }

    public Etat getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    public String toString() {

        String result = "Etat courant : " + this.etatCourant.getNom() + "\n";
        try {
            for (Etat etat : etatCourant.getSousAutomate().getListeEtats()) {
                result += " `-> etat_" + this.etatCourant.getNom() + ".sousEtat_" + etat.getNom() + "\n";
            }
        } catch (NullPointerException e) {
            result += "    `-> Aucun sous automate pour l'état courant\n";
        }

        return result;
    }

    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
