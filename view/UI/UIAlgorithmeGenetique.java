package view.UI;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import model.algorithme.AlgorithmeGenetique;
import model.algorithme.etat.IndividuAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeGenetique;

public class UIAlgorithmeGenetique implements Observer{
	private AlgorithmeGenetique algorithme;
	private ParametreAlgorithmeGenetique parametre;
	public UIAlgorithmeGenetique(AlgorithmeGenetique ag, ParametreAlgorithmeGenetique p) {
		algorithme = ag;
		parametre = p;
		ag.addObserver(this);
	}

	private String afficherPopulation() {
		AlgorithmeGenetique algorithme = (AlgorithmeGenetique)this.algorithme;
		IndividuAlgorithmeGenetique meilleur = algorithme.getPopulation()[0];
		return algorithme.getGeneration()+">> Score: "+meilleur.getScore()+", génome: "+Arrays.toString(meilleur.getGenome())+"\n";
	}
	private String afficherResultat() {
		AlgorithmeGenetique algorithme = (AlgorithmeGenetique)this.algorithme;
		ParametreAlgorithmeGenetique parametre = (ParametreAlgorithmeGenetique) algorithme.getParametre();
		IndividuAlgorithmeGenetique meilleur = algorithme.getPopulation()[0];
		StringBuilder sb = new StringBuilder("\n-- Résultat --\n");
		sb.append("Algorithme: Algorithme génétique\n\n");
		sb.append("Temps d'exécution: ");
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
		sb.append("Nombre générations: ");
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
		sb.append("Génome: ");
		sb.append(Arrays.toString(meilleur.getGenome()));
		sb.append("\n\n");
		return sb.toString();
	}
	@Override
	public void update(Observable o, Object arg1) {
		System.out.println(afficherPopulation());
		if(((AlgorithmeGenetique)algorithme).getGeneration() == ((ParametreAlgorithmeGenetique)algorithme.getParametre()).getNombreGenerations()-1) {
			System.out.println(afficherResultat());
		}
	}
}
