package view.GUI.block;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.AdjustmentEvent;

public class ConsoleView extends JPanel {
	private JTextArea textArea;
	private JScrollPane spPanel;
	private boolean mouseEntered;
	private boolean mousePressed;
	public ConsoleView() {
		setLayout(new BorderLayout(0, 0));
		mouseEntered = false;
		mousePressed = false;
		textArea = new JTextArea();
		textArea.setLineWrap(false);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		
		spPanel = new JScrollPane(textArea);
		spPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		spPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spPanel.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	        	if(!mouseEntered && !mousePressed) {
	        		e.getAdjustable().setValue(e.getAdjustable().getMaximum()); 
	        	}
	        }
	    });
		spPanel.getVerticalScrollBar().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mousePressed = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressed = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseEntered = false;
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEntered = true;
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		add(spPanel, BorderLayout.CENTER);
		init();
	}
	
	public void init() {
		textArea.setText("\n*** Prendre en main le logiciel: ***\n\n 1_ Sélectionnez un algorithme en cliquant sur\n    \"Algorithme de recherche\" sur le menu du haut\n\n 2_ Remplissez comme vous le souhaitez les paramètres\n    sur la zone de droite\n\n 3_ Cliquez sur le bouton d'exécution situé\n    dans la zone ci-dessous\n\n");
	}

	public void write(String text) {
		textArea.append(text);
	}
}
