package view.GUI.controller.parametre;

import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeGenetique;
import view.GUI.block.parametre.ParametreAlgorithmeGenetiqueView;
import view.GUI.block.parametre.ParametreAlgorithmeRecuitSimuleView;
import view.GUI.block.parametre.ParametreView;

public class ParametreAlgorithmeGenetiqueController extends ParametreController {
	public ParametreAlgorithmeGenetiqueController(ParametreView v, Parametre p) {
		super(v,p);
	}
	
	public void sync() {
		super.sync();
		ParametreAlgorithmeGenetiqueView view = ((ParametreAlgorithmeGenetiqueView) this.view);
		if(!view.getTextTfNombreGenerations().isEmpty())
		((ParametreAlgorithmeGenetique) parametre).setNombreGenerations(Integer.valueOf(view.getTextTfNombreGenerations()));
		if(!view.getTextTfTaillePopulation().isEmpty())
		((ParametreAlgorithmeGenetique) parametre).setTaillePopulation(Integer.valueOf(view.getTextTfTaillePopulation()));
		if(!view.getTextTfTaillePopulationEnfant().isEmpty())
		((ParametreAlgorithmeGenetique) parametre).setTaillePopulationEnfant(Integer.valueOf(view.getTextTfTaillePopulationEnfant()));
		if(!view.getTextTfPourcentageMutation().isEmpty())
		((ParametreAlgorithmeGenetique) parametre).setPourcentageMutation(Float.valueOf(view.getTextTfPourcentageMutation()));
	}
	
	public void update() {
		super.update();
		
		((ParametreAlgorithmeGenetiqueView) view).setTextTfNombreGenerations(""+((ParametreAlgorithmeGenetique) parametre).getNombreGenerations());
		((ParametreAlgorithmeGenetiqueView) view).setTextTfTaillePopulation(""+((ParametreAlgorithmeGenetique) parametre).getTaillePopulation());
		((ParametreAlgorithmeGenetiqueView) view).setTextTfTaillePopulationEnfant(""+((ParametreAlgorithmeGenetique) parametre).getTaillePopulationEnfant());
		((ParametreAlgorithmeGenetiqueView) view).setTextTfPourcentageMutation(""+((ParametreAlgorithmeGenetique) parametre).getPourcentageMutation());
	}
}
