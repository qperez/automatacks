/**
 * Created by kiwhacks on 07/02/16.
 */
public interface Visiteur {
    Object visit(Etat etat);
    Object visit(Transition transition);
    Object visit(Automate automate);
    Object visit(Label label);
}
