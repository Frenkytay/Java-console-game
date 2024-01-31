
public class Time implements Runnable{
	Integer day = 0 ; 
	String[] waktu = {"The birds are out and the sky is blue - it's morning.", "The day is half over and the light is bright - it's noon.", "The world is getting quieter and the air is getting cooler - it's dusk.", "The light is dim and the shadows are long - it's night." , "The world is dark and quiet as the shadow thrives - it's midnight.", "The darkness is fading and the sky is getting brighter - it's dawn."};
	String current = waktu[0];
	public static Time createThread() {
		Time t = new Time();
		return t ; 
	}
	public Time() {
		
	}
	int i =0  ; 
	public int getI() {
		return i ;
	}
	
	Boolean running = true ;
	@Override
	public void run() {

		while(running) {
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			current = waktu[i];
			i++ ;
			if(i%6 == 0 ) {
				i= 0 ;
				day++;
			}
			
		}
		
	}

}
