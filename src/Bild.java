import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

@SuppressWarnings("serial")
public class Bild extends JPanel implements ActionListener{

	Timer t = new Timer(100, this);
	int value = 0;
	Kugel[] kugeln;

	public int abs(int x){
		return x > 0 ? x : -x;
	}


	public void wBild() {
		this.paintComponent(getGraphics());
	}

	public Bild(int number) {
		kugeln = new Kugel[number];

		for(int i = 0; i < number; i++){
			kugeln[i] = new Kugel(i % 2 + 1);
		}

		//		value = (int) (MAX * filled);
		//		this.b 		= b;
		//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		setTitle("Bild" + b.name);
		setSize(800, 600);
		setVisible(true);
	}


	@Override public void paintComponent(Graphics g) {
		//		super.paintComponent(g);

		Insets insets = getInsets();
		int originX = insets.left;
		int originY = insets.top;
		int breite  = getSize().width  - insets.left - insets.right;
		int hoehe   = getSize().height - insets.top  - insets.bottom;

		g.setColor(Color.yellow);
		g.clearRect(originX, originY, breite-1, hoehe-1);
		g.setColor(Color.black);

		breite -= 50;
		hoehe  -= 50;
		g.setFont(new Font("TimesRoman", Font.PLAIN, Math.min(breite, hoehe)/30));

		for(Kugel m1 : kugeln){
			for(Kugel m2 : kugeln){
				Kugel.meeting(m1, m2);
			}
		}

		for(int i = 0; i < kugeln.length; i++){
			Kugel k = kugeln[i];

			int dev = 50;

			if(k.posx +  k.speedx  / dev < 800 && k.posx + k.speedx  / dev > 0){
				k.posx += k.speedx / dev;
			}
			else{
				k.speedx *= -1;
			}

			if(k.posy + k.speedy / dev < 800 && k.posy + k.speedy / dev > 0){
				k.posy += k.speedy / dev;
			}
			else {
				k.speedy *= -1;
			}	
		}
		
		for(Kugel k : kugeln){
			if(k.color == 1){
				g.setColor(Color.blue);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);	
			}
			if(k.color == 2){
				g.setColor(Color.green);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if(k.color == 3){
				g.setColor(Color.black);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if(k.color == 4){
				g.setColor(Color.yellow);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
		}

		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		//		g.drawString("" + p.paarnummer, x,y);		

		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		value++;		
		repaint();
	}
}