package view.GUI.controller.console;

import java.util.Observer;

import model.algorithme.Algorithme;
import view.GUI.block.ConsoleView;

public abstract class ConsoleController implements Observer{
	protected ConsoleView consoleView;
	protected Algorithme algorithme;
	public ConsoleController(ConsoleView cv, Algorithme a) {
		consoleView = cv;
		algorithme = a;
	}

}
