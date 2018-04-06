package view.GUI.block;

import java.awt.Dimension;

import javax.swing.JPanel;

import view.GUI.controller.ControleController;

import javax.swing.JButton;

public class ControleView extends JPanel {
	private ControleController controleController;
	public ControleView(ControleController cc) {
		controleController = cc;
		setPreferredSize(new Dimension(0,48));	
		
		JButton btnExecuter = new JButton("Executer");
		btnExecuter.addActionListener(controleController);
		add(btnExecuter);
	}
}
