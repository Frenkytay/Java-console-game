
public class Game implements Runnable{
	static Integer health  = 100 ; 
	Integer hunger  = 100 ;
	Integer thirst = 100 ;
	Integer shelter = 0 ; 
	static Integer wood  = 0 ; 
	Integer food = 0  ; 
	Integer water = 0  ;
	Integer herb = 0 ;
	public synchronized void getHealth(int n ) {
		health = health - n ; 
	}
	public static Game createThread( ) {
		Game g = new Game();
		return g ; 
	}
	public synchronized void getWood(int n ) {
		wood = wood + n ;
	}
	public synchronized void getFood(int n ) {
		food = food + n ;
	}
	public synchronized void getWater(int n ) {
		water = water + n ;
	}
	public synchronized void getHerbs(int n ) {
		herb = herb + n ;
	}
	public synchronized void getShelter(int n ) {
		shelter = shelter + n ;
	}
	public Game() {
		// TODO Auto-generated constructor stub
	}
	Boolean running = true ; 
	Boolean pause = false  ; 
	
	@Override
	public void run() {
		
//		while(running ) {
//			while(!pause) {
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				getHealth(1);
//			}
//		}
		
	}

}
