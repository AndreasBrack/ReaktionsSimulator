import javax.swing.JFrame;


public class SimulationMain {

	public static void main(String[] args) {

		Bild b = new Bild(100);
		JFrame f = new JFrame();

		f.add(b);
		f.setVisible(true);
		f.setTitle("Test");
		f.setSize(800,800);
		b.wBild();

	}
}
