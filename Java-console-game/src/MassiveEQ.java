import java.util.Random;

public class MassiveEQ  implements Runnable{
	String type = "Day";
	String msg = "The ground is shaking \r\n" + 
			"violently and buildings are \r\n" + 
			"collapsing - a massive \r\n" + 
			"earthquake is underway!";
	Integer dmg  ; 
	Event e ; 
	Game g; 
	Integer persen = 5; 
	Random rand = new Random();
	public static MassiveEQ createThread(Event e ,Game g) {
		MassiveEQ v = new MassiveEQ(e , g  );
		return v ;
	}
	public MassiveEQ(Event e ,Game g) {
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
