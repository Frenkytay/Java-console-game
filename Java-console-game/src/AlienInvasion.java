import java.util.Random;

public class AlienInvasion implements Runnable {

	String type = "Day";
	String msg = "Strange objects are falling \r\n" + 
			"from the sky and people \r\n" + 
			"are running in fear - it's an \r\n" + 
			"alien invasion!\r\n" + 
			"";
	Integer dmg  ; 
	Event e ; 
	Game g ; 
	Integer persen = 5; 
	Random rand = new Random();
	public static AlienInvasion createThread(Event e, Game g ) {
		AlienInvasion v = new AlienInvasion(e,g );
		return v ;
	}
	public AlienInvasion(Event e, Game g) {
		this.e = e;
		this.g = g ;
		// TODO Auto-generated constructor stub
	}
	Boolean running = true ; 
	static Boolean paused = false ; 
	public  void pause(Boolean a ) {
		paused = a ; 
	}
	@Override
	public void run() {
		while(running) {
			while(!paused) {
				
				int temp = rand.nextInt(100);
				if(temp <= persen ) {
					Integer temp1 = rand.nextInt(5)+5;
					e.getDmg(temp1);;
					g.getHealth(temp1);
					e.getMsg(msg);
					persen = 5 ; 
				}else {
					persen++;
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				e.getMsg(" ");
			}
		}
		
	}
}
