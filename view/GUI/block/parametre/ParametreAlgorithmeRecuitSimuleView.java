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

public class ParametreAlgorithmeRecuitSimuleView extends ParametreView{
	private JTextField tfVariationTemperature;
	private JTextField tfTemperatureFinale;
	private JTextField tfTemperatureInitiale;
	public ParametreAlgorithmeRecuitSimuleView() {
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
		splitPane.setResizeWeight(0.34);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(spParentPanel);
		splitPane.setRightComponent(spPanel);
		
		add(splitPane);
	}
	
	protected JPanel getContent() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblTemperatureInitiale = new JLabel("Temp\u00E9rature initiale");
		lblTemperatureInitiale.setBounds(12, 13, 155, 16);
		panel.add(lblTemperatureInitiale);
		
		tfTemperatureInitiale = new JTextField();
		tfTemperatureInitiale.setBounds(179, 13, 236, 22);
		panel.add(tfTemperatureInitiale);
		tfTemperatureInitiale.setColumns(10);
		
		JLabel lblTemperatureFinale = new JLabel("Temp\u00E9rature finale");
		lblTemperatureFinale.setBounds(12, 61, 155, 16);
		panel.add(lblTemperatureFinale);
		
		tfTemperatureFinale = new JTextField();
		tfTemperatureFinale.setBounds(179, 61, 236, 22);
		panel.add(tfTemperatureFinale);
		tfTemperatureFinale.setColumns(10);
		
		JLabel lblVariationTemperature = new JLabel("Variation de temp\u00E9rature");
		lblVariationTemperature.setBounds(12, 109, 155, 16);
		panel.add(lblVariationTemperature);
		
		tfVariationTemperature = new JTextField();
		tfVariationTemperature.setBounds(179, 109, 236, 22);
		panel.add(tfVariationTemperature);
		tfVariationTemperature.setColumns(10);
		
		return panel;
	}

	public String getTextTfVariationTemperature() {
		return tfVariationTemperature.getText();
	}

	public void setTextTfVariationTemperature(String variationTemperature) {
		this.tfVariationTemperature.setText(variationTemperature);
	}

	public String getTextTfTemperatureFinale() {
		return tfTemperatureFinale.getText();
	}

	public void setTextTfTemperatureFinale(String temperatureFinale) {
		this.tfTemperatureFinale.setText(temperatureFinale);
	}

	public String getTextTfTemperatureInitiale() {
		return tfTemperatureInitiale.getText();
	}

	public void setTextTfTemperatureInitiale(String temperatureInitiale) {
		this.tfTemperatureInitiale.setText(temperatureInitiale);
	}
	
	
}
