import java.util.Random;

public class MassiveBird implements Runnable {
	String type = "Neutral";
	String msg = "The sky is filled with birds \r\n" + 
			"of all kinds, moving in a \r\n" + 
			"massive migration.";
	Integer dmg  ; 
	Event e ; 
	Game g; 
	Integer persen = 5; 
	Random rand = new Random();
	public static MassiveBird createThread(Event e , Game g ) {
		MassiveBird v = new MassiveBird(e ,g  );
		return v ;
	}
	public MassiveBird(Event e,Game g ) {
		this.e = e ;
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
					Integer temp1 = rand.nextInt(3)+1;
					e.getDmg(temp1);
					
					e.getMsg(msg);
					g.getHealth(temp1);
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
