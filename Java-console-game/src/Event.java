

public class Event implements Runnable {
	String type ;
	static String msg = " ";
	static Integer dmg ; 
	Time t ;
	public static Event createThread(Time t ) {
		Event e = new Event(t);
		return e ;
	}
	public synchronized void getMsg(String s ) {
		msg = s ; 
	}
	public synchronized void getDmg(int  d ) {
		dmg = d ; 
	}
	public Event(Time t ) {
		this.t = t ; 
		// TODO Auto-generated constructor stub
	}
	Boolean running = true ;
	@Override
	public void run() {
		while(running) {
			if(t.getI() < 3) {
				BloodMoon.paused = true;
				MassiveBat.paused = true;
				AlienInvasion.paused = true;
				BlackOut.paused = true ;
				MassiveEQ.paused = false ; 
				SolarEclipse.paused = false ; 
				ScorhingSun.paused = false ;
			}else {
				BloodMoon.paused = false;
				MassiveBat.paused = false;
				AlienInvasion.paused = false;
				BlackOut.paused = false ;
				MassiveEQ.paused = true ; 
				SolarEclipse.paused = true ; 
				ScorhingSun.paused = true ;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
