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

    // Constructeur
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

    // Méthode pour ajouter un état
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

    // Méthode pour ajouter une transition
    public void ajouterTransition(Transition t) throws AjouterTransitionException {
        if (!listeEtats.contains(t)) listeTransitions.add(t);
        else throw new AjouterTransitionException();
    }

    // Retourne la liste des états de l'automate
    public ArrayList<Etat> getListeEtats() {
        return listeEtats;
    }

    // Affecter la liste des états de l'automate
    public void setListeEtats(ArrayList<Etat> listeEtats) {
        this.listeEtats = listeEtats;
    }

    // Retourne la liste des transitions de l'automate
    public ArrayList<Transition> getListeTransitions() {
        return listeTransitions;
    }

    // Affecter la liste des transitions de l'automate
    public void setListeTransitions(ArrayList<Transition> listeTransitions) {
        this.listeTransitions = listeTransitions;
    }

    // Retourne l'état courant de l'automate
    public Etat getEtatCourant() {
        return etatCourant;
    }

    // Affecte l'état courant de l'automate
    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    // Méthode toString retournant le nom de l'état courant ainsi que les états de son sous automate s'il existe
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

    // Méthode accept du paradigm visiteur
    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
