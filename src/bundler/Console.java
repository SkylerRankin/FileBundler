package bundler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//TODO:: make scroll bar auto scroll

public class Console extends JPanel{
	
	private JTextPane text;
	private JScrollPane scroll;
	
	public Console() {
		this.setPreferredSize(new Dimension(230, 300));
		this.setLayout(new GridLayout(1, 1));
		text = new JTextPane();
		text.setEditable(false);
		scroll = new JScrollPane(text);
		this.add(scroll);
		
		writeToConsole("Application opened", new Color(27, 132, 13), true);
		
	}
	
	public void writeToConsole(String s, Color color, boolean bold) {
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet attr = new SimpleAttributeSet();
		attr.addAttribute(StyleConstants.CharacterConstants.Bold, bold);
		attr.addAttribute(StyleConstants.Foreground, color);
		try {
			doc.insertString(doc.getLength(), s+"\n", attr);
		} catch (BadLocationException e) {
			System.err.println("Bad location exception: "+e);
		}
		
	}
}
