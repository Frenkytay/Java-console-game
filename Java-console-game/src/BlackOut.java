import java.util.Random;

public class BlackOut implements Runnable {

	String type = "Day";
	String msg = "The world is dark and \r\n" + 
			"silent, as a massive \r\n" + 
			"blackout has plunged \r\n" + 
			"everything into darkness.";
	Integer dmg  ; 
	Event e ; 
	Game g ; 
	Integer persen = 5; 
	Random rand = new Random();
	public static BlackOut createThread(Event e ,Game g) {
		BlackOut v = new BlackOut(e ,g);
		return v ;
	}
	public BlackOut(Event e,Game g) {
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
					
					e.getDmg(-2);;
					
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
				e.getDmg(0);
				e.getMsg(" ");
			}
		}
		
	}
}
