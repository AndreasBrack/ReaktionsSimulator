import java.util.Random;


public class Kugel {
	float speedx;
	float speedy;

	static int g_id = 0;

	float posx;
	float posy;

	int color;

	int size;
	int id;

	static int g_meetcount = 0;
	static int g_reactioncount = 0;

	public Kugel(int color){
		
		System.out.println("Farbe: "  + color);
		
		this.speedx = (float) (Math.random() * 101) - 51;
		this.speedy = (float) (Math.random() * 101) - 51;

		System.out.println("Kugel fliegt mit " + speedx + " und " + speedy);

		this.posx = (float) (Math.random() * 800);
		this.posy = (float) (Math.random() * 800);

		this.color = color;
		this.size = 10;

		this.id = g_id++;
	}

	public static void meeting(Kugel k1, Kugel k2){
		if(k1.id <= k2.id){
			return;
		}
		if(Math.abs(k1.posx - k2.posx) < 5 && Math.abs(k1.posy - k2.posy) < 5 ){
			if(k1.color == 1 && k2.color == 2  || k1.color == 2 && k2.color == 1){
				k1.color = 3;
				k2.color = 4;

				k1.speedx = (float) (Math.random() * 101) - 51;
				k1.speedy = (float) (Math.random() * 101) - 51;

				k2.speedx = (float) (Math.random() * 101) - 51;
				k2.speedy = (float) (Math.random() * 101) - 51;

				g_reactioncount++;
				System.out.println("Reaktion: " + g_reactioncount + " k1.posx " + k1.posx + " k2.posx " + k2.posx );
			}
			else {
				k1.speedx = (float) (Math.random() * 101) - 51;
				k1.speedy = (float) (Math.random() * 101) - 51;

				k2.speedx = (float) (Math.random() * 101) - 51;
				k2.speedy = (float) (Math.random() * 101) - 51;
				
				g_meetcount++;
			}

		}
	}

}
