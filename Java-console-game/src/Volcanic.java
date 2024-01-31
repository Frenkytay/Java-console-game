import java.util.Random;

public class Volcanic implements Runnable {
	String type = "Neutral";
	String msg = "The ground is shaking and \r\n" + 
			"the sky is darkened by ash \r\n" + 
			"- a volcano has erupted!\r\n";
	Integer dmg  ; 
	Event e ; 
	Game g;
	Integer persen = 5; 
	Random rand = new Random();
	public static Volcanic createThread(Event e , Game g) {
		Volcanic v = new Volcanic(e ,g);
		return v ;
	}
	public Volcanic(Event e,Game g ) {
		this.e = e;
		this.g=  g; 
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
					Integer temp1 = rand.nextInt(4)+1;
					e.getDmg(temp1);;
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
