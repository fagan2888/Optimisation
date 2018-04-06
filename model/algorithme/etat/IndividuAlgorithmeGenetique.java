package model.algorithme.etat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import model.parametre.ParametreAlgorithmeGenetique;

public class IndividuAlgorithmeGenetique {
	private int[] genome;
	private int score;

	public IndividuAlgorithmeGenetique(int[] g) {
		genome = g;
	}

	public void evaluation(ParametreAlgorithmeGenetique parametre) {
		int maxScore = 0;
		int currentScore = 0;
		for(int i = 0, l = genome.length; i < l; i++) {
			int tache = genome[i];
			if(tache == 0){
				if(currentScore > maxScore) {
					maxScore = currentScore;
				}
				currentScore = 0;
			}else {
				currentScore += parametre.getPoidsTache(genome[i]-1);
			}
		}
		if(currentScore > maxScore) {
			maxScore = currentScore;
		}
		score = maxScore;
	}

	public IndividuAlgorithmeGenetique croisement(Random random, int[] genome2, int nombreProcesseurs) {
		int nombreProcesseursRestants = nombreProcesseurs -1; 
		int tailleGenome = genome.length;
		int[] nouveauGenome = new int[tailleGenome];

		// Empêche que le croisement se face sur les côtés
		int indexCroisement = random.nextInt(tailleGenome-2)+1;
		for(int i =0; i< indexCroisement; i++) {
			nouveauGenome[i] = genome[i];
			if(nouveauGenome[i] == 0) {
				nombreProcesseursRestants --;
			}
		}
		for(int i = indexCroisement; i< tailleGenome; i++) {
			boolean found = false;
			for(int j = 0; j<tailleGenome && !found; j++) {
				// Si la valeur du genome2 n'est pas encore dans le nouveau genome
				if(genome2[j] ==0) {
					if(nombreProcesseursRestants > 0) {
						nouveauGenome[i] = 0;
						nombreProcesseursRestants --;
						found = true;
					}
				}
				if(!found && !arrayContains(nouveauGenome, genome2[j])) {
					nouveauGenome[i] = genome2[j];
					found = true;
				}
			}    
		}
		return new IndividuAlgorithmeGenetique(nouveauGenome);
	}

	private boolean arrayContains(int[] array, int value) {
		for(int i = 0, l = array.length; i<l; i++) {
			if(array[i] == value)
				return true;
		}
		return false;
	}

	public void mutation(Random random) {
		int randomBound = genome.length;
		int index1 = random.nextInt(randomBound);
		int index2 = random.nextInt(randomBound);
		int tmp = genome[index1];
		genome[index1]= genome[index2];
		genome[index2] = tmp;
	}

	public int[] getGenome() {
		return genome;
	}

	public int getScore() {
		return score;
	}

	private static Comparator<IndividuAlgorithmeGenetique> scoreComparator = new Comparator<IndividuAlgorithmeGenetique>() {

		@Override
		public int compare(IndividuAlgorithmeGenetique o1, IndividuAlgorithmeGenetique o2) {
			int score1 = o1.getScore();
			int score2 = o2.getScore();
			return score1 - score2;
		}

	};

	public static Comparator<IndividuAlgorithmeGenetique> getScoreComparator() {
		return scoreComparator;
	}
	
	public String toString() {
		return "Individu: [Genome:"+Arrays.toString(genome)+", score:"+score+"]";
	}
}
