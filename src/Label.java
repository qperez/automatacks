/**
 * Created by kiwhacks on 01/02/16.
 */
public class Label {
    private String etiquette;

    public Label(String etiquette) {
        this.etiquette = etiquette;
    }

    public String getEtiquette() {
        return etiquette;
    }

    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    public void accept(Visiteur visiteur) {
        visiteur.visit(this);
    }
}
