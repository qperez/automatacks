/**
 * Created by kiwhacks on 21/02/16.
 */
public class AucuneTransitionException extends Exception{
    public AucuneTransitionException(Label l) {
        System.out.println("La transition " + l.getEtiquette() + " n'existe pas depuis le noeud courant");
    }
}
