package model.parametre;

import java.util.ArrayList;

import model.exception.ParametreException;

public class ParametreAlgorithmeRecuitSimule extends Parametre{
	private float temperatureInitiale;
	private float temperatureFinale;
	private float variationTemperature;

	public ParametreAlgorithmeRecuitSimule(String[] args) throws ParametreException {
		super(args);
	}
	protected void setDefaultValues() {
		temperatureInitiale = 10f;
		temperatureFinale = 0.01f;
		variationTemperature = 0.99f;
		nombreProcesseurs = 4;
        seed = System.currentTimeMillis();
	}
	@Override
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
            case "-ti":
            case "-temperatureInitiale":
            	if(i+1<args.length) {
            		temperatureInitiale = Float.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-temperatureInitiale (-ti) doit etre suivit d'un nombre réel positif");
            	}
            	break;
            case "-tf":
            case "-temperatureFinale":
            	if(i+1<args.length) {
            		temperatureFinale = Float.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-tf (-temperatureFinale) doit etre suivit d'un nombre réel positif");
            	}
            	break;
            case "-vt":
            case "-variationTemperature":
            	if(i+1<args.length) {
            		variationTemperature = Float.valueOf(args[i+1]);
            		i++;
            	}else {
            		throw new ParametreException("-variationTemperature (-vt) doit etre suivit d'un nombre réel positif");
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
            }
        }
        
        
        // Convertion en array
        poidsTaches = new int[tmp_poidsTaches.size()];
        for(int i =0, l = tmp_poidsTaches.size(); i<l; i++) {
        	poidsTaches[i] = tmp_poidsTaches.get(i);
        }
	}
	
	@Override
	public void checkParametres() throws ParametreException {
		/* Vérification des paramètres */
		super.checkParametres();
        if(variationTemperature == 0) {
        	throw new ParametreException("La variation de température doit être différente de 0");
        }
        if(nombreProcesseurs < 2) {
        	throw new ParametreException("Le nombre de tache doit etre supérieur ou égal à 2");
        }
	}

	public float getTemperatureInitiale() {
		return temperatureInitiale;
	}

	public float getTemperatureFinale() {
		return temperatureFinale;
	}

	public float getVariationTemperature() {
		return variationTemperature;
	}

	public void setTemperatureInitiale(float temperatureInitiale) {
		this.temperatureInitiale = temperatureInitiale;
	}

	public void setTemperatureFinale(float temperatureFinale) {
		this.temperatureFinale = temperatureFinale;
	}

	public void setVariationTemperature(float variationTemperature) {
		this.variationTemperature = variationTemperature;
	}
	
	
}
