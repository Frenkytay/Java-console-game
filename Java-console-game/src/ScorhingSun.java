import java.util.Random;

public class ScorhingSun implements Runnable {
	String type = "Day";
	String msg = "The sun is burning hot and \r\n" + 
			"the air is stifling - it's a \r\n" + 
			"scorching day!";
	Integer dmg  ; 
	Event e ; 
	Game g;
	Integer persen = 5; 
	Random rand = new Random();
	public static ScorhingSun createThread(Event e,Game g ) {
		ScorhingSun v = new ScorhingSun(e,g );
		return v ;
	}
	public ScorhingSun(Event e,Game g) {
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
					e.getDmg(-1);
					
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
