package bundler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bundler.Control.ButtonListener;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private Console console;
	private InputPanel inputpanel;
	
	public View() {
		super("File Bundler");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setupGUI();
	}
	
	private void setupGUI() {
		console = new Console();
		inputpanel = new InputPanel();
		
		this.setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(1, 2));
		container.add(inputpanel);
		container.add(console);
		this.add(container);
		this.pack();
		this.setVisible(true);
	}

	public void addButtonListeners(ButtonListener bl) {
		inputpanel.addListeners(bl);
	}
	
	public void sendText(String s, Color c, Boolean bold) {
		console.writeToConsole(s, c, bold);
	}
	
	public void updateInputFields(String label, String data) {
		for (Component comp : inputpanel.getComponents()) {
			if (comp instanceof JTextField) {
				JTextField tf = (JTextField)comp;
				if (tf.getToolTipText().equals(label))
					((JTextField) comp).setText(data);
			}
		}
	}
	
	public String getInputFieldText(String label) {
		for (Component comp : inputpanel.getComponents()) {
			if (comp instanceof JTextField) {
				JTextField tf = (JTextField)comp;
				if (tf.getToolTipText().equals(label))
					return ((JTextField) comp).getText();
			}
		}
		return "";
	}
}
