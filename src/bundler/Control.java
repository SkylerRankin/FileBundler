package bundler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Control {
	
	private View view;
	private Model model;
	
	public Control(View _v, Model _m) {
		view = _v;
		model = _m;
		addListeners();
	}
	
	private void addListeners() {
		view.addButtonListeners(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton src = (JButton)ae.getSource();
			String cmd = src.getActionCommand();
			JFileChooser c;
			String path;
			switch (cmd) {
			case "browse for directory":
				c = new JFileChooser();
			    c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int temp = c.showOpenDialog(view);
				System.out.println(temp);
				if (temp == 0) {
					path = c.getSelectedFile().getPath().toString();
					view.updateInputFields("Choose file directory", path);
					model.setInputPath(c.getSelectedFile().getPath().toString());
					view.sendText("Selected directory "+c.getSelectedFile().getPath().toString(), Color.BLACK, false);
				}
				break;
				
			case "browse for output":
				c = new JFileChooser();
			    c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				temp = c.showOpenDialog(view);
				if (temp == 0) {
					path = c.getSelectedFile().getPath().toString();
					view.updateInputFields("Choose save location", path);
					model.setSavePath(path);
					view.sendText("Save directory "+c.getSelectedFile().getPath().toString(), Color.BLACK, false);
				}
				break;
				
			case "bundle":
				model.setFileName(view.getInputFieldText("Choose file name"));
				Thread worker = new Thread(new Worker());
				worker.start();
				break;
			
			}
		}
	}

	class Worker implements Runnable {
		@Override
		public void run() {
			System.out.println("running thread");
			model.bundle();
		}
	}
}

/* To read from the file
 JButton src = (JButton)ae.getSource();
			String cmd = src.getActionCommand();
			switch (cmd) {
			case "browse for directory":
				view.sendText("Seaching for directory", Color.BLACK, false);
				JFileChooser c = new JFileChooser();
				int temp = c.showOpenDialog(view);
				Path file = Paths.get(c.getSelectedFile().getPath());
				String text = "";
				try (InputStream in = Files.newInputStream(file);
					 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
				    String line = null;
				    while ((line = reader.readLine()) != null) {
				    	text += line;
				    }
				    if (text.length() > 0) {
				    	System.out.println(text);
				    }
				} catch (IOException io) {
					
				}
				
				*/
