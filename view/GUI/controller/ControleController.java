package view.GUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI.GUI;
import view.GUI.controller.parametre.ParametreController;

public class ControleController implements ActionListener{
	private GUI gui;
	public ControleController(GUI g) {
		gui = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.run();
	}

}
