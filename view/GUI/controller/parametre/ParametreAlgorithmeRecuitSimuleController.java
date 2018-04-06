package view.GUI.controller.parametre;

import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeRecuitSimule;
import view.GUI.block.parametre.ParametreAlgorithmeGenetiqueView;
import view.GUI.block.parametre.ParametreAlgorithmeRecuitSimuleView;
import view.GUI.block.parametre.ParametreView;

public class ParametreAlgorithmeRecuitSimuleController extends ParametreController {
	public ParametreAlgorithmeRecuitSimuleController(ParametreView v, Parametre p) {
		super(v, p);
	}
	
	public void sync() {
		super.sync();
		ParametreAlgorithmeRecuitSimuleView view = ((ParametreAlgorithmeRecuitSimuleView) this.view);
		if(!view.getTextTfTemperatureInitiale().isEmpty())
		((ParametreAlgorithmeRecuitSimule) parametre).setTemperatureInitiale(Float.valueOf(view.getTextTfTemperatureInitiale()));
		if(!view.getTextTfTemperatureFinale().isEmpty())
		((ParametreAlgorithmeRecuitSimule) parametre).setTemperatureFinale(Float.valueOf(view.getTextTfTemperatureFinale()));
		if(!view.getTextTfVariationTemperature().isEmpty())
		((ParametreAlgorithmeRecuitSimule) parametre).setVariationTemperature(Float.valueOf(view.getTextTfVariationTemperature()));
	}
	
	public void update() {
		super.update();
		
		((ParametreAlgorithmeRecuitSimuleView) view).setTextTfTemperatureInitiale(""+((ParametreAlgorithmeRecuitSimule) parametre).getTemperatureInitiale());
		((ParametreAlgorithmeRecuitSimuleView) view).setTextTfTemperatureFinale(""+((ParametreAlgorithmeRecuitSimule) parametre).getTemperatureFinale());
		((ParametreAlgorithmeRecuitSimuleView) view).setTextTfVariationTemperature(""+((ParametreAlgorithmeRecuitSimule) parametre).getVariationTemperature());
	}
}
