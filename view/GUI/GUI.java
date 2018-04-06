package view.GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import view.GUI.block.ConsoleView;
import view.GUI.block.ControleView;
import view.GUI.controller.MenuController;
import view.GUI.controller.console.ConsoleController;
import view.GUI.block.MenuView;
import view.GUI.block.parametre.ParametreAlgorithmeGenetiqueView;
import view.GUI.block.parametre.ParametreView;
import view.GUI.controller.ControleController;
import view.GUI.controller.parametre.ParametreAlgorithmeGenetiqueController;
import view.GUI.controller.parametre.ParametreController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JToolBar;

import model.algorithme.Algorithme;
import model.exception.GUIException;
import model.exception.ParametreException;
import model.parametre.Parametre;
import model.parametre.ParametreAlgorithmeGenetique;

public class GUI extends JFrame{
	private ConsoleView cv;
	private MenuView mv;
	private ParametreView pv;
	private ControleView contv;
	private JSplitPane splitPane;
	private ParametreController pc;
	private Algorithme algorithme;
	
	public GUI(String[] args) {
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.34);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		
		// Titre
		setTitle("Algorithme de recherche");
		// Positionne au centre
		setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(true);
		
		// Créer le menu
		MenuController mc = new MenuController(this);
		mv = new MenuView(mc);
		getContentPane().add(mv, BorderLayout.NORTH);
		
		// Créer la console
		cv = new ConsoleView();
		splitPane.setLeftComponent(cv);
		
		
		// Créer la barre des boutons
		contv = new ControleView(new ControleController(this));
		getContentPane().add(contv, BorderLayout.SOUTH);
		
		
		getContentPane().add(splitPane, BorderLayout.CENTER);
		setSize(new Dimension(900,600));
		setAlgorithme("AlgorithmeGenetique", null);
		// La rendre visible
		setVisible(true);
	}
	public void setAlgorithme(String algorithmeName, String[] args) {
		try {
			Class parametreClass = Class.forName("model.parametre.Parametre" +algorithmeName);
			Constructor parametreConstructor = parametreClass.getConstructor(String[].class);
			Parametre parametre = (Parametre) parametreConstructor.newInstance((Object) args);
			
			Class parametreViewClass = Class.forName("view.GUI.block.parametre.Parametre" +algorithmeName+"View");
			Constructor parametreViewConstructor = parametreViewClass.getConstructor();
			pv = (ParametreView) parametreViewConstructor.newInstance();
			
			
			Class parametreControllerClass = Class.forName("view.GUI.controller.parametre.Parametre" +algorithmeName+"Controller");
			Constructor parametreControllerConstructor = parametreControllerClass.getConstructor(ParametreView.class, Parametre.class);
			pc = (ParametreController) parametreControllerConstructor.newInstance(pv, parametre);
			
			Class algorithmeClass = Class.forName("model.algorithme."+algorithmeName);
			Constructor algorithmeConstructor = algorithmeClass.getConstructor(Parametre.class);
			this.algorithme = (Algorithme) algorithmeConstructor.newInstance(parametre);
			
			Class consoleControllerClass = Class.forName("view.GUI.controller.console.Console"+algorithmeName+"Controller");
			Constructor consoleControllerConstructor = consoleControllerClass.getConstructor(ConsoleView.class, Algorithme.class);
			ConsoleController cc = (ConsoleController) consoleControllerConstructor.newInstance(cv, algorithme);
			algorithme.addObserver(cc);
			
			pc.update();
			splitPane.setRightComponent(pv);
			
			mv.setAlgorithme(algorithmeName);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erreur lors de la mise en place de l'algorithme", "Error",
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void run() {
		try {
			pc.sync();
			pc.update();
			algorithme.getParametre().checkParametres();
			algorithme.run();
		} catch(ParametreException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		GUI gui = new GUI(args);
		
	}

}
