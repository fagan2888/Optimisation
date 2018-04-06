package view.GUI.block;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import view.GUI.controller.MenuController;

public class MenuView extends JMenuBar{
	MenuController mc;
	ArrayList<JRadioButtonMenuItem> options;
	public MenuView(MenuController mc) {
		this.mc = mc;
		options = new ArrayList<JRadioButtonMenuItem>();
		add(getMenu());
	}

	private JMenu getMenu() {
		JMenu jm = new JMenu("Algorithme de recherche");
		JRadioButtonMenuItem rbmiAlgorithmeGenetique = new JRadioButtonMenuItem("Algorithme génétique");
		rbmiAlgorithmeGenetique.putClientProperty("algorithme", "AlgorithmeGenetique");
		options.add(rbmiAlgorithmeGenetique);
		
		JRadioButtonMenuItem rbmiAlgorithmeRecuitSimule = new JRadioButtonMenuItem("Algorithme recuit simulé");
		rbmiAlgorithmeRecuitSimule.putClientProperty("algorithme", "AlgorithmeRecuitSimule");
		options.add(rbmiAlgorithmeRecuitSimule);
		
		for(JRadioButtonMenuItem jrbmi: options) {
			jrbmi.addActionListener(mc);
			jm.add(jrbmi);
		}
		return jm;
	}

	public void setAlgorithme(String algorithme) {
		for(JRadioButtonMenuItem jrbmi: options) {
			jrbmi.setSelected(false);
			if(algorithme.equals(jrbmi.getClientProperty("algorithme"))) {
				jrbmi.setSelected(true);
			}
		}
	}
}
