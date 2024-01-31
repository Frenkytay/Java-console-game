import java.util.Random;
import java.util.Scanner;

public class Input implements Runnable {
	public static Input createThread(Game g ) {
		Input u = new Input(g);
		return u ;
	}
	Game g ; 
	public Input(Game g ) {
		this.g = g ; 
		// TODO Auto-generated constructor stub
	}
	Random rand = new Random();
	Boolean running = true;
	Scanner scan = new Scanner(System.in);
	int temp ; 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running) {
			char input = scan.nextLine().charAt(0);
			switch(input) {
			case '1':
				temp = rand.nextInt(5);
				g.getWood(temp);
				break;
			case '3':
				temp = rand.nextInt(5);
				g.getFood(temp);
				
				break;
			case '4':
				g.getFood(-2);
				g.hunger = g.hunger + 2 ; 
				break;
			case '5':
				temp = rand.nextInt(5);
				g.getWater(temp);
				 
				break;
			case '6':
				g.getWater(-2);
				g.thirst = g.thirst + 2 ;
				break;
			case '7':
				temp = rand.nextInt(5);
				g.getHerbs(temp);
				
			}
			
		}
	}

}
