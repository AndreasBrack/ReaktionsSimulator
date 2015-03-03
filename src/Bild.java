import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

@SuppressWarnings("serial")
public class Bild extends JPanel implements ActionListener {
	static int last;
	Timer t = new Timer(20, this);
	int value = 0;
	Kugel[] kugeln;

	public int abs(int x) {
		return x > 0 ? x : -x;
	}

	public void wBild() {
		this.paintComponent(getGraphics());
	}

	public Bild(int edukt1, int edukt2, int produkt, int wasser) {
		int number = edukt1 + edukt2 + produkt + wasser;
		kugeln = new Kugel[number];

		for (int i = 0; i < number; i++) {
			if (i < edukt1) {
				kugeln[i] = new Kugel(1);
			} else if (i >= edukt1 && i < edukt1 + edukt2) {
				kugeln[i] = new Kugel(2);
			} else if (i >= edukt1 + edukt2 && i < edukt1 + edukt2 + produkt) {
				kugeln[i] = new Kugel(3);
			} else {
				kugeln[i] = new Kugel(5);

			}

		}

		// value = (int) (MAX * filled);
		// this.b = b;
		// setTitle("Bild" + b.name);
		setSize(800, 800);
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);

		Insets insets = getInsets();
		int originX = insets.left;
		int originY = insets.top;
		int breite = getSize().width - insets.left - insets.right;
		int hoehe = getSize().height - insets.top - insets.bottom;

		g.setColor(Color.yellow);
		g.clearRect(originX, originY, breite - 1, hoehe - 1);
		g.setColor(Color.black);

		breite -= 50;
		hoehe -= 50;
		g.setFont(new Font("TimesRoman", Font.PLAIN,
				Math.min(breite, hoehe) / 30));

		for (Kugel m1 : kugeln) {
			for (Kugel m2 : kugeln) {
				Kugel.meeting(m1, m2);
			}
		}

		for (int i = 0; i < kugeln.length; i++) {
			Kugel k = kugeln[i];

			int dev = 50;

			if (k.posx + k.speedx / dev < 800 && k.posx + k.speedx / dev > 0) {
				k.posx += k.speedx / dev;
			} else {
				k.speedx *= -1;
			}

			if (k.posy + k.speedy / dev < 800 && k.posy + k.speedy / dev > 0) {
				k.posy += k.speedy / dev;
			} else {
				k.speedy *= -1;
			}
		}

		for (Kugel k : kugeln) {
			if (k.color == 1) {
				g.setColor(Color.gray);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if (k.color == 2) {
				g.setColor(Color.red);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if (k.color == 3) {
				g.setColor(Color.black);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if (k.color == 4) {
				g.setColor(Color.blue);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
			if (k.color == 5) {
				g.setColor(Color.yellow);
				g.fillOval((int) k.posx, (int) k.posy, k.size, k.size);
			}
		}

		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		// g.drawString("" + p.paarnummer, x,y);

		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		value++;
		if(value % 500 == 0){
			
			System.out.println("Im letzten Zeitraum waren " + (Kugel.g_reactioncount - Bild.last) + " Reaktionen.");
			last = Kugel.g_reactioncount;
		}
		repaint();
	}
}