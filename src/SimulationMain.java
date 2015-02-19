import javax.swing.JFrame;


public class SimulationMain {

	public static void main(String[] args) {

		Bild b = new Bild(100, 300, 0, 500);
		JFrame f = new JFrame();

		f.add(b);
		f.setVisible(true);
		f.setTitle("Test");
		f.setSize(800,800);
		b.wBild();

		
		// TODO remove launch if terminated
	}
}