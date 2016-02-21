import java.util.ArrayList;

/**
 * Created by kiwhacks on 01/02/16.
 */
public class Application {
    public static void main(String[] args) {
        try {
            Etat e = new Etat("1", true, false, null);

            Etat f = new Etat("2", false, false, null);
            Etat f_1 = new Etat("21", true, false, null);
            Etat f_2 = new Etat("22", false, true, null);
            ArrayList<Etat> listeSousEtats = new ArrayList<Etat>();
            listeSousEtats.add(f_1);
            listeSousEtats.add(f_2);
            Transition t_1 = new Transition(f_1, new Label("a"), f_2);
            ArrayList<Transition> listeSousTransitions = new ArrayList<Transition>();
            listeSousTransitions.add(t_1);
            Automate sousAutomateF = new Automate(listeSousEtats, listeSousTransitions, f_1);
            f.ajouterSousAutomate(sousAutomateF);

            Etat g = new Etat("3", false, true, null);
            ArrayList<Etat> listeEtats = new ArrayList<Etat>();
            listeEtats.add(e);
            listeEtats.add(f);
            listeEtats.add(g);

            Transition t = new Transition(e, new Label("b"), e);
            Transition u = new Transition(e, new Label("a"), f);
            Transition v = new Transition(f, new Label("a"), f);
            Transition w = new Transition(f, new Label("b"), g);
            Transition x = new Transition(g, new Label("b"), e);
            ArrayList<Transition> listeTransitions = new ArrayList<Transition>();
            listeTransitions.add(t);
            listeTransitions.add(u);
            listeTransitions.add(v);
            listeTransitions.add(w);
            listeTransitions.add(x);

            FabriqueVisiteur fabriqueVisiteur = new FabriqueVisiteur();
            try {
                ValiderAutomateVisiteur visiteurValidation = (ValiderAutomateVisiteur) fabriqueVisiteur.getVisteur(FabriqueVisiteur.TYPE_VISITEUR_1);
            } catch (VisiteurInconnuException ex) {

            }

            try {
                SimulerAutomateVisiteur visiteurSimulation = (SimulerAutomateVisiteur) fabriqueVisiteur.getVisteur(FabriqueVisiteur.TYPE_VISITEUR_2);
                try {
                    Automate a = new Automate(listeEtats, listeTransitions, e);

                    visiteurSimulation.setEvent(new Label("b"));
                    boolean result = (boolean) visiteurSimulation.visit(a);
                    if (result) System.out.println(a.toString());
                    else new AucuneTransitionException(visiteurSimulation.getEvent());

                    visiteurSimulation.setEvent(new Label("a"));
                    result = (boolean) visiteurSimulation.visit(a);
                    if (result) System.out.println(a.toString());
                    else new AucuneTransitionException(visiteurSimulation.getEvent());

                    visiteurSimulation.setEvent(new Label("a"));
                    result = (boolean) visiteurSimulation.visit(a);
                    if (result) System.out.println(a.toString());
                    else new AucuneTransitionException(visiteurSimulation.getEvent());

                    visiteurSimulation.setEvent(new Label("b"));
                    result = (boolean) visiteurSimulation.visit(a);
                    if (result) System.out.println(a.toString());
                    else new AucuneTransitionException(visiteurSimulation.getEvent());

                    visiteurSimulation.setEvent(new Label("a"));
                    result = (boolean) visiteurSimulation.visit(a);
                    if (result) System.out.println(a.toString());
                    else new AucuneTransitionException(visiteurSimulation.getEvent());

                } catch (AucunEtatInitialException ex) {
                    System.out.println(ex);
                } catch (PlusieursEtatsInitiauxException ex) {
                    System.out.println(ex);
                }

            } catch (VisiteurInconnuException ex) {
                System.out.println(ex);
            }
        } catch (AucunEtatInitialException e) {
            System.out.println(e);
        } catch (PlusieursEtatsInitiauxException e) {
            System.out.println(e);
        }
    }
}
