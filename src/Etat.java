/** Created by Quentin **/

public class Etat implements Visitable {
    private String nom;
    private boolean estInitial;
    private boolean estFinal;
    private Automate sousAutomate;

    public Etat(String nom, boolean estInitial, boolean estFinal, Automate sousAutomate) {
        this.nom = nom;
        this.estInitial = estInitial;
        this.estFinal = estFinal;
        this.sousAutomate = sousAutomate;

    }

    public void ajouterSousAutomate(Automate a) {
        setSousAutomate(a);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEstInitial() {
        return estInitial;
    }

    public void setEstInitial(boolean estInitial) {
        this.estInitial = estInitial;
    }

    public boolean isEstFinal() {
        return estFinal;
    }

    public void setEstFinal(boolean estFinal) {
        this.estFinal = estFinal;
    }

    public Automate getSousAutomate() {
        return sousAutomate;
    }

    public void setSousAutomate(Automate sousAutomate) {
        this.sousAutomate = sousAutomate;
    }

    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
