/**
 * Created by kiwhacks on 07/02/16.
 */
public interface Visiteur {
    void visit(Etat etat);
    void visit(Transition transition);
    void visit(Automate automate);
    void visit(Label label);
}
