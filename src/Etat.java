/** Created by Quentin **/

public class Etat implements Visitable {
    private String nom;
    private boolean estInitial;
    private boolean estFinal;
    private Automate sousAutomate;

    // Constructeur
    public Etat(String nom, boolean estInitial, boolean estFinal, Automate sousAutomate) {
        this.nom = nom;
        this.estInitial = estInitial;
        this.estFinal = estFinal;
        this.sousAutomate = sousAutomate;
    }

    // Retourne le nom de l'état
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Retourne true si l'état est initial, false sinon
    public boolean isEstInitial() {
        return estInitial;
    }

    // Affecte la valeur true ou false sur l'attribut estInitial
    public void setEstInitial(boolean estInitial) {
        this.estInitial = estInitial;
    }

    // Retourne true si l'état est final, false sinon
    public boolean isEstFinal() {
        return estFinal;
    }

    // Affecte la valeur true ou false sur l'attribut estFinal
    public void setEstFinal(boolean estFinal) {
        this.estFinal = estFinal;
    }

    // Retourne le sous automate de l'état
    public Automate getSousAutomate() {
        return sousAutomate;
    }

    // Affecte un sous automate à l'état
    public void setSousAutomate(Automate sousAutomate) {
        this.sousAutomate = sousAutomate;
    }

    // Méthode accept du paradigme visiteur
    public Object accept(Visiteur visiteur) {
        return visiteur.visit(this);
    }
}
