import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.util.ArrayList;

/**
 * Created by kiwhacks on 01/02/16.
 */
public class Application {
    public static void main(String[] args) {
        ValiderAutomateVisiteur vav = new ValiderAutomateVisiteur();

        Etat e = new Etat("1", true, false, null);
        Etat f = new Etat("2", false, true, null);
        ArrayList<Etat> listeEtats = new ArrayList<Etat>();
        listeEtats.add(e); listeEtats.add(f);

        Transition t = new Transition(e, new Label("a"), f);
        ArrayList<Transition> listeTransitions = new ArrayList<Transition>();
        listeTransitions.add(t);

        SimulerAutomateVisiteur s = new SimulerAutomateVisiteur(new Label("a"));

        try {
            Automate a = new Automate(listeEtats, listeTransitions, e);
            boolean result = (boolean)s.visit(a);
            if (result) {
                System.out.println("YEP");
            } else System.out.println("NOPE");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
