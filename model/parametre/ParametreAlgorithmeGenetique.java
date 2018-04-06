package model.parametre;

import java.util.ArrayList;

import model.exception.ParametreException;

public class ParametreAlgorithmeGenetique extends Parametre{
	public ParametreAlgorithmeGenetique(String[] args) throws ParametreException {
		super(args);
	}

	private int taillePopulation;
	private int nombreGenerations;
	private int taillePopulationEnfant;
	private float pourcentageMutation;
	
	protected void setDefaultValues() {
		taillePopulation = 100;
		nombreGenerations = 50;
		nombreProcesseurs = 4;
		taillePopulationEnfant = 200;
        pourcentageMutation = 0.1f;
        seed = System.currentTimeMillis();
	}
	
	protected void handleParametres(String[] args) throws ParametreException {
		ArrayList<Integer> tmp_poidsTaches = new ArrayList<Integer>();
        for (int i = 0; i != args.length; i++){
            String param = args[i];
            switch(param) {
            case "-pt":
            case "-poidsTaches":
            	i++;
            	while(i<args.length && !args[i].startsWith("-")) {
            		tmp_poidsTaches.add(Integer.valueOf(args[i]));
            		i++;
            	}
            	i --;
            	break;
            case "-s":
            case "-seed":
            	if(i+1<args.length) {
            		seed = Long.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-seed (-s) doit etre suivit d'un nombre entier");
            	}
            	break;
            case "-ng":
            case "-nombreGenerations":
            	if(i+1<args.length) {
            		nombreGenerations = Integer.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-nombreGenerations (-ng) doit etre suivit d'un nombre entier positif");
            	}
            	break;
            case "-tp":
            case "-taillePopulation":
            	if(i+1<args.length) {
            		taillePopulation = Integer.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-tp (-taillePopulation) doit etre suivit d'un nombre entier positif");
            	}
            	break;
            case "-tpe":
            case "-taillePopulationEnfant":
            	if(i+1<args.length) {
            		taillePopulationEnfant = Integer.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-taillePopulationEnfant (-tpe) doit etre suivit d'un nombre entier positif");
            	}
            	break;
            case "-np":
            case "-nombreProcesseurs":
            	if(i+1<args.length) {
            		nombreProcesseurs = Integer.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-nombreProcesseurs (-np) doit etre suivit d'un nombre entier positif");
            	}
            	break;
            case "-pm":
            case "-pourcentageMutation":
            	if(i+1<args.length) {
            		pourcentageMutation = Float.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-pourcentageMutation (-pm) doit etre suivit d'un nombre décimal positif");
            	}
            	break;
            
            }
        }
        
        
        // Convertion en array
        poidsTaches = new int[tmp_poidsTaches.size()];
        for(int i =0, l = tmp_poidsTaches.size(); i<l; i++) {
        	poidsTaches[i] = tmp_poidsTaches.get(i);
        }
    }
	
	public void checkParametres() throws ParametreException {
		/* Vérification des paramètres */
        super.checkParametres();
        if(pourcentageMutation < 0) {
        	throw new ParametreException("Le pourcentage de mutation ne peut pas etre négatif");
        }
        if(taillePopulation < 2) {
        	throw new ParametreException("La population doit etre supérieur ou égal à 2");
        }
        if(taillePopulation < 2) {
        	throw new ParametreException("La population enfant doit etre supérieur ou égal à 2");
        }
        if(nombreProcesseurs < 2) {
        	throw new ParametreException("Le nombre de tache doit etre supérieur ou égal à 2");
        }
        if(pourcentageMutation >1) {
        	throw new ParametreException("Le pourcentage de mutation ne peut pas être supérieur à 1");
        }
	}
	
	public int getTaillePopulation() {
		return taillePopulation;
	}

	public int getNombreGenerations() {
		return nombreGenerations;
	}

	public float getPourcentageMutation() {
		return pourcentageMutation;
	}

	public int getTaillePopulationEnfant() {
		return taillePopulationEnfant;
	}
	
	public int getTailleGenome() {
		return getTailleEtat();
	}

	public void setTaillePopulation(int taillePopulation) {
		this.taillePopulation = taillePopulation;
	}

	public void setNombreGenerations(int nombreGenerations) {
		this.nombreGenerations = nombreGenerations;
	}

	public void setTaillePopulationEnfant(int taillePopulationEnfant) {
		this.taillePopulationEnfant = taillePopulationEnfant;
	}

	public void setPourcentageMutation(float pourcentageMutation) {
		this.pourcentageMutation = pourcentageMutation;
	}
}
