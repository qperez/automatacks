/**
 * Created by kiwhacks on 01/02/16.
 */
public class Transition implements Visitable {
    Etat source;
    Etat cible;
    Label etiquette;

    public Transition(Etat source, Label etiquette, Etat cible) {
        this.source = source;
        this.etiquette = etiquette;
        this.cible = cible;
    }

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

    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
