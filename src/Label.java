/**
 * Created by kiwhacks on 01/02/16.
 */
public class Label {
    private String etiquette;

    // Constructeur
    public Label(String etiquette) {
        this.etiquette = etiquette;
    }

    // Retourne le contenu de l'étiquette
    public String getEtiquette() {
        return etiquette;
    }

    // Affecte le contenu de l'étiquette
    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    // Méthode accept du paradigme visiteur
    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
