package bundler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Model {
	
	private String input_path;
	private String save_path;
	private String file_name;
	
	public void setInputPath(String p) { input_path = p; }
	public void setSavePath(String p) { save_path = p; }
	public void setFileName(String p) { file_name = p; }
	public String getInputPath() { return input_path; }
	public String getSavePath() { return save_path; }
	public String getFileName() { return file_name; }
	
	public void bundle() {
		if (input_path != null && save_path != null) {
			String result = "";
			File[] files = new File(input_path.toString()).listFiles();
			for (int i=0; i<files.length; ++i) {
				result += readFile(files[i]);
				System.out.println(i + "file"+(i==1?"":"s")+" completed");
			}
			writeFile(result, save_path);
			System.out.println("Complete: "+files.length);	
		}
	}
	
	private String readFile(File file) {
		String text = "";
		try (InputStream in = Files.newInputStream(Paths.get(file.getPath()));
			 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	text += line;
		    }
		} catch (IOException io) {
			System.out.println("Read file ioexception\n"+io);
		}
		return text;
	}
	
	private void writeFile(String s, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path+"\\"+file_name));
			writer.write(s);
			writer.close();
		} catch (IOException e) {
			System.out.println("failed: ioexception");
			System.out.println(e);
		}
	}
}

