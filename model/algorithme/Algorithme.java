package model.algorithme;

import java.util.Observable;
import java.util.Random;

import model.parametre.Parametre;

public abstract class Algorithme extends Observable{
	protected Parametre parametre;
	protected long debutExecution;
	public Algorithme(Parametre p) {
		parametre = p;
		debutExecution = 0;
	}
	
	public abstract void run();
	
	public int[] genererEtat() {
		int[] etat = new int[parametre.getTailleEtat()];
		int i =0;
		for(int l = parametre.getNombreTaches(); i<l; i++) {
			etat[i] = i+1;
		}
		for(int l = parametre.getNombreProcesseurs()-1; i<l; i++) {
			etat[i] = 0;
		}
		melangeFisherYates(etat);
		return etat;
	}
	
	private void melangeFisherYates(int[] tableau)
	  {
	    Random random = parametre.getRandom();
	    for (int i = tableau.length - 1; i > 0; i--)
	    {
	      int index = random.nextInt(i + 1);
	      
	      int tmp = tableau[index];
	      tableau[index] = tableau[i];
	      tableau[i] = tmp;
	    }
	  }
	
	public Parametre getParametre() {
		return parametre;
	}
	
	public long getTempsExecution(long finExecution) {
		return finExecution-debutExecution;
	}
	
	public String getTempsExecutionFormatted(long tempsExecution) {
		long milliSeconds = tempsExecution;
	    String tempsExecutionString = String.format(
	        "%ds%dms",
	        milliSeconds / 1000,
	        (milliSeconds %1000));
	    return tempsExecutionString;
	}
}
