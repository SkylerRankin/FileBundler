package bundler;

public class Bundler {
	public static void main(String[] args) {
		View v = new View();
		Model m = new Model();
		Control c = new Control(v, m);
	}
}
