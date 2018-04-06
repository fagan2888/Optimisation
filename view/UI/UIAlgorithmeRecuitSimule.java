package view.UI;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import model.algorithme.AlgorithmeGenetique;
import model.algorithme.AlgorithmeRecuitSimule;
import model.algorithme.etat.EtatAlgorithmeRecuitSimule;
import model.algorithme.etat.IndividuAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeRecuitSimule;

public class UIAlgorithmeRecuitSimule implements Observer{
	private AlgorithmeRecuitSimule algorithme;
	private ParametreAlgorithmeRecuitSimule parametre;
	public UIAlgorithmeRecuitSimule(AlgorithmeRecuitSimule ag, ParametreAlgorithmeRecuitSimule p) {
		algorithme = ag;
		parametre = p;
		ag.addObserver(this);
	}

	private String afficherEtat() {
		AlgorithmeRecuitSimule algorithme = (AlgorithmeRecuitSimule)this.algorithme;
		EtatAlgorithmeRecuitSimule meilleur = algorithme.getEtat();
		return algorithme.getTemperature()+">> Energie: "+meilleur.getEnergie()+", état: "+Arrays.toString(meilleur.getEtat())+"\n";
	}
	private String afficherResultat() {
		AlgorithmeRecuitSimule algorithme = (AlgorithmeRecuitSimule)this.algorithme;
		ParametreAlgorithmeRecuitSimule parametre = (ParametreAlgorithmeRecuitSimule) algorithme.getParametre();
		EtatAlgorithmeRecuitSimule meilleur = algorithme.getEtat();
		StringBuilder sb = new StringBuilder("\n-- Résultat --\n");
		sb.append("Algorithme: Algorithme recuit simulé\n\n");
		sb.append("Temps d'exécution: ");
		sb.append(algorithme.getTempsExecutionFormatted(algorithme.getTempsExecution( System.currentTimeMillis())));
		
		sb.append("\n");
		sb.append("Seed: ");
		sb.append(parametre.getSeed());
		sb.append("\n");
		sb.append("Nombre processeurs: ");
		sb.append(parametre.getNombreProcesseurs());
		sb.append("\n");
		sb.append("Température initiale: ");
		sb.append(parametre.getTemperatureInitiale());
		sb.append("\n");
		sb.append("Température finale: ");
		sb.append(parametre.getTemperatureFinale());
		sb.append("\n");
		sb.append("Variation de température: ");
		sb.append(parametre.getVariationTemperature());
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
		sb.append("Energie: ");
		sb.append(meilleur.getEnergie());
		sb.append("\n");
		sb.append("Etat: ");
		sb.append(Arrays.toString(meilleur.getEtat()));
		sb.append("\n\n");
		return sb.toString();
	}
	@Override
	public void update(Observable o, Object arg1) {
		System.out.println(afficherEtat());
		if(((AlgorithmeRecuitSimule)algorithme).getTemperature() <= ((ParametreAlgorithmeRecuitSimule)algorithme.getParametre()).getTemperatureFinale()) {
			System.out.println(afficherResultat());
		}
	}
}
