/**
 * Created by kiwhacks on 01/02/16.
 */
public class Transition implements Visitable {
    Etat source;
    Etat cible;
    Label etiquette;

    // Constructeur
    public Transition(Etat source, Label etiquette, Etat cible) {
        this.source = source;
        this.etiquette = etiquette;
        this.cible = cible;
    }

    // Getters and setters
    public Etat getSource() {
        return source;
    }

    public void setSource(Etat source) {
        this.source = source;
    }

    public Etat getCible() {
        return cible;
    }

    public void setCible(Etat cible) {
        this.cible = cible;
    }

    public Label getEtiquette() {
        return etiquette;
    }

    public void setEtiquette(Label etiquette) {
        this.etiquette = etiquette;
    }

    // Méthode accept du paradigme visiteur
    public Object accept(Visiteur visiteur) {
        return visiteur.visit(this);
    }
}
