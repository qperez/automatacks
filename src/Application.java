import java.util.ArrayList;

/**
 * Created by kiwhacks on 01/02/16.
 */
public class Application {
    public static void main(String[] args) {
        FabriqueVisiteur fabriqueVisiteur = new FabriqueVisiteur();
        try {
            ValiderAutomateVisiteur visiteurValidation = (ValiderAutomateVisiteur) fabriqueVisiteur.getVisteur(FabriqueVisiteur.TYPE_VISITEUR_1);
        } catch (VisiteurInconnuException ex) {

        }

        Etat e = new Etat("1", true, false, null);
        Etat f = new Etat("2", false, true, null);
        ArrayList<Etat> listeEtats = new ArrayList<Etat>();
        listeEtats.add(e); listeEtats.add(f);

        Transition t = new Transition(e, new Label("a"), f);
        ArrayList<Transition> listeTransitions = new ArrayList<Transition>();
        listeTransitions.add(t);

        try {
            SimulerAutomateVisiteur visiteurSimulation = (SimulerAutomateVisiteur)fabriqueVisiteur.getVisteur(FabriqueVisiteur.TYPE_VISITEUR_2);

            visiteurSimulation.setEvent(new Label("a"));

            try {
                Automate a = new Automate(listeEtats, listeTransitions, e);
                boolean result = (boolean)visiteurSimulation.visit(a);
                if (result) {
                    System.out.println("YEP");
                } else System.out.println("NOPE");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (VisiteurInconnuException ex) {

        }
    }
}
