package view.GUI.block.parametre;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class ParametreView extends JPanel{
	
	protected JTextField tfSeed;
	protected JTextField tfNombreProcesseurs;
	protected JTextArea taPoidsTaches;

	public ParametreView() {
		setPreferredSize(new Dimension(450,0));

	}
	
	protected JPanel getContent() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,80));
		panel.setBounds(0, 0, 10, 10);
		panel.setLayout(null);
		
		JLabel lblSeed = new JLabel("Seed");
		lblSeed.setBounds(15, 13, 152, 16);
		panel.add(lblSeed);
		
		tfSeed = new JTextField();
		tfSeed.setBounds(179, 13, 236, 22);
		panel.add(tfSeed);
		tfSeed.setColumns(10);
		
		JLabel lblNombreProcesseurs = new JLabel("Nombre de processeurs");
		lblNombreProcesseurs.setBounds(15, 61, 152, 16);
		panel.add(lblNombreProcesseurs);
		
		tfNombreProcesseurs = new JTextField();
		tfNombreProcesseurs.setBounds(179, 61, 236, 22);
		panel.add(tfNombreProcesseurs);
		tfNombreProcesseurs.setColumns(10);
		
		JLabel lblPoidsTaches = new JLabel("T\u00E2ches");
		lblPoidsTaches.setBounds(12, 109, 155, 16);
		panel.add(lblPoidsTaches);
		
		taPoidsTaches = new JTextArea();
		taPoidsTaches.setBounds(179, 109, 236, 71);
		panel.add(taPoidsTaches);
		
		return panel;
	}

	public String getTextTfSeed() {
		return tfSeed.getText();
	}

	public void setTextTfSeed(String seed) {
		this.tfSeed.setText(seed);
	}

	public String getTextTfNombreProcesseurs() {
		return tfNombreProcesseurs.getText();
	}

	public void setTextTfNombreProcesseurs(String nombreProcesseurs) {
		this.tfNombreProcesseurs.setText(nombreProcesseurs);
	}
	
	public String getTextTaPoidsTaches() {
		return taPoidsTaches.getText();
	}

	public void setTextTaPoidsTaches(String poidsTaches) {
		this.taPoidsTaches.setText(poidsTaches);
	}
}
