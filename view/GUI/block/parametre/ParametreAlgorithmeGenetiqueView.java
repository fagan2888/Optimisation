package view.GUI.block.parametre;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import java.awt.Dimension;

public class ParametreAlgorithmeGenetiqueView extends ParametreView{
	private JTextField tfTaillePopulationEnfant;
	private JTextField tfTaillePopulation;
	private JTextField tfNombreGenerations;
	private JTextField tfPourcentageMutation;
	public ParametreAlgorithmeGenetiqueView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel parentPanel = super.getContent();
		JScrollPane spParentPanel = new JScrollPane(parentPanel);
		spParentPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		spParentPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel = getContent();
		JScrollPane spPanel = new JScrollPane(panel);
		spPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		spPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.34);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(spParentPanel);
		splitPane.setRightComponent(spPanel);
		
		add(splitPane);
	}
	
	protected JPanel getContent() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblNombreGenerations = new JLabel("Nombre de g\u00E9n\u00E9rations");
		lblNombreGenerations.setBounds(12, 13, 155, 16);
		panel.add(lblNombreGenerations);
		
		tfNombreGenerations = new JTextField();
		tfNombreGenerations.setBounds(179, 13, 236, 22);
		panel.add(tfNombreGenerations);
		tfNombreGenerations.setColumns(10);
		
		JLabel lblTaillePopulation = new JLabel("Taille population");
		lblTaillePopulation.setBounds(12, 61, 155, 16);
		panel.add(lblTaillePopulation);
		
		tfTaillePopulation = new JTextField();
		tfTaillePopulation.setBounds(179, 61, 236, 22);
		panel.add(tfTaillePopulation);
		tfTaillePopulation.setColumns(10);
		
		JLabel lblTaillePopulationEnfant = new JLabel("Taille population enfant");
		lblTaillePopulationEnfant.setBounds(12, 109, 155, 16);
		panel.add(lblTaillePopulationEnfant);
		
		tfTaillePopulationEnfant = new JTextField();
		tfTaillePopulationEnfant.setBounds(179, 109, 236, 22);
		panel.add(tfTaillePopulationEnfant);
		tfTaillePopulationEnfant.setColumns(10);
		
		JLabel lblPourcentageMutation = new JLabel("Pourcentage de mutation");
		lblPourcentageMutation.setBounds(12, 157, 155, 16);
		panel.add(lblPourcentageMutation);
		
		tfPourcentageMutation = new JTextField();
		tfPourcentageMutation.setBounds(179, 157, 236, 22);
		panel.add(tfPourcentageMutation);
		tfPourcentageMutation.setColumns(10);
		
		return panel;
	}

	public String getTextTfTaillePopulationEnfant() {
		return tfTaillePopulationEnfant.getText();
	}

	public void setTextTfTaillePopulationEnfant(String taillePopulationEnfant) {
		this.tfTaillePopulationEnfant.setText(taillePopulationEnfant);
	}

	public String getTextTfTaillePopulation() {
		return tfTaillePopulation.getText();
	}

	public void setTextTfTaillePopulation(String taillePopulation) {
		this.tfTaillePopulation.setText(taillePopulation);
	}

	public String getTextTfNombreGenerations() {
		return tfNombreGenerations.getText();
	}

	public void setTextTfNombreGenerations(String nombreGenerations) {
		this.tfNombreGenerations.setText(nombreGenerations);
	}

	public String getTextTfPourcentageMutation() {
		return tfPourcentageMutation.getText();
	}

	public void setTextTfPourcentageMutation(String pourcentageMutation) {
		this.tfPourcentageMutation.setText(pourcentageMutation);
	}
	
	
}
