import javax.swing.JFrame;


public class SimulationMain {

	public static void main(String[] args) {

		Bild b = new Bild(150, 100, 0, 400);
		JFrame f = new JFrame();

		f.add(b);
		f.setVisible(true);
		f.setTitle("Test");
		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.wBild();

		
		// TODO remove launch if terminated
	}
}