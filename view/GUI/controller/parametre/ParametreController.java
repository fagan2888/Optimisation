package view.GUI.controller.parametre;

import model.parametre.Parametre;
import view.GUI.block.parametre.ParametreView;

public abstract class ParametreController {
	protected Parametre parametre;
	protected ParametreView view;
	public ParametreController(ParametreView v, Parametre p) {
		parametre = p;
		view = v;
	}
	
	public void sync() {
		if(!view.getTextTfSeed().isEmpty())
		parametre.setSeed(Long.valueOf(view.getTextTfSeed()));
		else
			parametre.setSeed(System.currentTimeMillis());
		if(!view.getTextTfNombreProcesseurs().isEmpty())
		parametre.setNombreProcesseurs(Integer.valueOf(view.getTextTfNombreProcesseurs()));
		if(!view.getTextTaPoidsTaches().isEmpty())
		parametre.setPoidsTaches(poidsTachesToIntArray(view.getTextTaPoidsTaches()));
	}
	
	public void update() {
		view.setTextTfNombreProcesseurs(""+parametre.getNombreProcesseurs());
		view.setTextTaPoidsTaches(poidsTachesToString(parametre.getPoidsTaches()));
	}
	
	protected String poidsTachesToString(int[] poidsTaches) {
		StringBuilder sb = new StringBuilder();
		if(poidsTaches != null) {
			for(int i =0, l = poidsTaches.length; i<l; i++) {
				if(i != 0)
					sb.append(";");
				sb.append(poidsTaches[i]);
			}
		}
		return sb.toString();
	}
	
	protected int[] poidsTachesToIntArray(String poidsTachesString) {
		String[] poidsTachesStringArray = poidsTachesString.split(";"); 
		int [] poidsTaches = new int[poidsTachesStringArray.length]; 
		if(poidsTachesStringArray.length > 1) {
			for(int i =0, l = poidsTachesStringArray.length; i< l; i++)
				poidsTaches[i] = Integer.parseInt(poidsTachesStringArray[i]);
		}
		return poidsTaches;
	}
}
