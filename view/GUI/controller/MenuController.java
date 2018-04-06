package view.GUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButtonMenuItem;

import view.GUI.GUI;
import view.GUI.block.MenuView;

public class MenuController implements ActionListener {
	private GUI gui;
	
	public MenuController(GUI g) {
		gui = g;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String algorithme = (String) ((JRadioButtonMenuItem) e.getSource()).getClientProperty("algorithme");
		gui.setAlgorithme(algorithme, null);
	}

}
