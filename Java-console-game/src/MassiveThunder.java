import java.util.Random;

public class MassiveThunder implements Runnable{
	String type = "Neutral";
	String msg = "The sky is dark and \r\n" + 
			"lightning is striking \r\n" + 
			"everywhere - a massive \r\n" + 
			"thunderstorm is raging!\r\n";
	Integer dmg  ; 
	Event e ; 
	Game g ;
	Integer persen = 5; 
	Random rand = new Random();
	public static MassiveThunder createThread(Event e , Game g ) {
		MassiveThunder v = new MassiveThunder(e , g );
		return v ;
	}
	public MassiveThunder(Event e , Game g ) {
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
					Integer temp1 = rand.nextInt(4)+3;
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
