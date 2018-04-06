import view.UI.UIAlgorithmeGenetique;
import model.algorithme.AlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeGenetique;

public class Launcher {

	public static void main(String[] args) {
		try {
			ParametreAlgorithmeGenetique parametre = new ParametreAlgorithmeGenetique(args);
			AlgorithmeGenetique ag = new AlgorithmeGenetique(parametre);
			UIAlgorithmeGenetique ui = new UIAlgorithmeGenetique(ag, parametre);
			parametre.checkParametres();
			ag.run();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

}