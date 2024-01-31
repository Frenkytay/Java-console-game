import java.util.Random;

public class MassiveBat implements Runnable {
	String type = "Day";
	String msg = "The sky is filled with \r\n" + 
			"swarms of bats, covering \r\n" + 
			"the world in darkness.\r\n" + 
			"";
	Integer dmg  ; 
	Event e ;
	Game g ; 
	Integer persen = 5; 
	Random rand = new Random();
	public static MassiveBat createThread(Event e  , Game g) {
		MassiveBat v = new MassiveBat(e,g );
		return v ;
	}
	public MassiveBat(Event e,Game g) {
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
