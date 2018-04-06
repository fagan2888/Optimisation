package view.GUI.controller.console;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import model.algorithme.Algorithme;
import model.algorithme.etat.IndividuAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeGenetique;
import view.GUI.block.ConsoleView;
import model.algorithme.AlgorithmeGenetique;

public class ConsoleAlgorithmeGenetiqueController extends ConsoleController implements Observer{

	public ConsoleAlgorithmeGenetiqueController(ConsoleView cv, Algorithme a) {
		super(cv, a);
	}

	private String afficherPopulation() {
		AlgorithmeGenetique algorithme = (AlgorithmeGenetique)this.algorithme;
		IndividuAlgorithmeGenetique meilleur = algorithme.getPopulation()[0];
		return algorithme.getGeneration()+">> Score: "+meilleur.getScore()+", g�nome: "+Arrays.toString(meilleur.getGenome())+"\n";
	}
	private String afficherResultat() {
		AlgorithmeGenetique algorithme = (AlgorithmeGenetique)this.algorithme;
		ParametreAlgorithmeGenetique parametre = (ParametreAlgorithmeGenetique) algorithme.getParametre();
		IndividuAlgorithmeGenetique meilleur = algorithme.getPopulation()[0];
		StringBuilder sb = new StringBuilder("\n-- R�sultat --\n");
		sb.append("Algorithme: Algorithme g�n�tique\n\n");
		sb.append("Temps d'ex�cution: ");
		sb.append(algorithme.getTempsExecutionFormatted(algorithme.getTempsExecution( System.currentTimeMillis())));
		
		sb.append("\n");
		sb.append("Seed: ");
		sb.append(parametre.getSeed());
		sb.append("\n");
		sb.append("Nombre processeurs: ");
		sb.append(parametre.getNombreProcesseurs());
		sb.append("\n");
		sb.append("Taille de la population: ");
		sb.append(parametre.getTaillePopulation());
		sb.append("\n");
		sb.append("Taille de la population enfant: ");
		sb.append(parametre.getTaillePopulationEnfant());
		sb.append("\n");
		sb.append("Nombre g�n�rations: ");
		sb.append(parametre.getNombreGenerations());
		sb.append("\n");
		sb.append("Pourcentage de mutation: ");
		sb.append(parametre.getPourcentageMutation());
		sb.append("\n");
		sb.append("\n");
		StringBuilder taches = new StringBuilder("Taches:");
		StringBuilder poids = new StringBuilder("Poids:");
		for(int i =0; i< parametre.getNombreTaches(); i++) {
			taches.append("\tt"+i);
			poids.append("\t"+parametre.getPoidsTache(i));
		}
		sb.append(taches.toString());
		sb.append("\n");
		sb.append(poids.toString());
		sb.append("\n");
		sb.append("Score: ");
		sb.append(meilleur.getScore());
		sb.append("\n");
		sb.append("G�nome: ");
		sb.append(Arrays.toString(meilleur.getGenome()));
		sb.append("\n\n");
		return sb.toString();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		consoleView.write(afficherPopulation());
		if(((AlgorithmeGenetique)algorithme).getGeneration() == ((ParametreAlgorithmeGenetique)algorithme.getParametre()).getNombreGenerations()-1) {
			consoleView.write(afficherResultat());
		}
	}
}
