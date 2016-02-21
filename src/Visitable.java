/**
 * Created by kiwhacks on 07/02/16.
 */
public interface Visitable {
    // Interface des objets visitables
    Object accept(Visiteur visiteur);
}
