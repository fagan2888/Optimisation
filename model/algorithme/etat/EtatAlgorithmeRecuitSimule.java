package model.algorithme.etat;

import java.util.Random;

import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeRecuitSimule;

public class EtatAlgorithmeRecuitSimule {
	private int[] etat;
	private int energie;
	
	public EtatAlgorithmeRecuitSimule(int[] e) {
		etat = e;
	}

	public void evaluation(Parametre parametre) {
		int maxScore = 0;
		int currentScore = 0;
		for(int i = 0, l = etat.length; i < l; i++) {
			int tache = etat[i];
			if(tache == 0){
				if(currentScore > maxScore) {
					maxScore = currentScore;
				}
				currentScore = 0;
			}else {
				currentScore += parametre.getPoidsTache(etat[i]-1);
			}
		}
		if(currentScore > maxScore) {
			maxScore = currentScore;
		}
		energie = maxScore;
	}
	
	public int deltaE(int energieActuelle) {
		return energie - energieActuelle;
	}
	
	public EtatAlgorithmeRecuitSimule getPotentielSuccesseur() {
		int tailleEtat = etat.length;
		int[] successeur = new int[tailleEtat];
		for(int i = 0; i< tailleEtat; i++) {
			successeur[i] = etat[i];
		}
		return new EtatAlgorithmeRecuitSimule(successeur);
	}
	
	public int[] getEtat() {
		return etat;
	}

	public int getEnergie() {
		return energie;
	}
}
