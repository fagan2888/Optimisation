package model.algorithme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Observable;
import java.util.Random;

import model.algorithme.etat.IndividuAlgorithmeGenetique;
import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeGenetique;

public class AlgorithmeGenetique extends Algorithme{
	private IndividuAlgorithmeGenetique[] population;
	private int generation;
	public AlgorithmeGenetique(Parametre p) {
		super(p);
		
	}
	
	public void init() {
		generation = 0;
		population = genererPopulation(((ParametreAlgorithmeGenetique)parametre).getTaillePopulationEnfant());
	}
	
	public void run() {
		debutExecution = System.currentTimeMillis();
		init();
		for(int l = ((ParametreAlgorithmeGenetique)parametre).getNombreGenerations(); generation<l; generation++) {
			evaluationPopulation(population);
			population = selectionPopulationParRang(population);
			setChanged();
			notifyObservers();
			population = croisementMutationPopulation(population);
		}
	}
	
	private IndividuAlgorithmeGenetique[] croisementMutationPopulation(IndividuAlgorithmeGenetique[] population) {
		Random random = parametre.getRandom();
		int nombreProcesseurs = parametre.getNombreProcesseurs();
		int taillePopulationEnfant = ((ParametreAlgorithmeGenetique)parametre).getTaillePopulationEnfant();
		float pourcentageMutation = ((ParametreAlgorithmeGenetique)parametre).getPourcentageMutation();
		int randomBound = ((ParametreAlgorithmeGenetique)parametre).getTaillePopulation();
		IndividuAlgorithmeGenetique[] nouvellePopulation = new IndividuAlgorithmeGenetique[taillePopulationEnfant];
		for(int i = 0; i < taillePopulationEnfant; i++) {
			/* Croisement */
			// On admet que le fait d'avoir un fils qui est exactement comme le pere n'est pas derangeant.
			int index1 = random.nextInt(randomBound);
			int index2 = random.nextInt(randomBound);
			IndividuAlgorithmeGenetique enfant = population[index1].croisement(random, population[index2].getGenome(), nombreProcesseurs);
			/* Mutation */
			if(random.nextFloat()< pourcentageMutation) {
				enfant.mutation(random);
			}
			nouvellePopulation[i] = enfant;
		}
		return nouvellePopulation;
	}
	
	private IndividuAlgorithmeGenetique[] selectionPopulationParRang(IndividuAlgorithmeGenetique[] population){
		Arrays.sort(population, IndividuAlgorithmeGenetique.getScoreComparator());
		return population;
	}
	
	
	
	// TOFIX: Cette méthode n'est pas fonctionnelle
	private IndividuAlgorithmeGenetique[] selectionPopulationParTournoi(IndividuAlgorithmeGenetique[] population) {
		ParametreAlgorithmeGenetique parametre = ((ParametreAlgorithmeGenetique)this.parametre);
		
		HashSet<IndividuAlgorithmeGenetique> indexIndividusChoisis = new HashSet();
		
		Random random = parametre.getRandom();
		int randomBound = population.length;
		int iicSize = 0;
		for(int l = parametre.getTaillePopulationEnfant(); iicSize<l; ) {
			System.out.println(iicSize);
			int index1 = random.nextInt(randomBound);
			int index2 = random.nextInt(randomBound);
			if(index1!=index2) {
				if(population[index1].getScore()>population[index2].getScore()) {
					indexIndividusChoisis.add(population[index2]);
				}else {
					indexIndividusChoisis.add(population[index1]);
				}
			}
			iicSize = indexIndividusChoisis.size();
		}
		System.out.println("SIZE: "+indexIndividusChoisis.size());
		int i =0;
		for(IndividuAlgorithmeGenetique individu: indexIndividusChoisis) {
			population[i]=individu;
			i++;
		}
		return population;
	}
	
	private IndividuAlgorithmeGenetique[] genererPopulation(int taillePopulation) {
		int tailleGenome = ((ParametreAlgorithmeGenetique)parametre).getTailleGenome();
		IndividuAlgorithmeGenetique[] population = new IndividuAlgorithmeGenetique[taillePopulation];
		for(int i =0; i<taillePopulation; i++) {
			population[i] = genererIndividu(tailleGenome);
		}
		return population;
	}
	private IndividuAlgorithmeGenetique genererIndividu(int tailleGenome) {
		int[] genome = genererEtat();
		return new IndividuAlgorithmeGenetique(genome);
	}
	 
	  private void evaluationPopulation(IndividuAlgorithmeGenetique[] population) {
		  for(int i =0, l = population.length; i<l; i++) {
			  population[i].evaluation(((ParametreAlgorithmeGenetique)parametre));
		  }
	  }

	public IndividuAlgorithmeGenetique[] getPopulation() {
		return population;
	}

	public int getGeneration() {
		return generation;
	}
	  
}
