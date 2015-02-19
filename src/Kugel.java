import java.util.Random;



public class Kugel {
	public static boolean g_block = false;  				// TODO CHANGE HERE
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

		if(color == 1){
			System.out.println("Farbe: "  + color);

			this.speedx = (0);
			this.speedy = (0);

			System.out.println("Kugel fliegt mit " + speedx + " und " + speedy);

			if(!g_block){

				float zufallx = (float) (Math.random() * 100) - 41;

				if(zufallx < -20){
					this.posx = 400 + zufallx - 150;
				} else if(zufallx < 0){
					this.posx = 400 + zufallx - 75;
				} else if(zufallx < 20){
					this.posx = 400 + zufallx - 0;
				} else if(zufallx < 40){
					this.posx = 400 + zufallx + 75;
				} else {
					this.posx = 400 + zufallx + 150;
				}


				this.posy = 730 + (float) (Math.random() * 41) - 21;

				this.color = color;
				this.size = 10;

			}
			else {
				System.out.println("Farbe: "  + color);

				this.speedx = (0);
				this.speedy = (0);

				System.out.println("Kugel fliegt mit " + speedx + " und " + speedy);

				this.posx = 400 + (float) (Math.random() * 100) - 41;
				this.posy = 730 + (float) (Math.random() * 41) - 21;

				this.color = color;
				this.size = 15;

			}
		}
		else {
			System.out.println("Farbe: "  + color);

			this.speedx = (float) (Math.random() * 101) - 51;
			this.speedy = (float) (Math.random() * 101) - 51;

			System.out.println("Kugel fliegt mit " + speedx + " und " + speedy);

			this.posx = (float) (Math.random() * 800);
			this.posy = (float) (Math.random() * 700);

			this.color = color;
			this.size = 15;
		}

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

				if(k1.color != 1){
					k1.speedx = (float) (Math.random() * 101) - 51;
					k1.speedy = (float) (Math.random() * 101) - 51;
				}

				if(k2.color != 1){
					k2.speedx = (float) (Math.random() * 101) - 51;
					k2.speedy = (float) (Math.random() * 101) - 51;
				}
				g_reactioncount++;
				System.out.println("Reaktion: " + g_reactioncount);
				//				System.out.println("Reaktion: " + g_reactioncount + " k1.posx " + k1.posx + " k2.posx " + k2.posx );
			}
			else if(k1.color == 1 && k2.color == 1){

			}
			else {
				if(k1.color != 1){
					k1.speedx = (float) (Math.random() * 101) - 51;
					k1.speedy = (float) (Math.random() * 101) - 51;
				}
				if(k2.color != 1){
					k2.speedx = (float) (Math.random() * 101) - 51;
					k2.speedy = (float) (Math.random() * 101) - 51;
				}
				g_meetcount++;
			}

		}
	}

}