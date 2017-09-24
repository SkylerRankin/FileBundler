package bundler;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import bundler.Control.ButtonListener;


import javax.swing.*;

@SuppressWarnings("serial")
public class InputPanel extends JPanel{
	
	ArrayList<JButton> buttons = new ArrayList<>();
	ArrayList<JTextField> inputs = new ArrayList<>();
	
	public InputPanel() {
		setupGUI();
	}
	
	private void setupGUI() {
		this.setPreferredSize(new Dimension(270, 300));
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel label = new JLabel("Choose Directory");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(label, c);
		
		JTextField text = new JTextField("C:\\");
		text.setToolTipText("Choose file directory");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(1, 1, 1, 1);
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		this.add(text, c);
		
		JButton button = new JButton("Browse");
		button.setActionCommand("browse for directory");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 1;
		this.add(button, c);
		buttons.add(button);
		
		label = new JLabel("Choose Output Location");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(label, c);
		
		text = new JTextField("C:\\");
		text.setToolTipText("Choose save location");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 3;
		this.add(text, c);
		
		button = new JButton("Browse");
		button.setActionCommand("browse for output");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 6;
		c.gridy = 3;
		this.add(button, c);
		buttons.add(button);
		
		label = new JLabel("Choose Output File Name");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(label, c);
		
		text = new JTextField("untitled.txt");
		text.setToolTipText("Choose file name");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 8;
		c.gridx = 0;
		c.gridy = 5;
		this.add(text, c);
		/*
		button = new JButton("Browse");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 6;
		c.gridy = 5;
		this.add(button, c);
		buttons.add(button);
		*/
		button = new JButton("Compile");
		button.setActionCommand("bundle");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 8;
		c.gridx = 0;
		c.gridy = 6;
		this.add(button, c);
		buttons.add(button);
	}

	public void addListeners(ButtonListener bl) {
		for (JButton b : buttons) b.addActionListener(bl);
	}
	
}
