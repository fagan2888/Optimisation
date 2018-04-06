package model.algorithme;

import java.util.Random;

import model.algorithme.etat.EtatAlgorithmeRecuitSimule;
import model.algorithme.etat.IndividuAlgorithmeGenetique;
import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeGenetique;
import model.parametre.ParametreAlgorithmeRecuitSimule;

public class AlgorithmeRecuitSimule extends Algorithme{
	private float temperature;
	private EtatAlgorithmeRecuitSimule etat;
	public AlgorithmeRecuitSimule(Parametre p) {
		super(p);
	}
	
	private void init() {
		etat = generationEtat();
		temperature = ((ParametreAlgorithmeRecuitSimule)parametre).getTemperatureInitiale();
	}
	
	public void run() {
		debutExecution = System.currentTimeMillis();
		init();
		
		while(temperature > ((ParametreAlgorithmeRecuitSimule)parametre).getTemperatureFinale()) {
			etat = getSuccesseur();
			temperature = varierTemperature();
			setChanged();
			notifyObservers();
		}
	}
	
	public float varierTemperature() {
		return temperature * ((ParametreAlgorithmeRecuitSimule)parametre).getVariationTemperature();
	}
	
	public EtatAlgorithmeRecuitSimule getSuccesseur() {
		EtatAlgorithmeRecuitSimule successeur = etat.getPotentielSuccesseur();
		successeur.evaluation(parametre);
		int deltaE = successeur.deltaE(etat.getEnergie()); 
		double probabilite = Math.exp((-deltaE/temperature));
		if(successeur.getEnergie()<etat.getEnergie() || parametre.getRandom().nextDouble() < probabilite) {
			successeur = etat;
		}
		return successeur;
	}
	
	private EtatAlgorithmeRecuitSimule generationEtat() {
		int[] etat = genererEtat();
		return new EtatAlgorithmeRecuitSimule(etat);
	}
	
	public EtatAlgorithmeRecuitSimule getEtat() {
		return etat;
	}
	
	public float getTemperature() {
		return temperature;
	}
}
