package model.parametre;

import java.util.Random;

import model.exception.ParametreException;

public abstract class Parametre {
	protected Random random;
	protected long seed;
	protected int nombreProcesseurs;
	protected int[] poidsTaches;
	public Parametre(String[] args) throws ParametreException {
		setDefaultValues();
		if(args != null) {
			handleParametres(args);
		}
	}

	public void checkParametres() throws ParametreException{
		if(poidsTaches == null || poidsTaches.length < 2) {
			throw new ParametreException("Il doit y avoir au moins deux taches");
		}
		random = new Random(seed);
	}

	protected abstract void handleParametres(String[] args) throws ParametreException;

	protected void setDefaultValues() {
		seed = System.currentTimeMillis();
	}
	
	public int getNombreProcesseurs() {
		return nombreProcesseurs;
	}

	public int getNombreTaches() {
		return poidsTaches.length;
	}
	
	public int getPoidsTache(int tache) {
		return poidsTaches[tache];
	}
	
	public int getTailleEtat() {
		return getNombreTaches()+getNombreProcesseurs()-1;
	}
	
	public long getSeed() {
		return seed;
	}
	
	public Random getRandom() {
		return random;
	}

	public int[] getPoidsTaches() {
		return poidsTaches;
	}

	public void setPoidsTaches(int[] poidsTaches) {
		this.poidsTaches = poidsTaches;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}

	public void setNombreProcesseurs(int nombreProcesseurs) {
		this.nombreProcesseurs = nombreProcesseurs;
	}
}
