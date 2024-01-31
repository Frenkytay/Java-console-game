
public class Display implements Runnable {
	Game g ;
	Time t ; 
	Event event ;
	public static Display createThread(Game g , Time t , Event e) {
		Display d  = new Display(g, t, e );
		return d ; 
	}
	public Display(Game g , Time t , Event event) {
		this.g = g ; 
		this.t = t ;
		this.event = event;
		
	}
	Boolean running = true ; 
	void cls() {
		for(int i =0 ; i < 30 ; i++) {
			System.out.println("");
		}
	}
	Event e = Event.createThread(t);
	@Override
	public void run() {
		while(running) {
			view();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cls();
		}
		
		
	}
	void view() {
		System.out.printf("Day : %d\n",t.day );
		System.out.println("__________________________");
		System.out.printf("%s\n", t.current);
		if(e.msg.equals(" ")) {
		}else {
			System.out.printf("%s\n", e.msg);
			if(e.dmg > 0) {
				
			
			System.out.printf("Get demage : %d\n", e.dmg);
			
			}
		}
		System.out.printf("Health : [ ");
		int health = g.health / 5 ; 
		for(int i = 0 ; i < 20 ; i++) {
			if(i < health) {
				System.out.printf("| ");
			}else {
				System.out.printf("  ");
			}
		}
		System.out.printf(" ](%d)\n" , g.health);
		System.out.printf("Hunger : [ ");
		int hunger = g.hunger / 5 ; 
		for(int i = 0 ; i < 20 ; i++) {
			if(i < hunger) {
				System.out.printf("| ");
			}else {
				System.out.printf("  ");
			}
		}
		System.out.printf(" ](%d)\n", g.hunger);
		System.out.printf("Thirst : [ ");
		int thrist = g.thirst / 5 ; 
		for(int i = 0 ; i < 20 ; i++) {
			if(i < thrist) {
				System.out.printf("| ");
			}else {
				System.out.printf("  ");
			}
		}
		System.out.printf(" ](%d)\n", g.thirst);
		System.out.printf("Shelter :[ ");
		int shelter = g.shelter / 5 ; 
		for(int i = 0 ; i < 20 ; i++) {
			if(i < shelter) {
				System.out.printf("| ");
			}else {
				System.out.printf("  ");
			}
		}
		System.out.printf(" ](%d)\n",g.shelter);
		System.out.println("");
		System.out.println("Resource:");
		System.out.println("-Wood : "+ g.wood);
		System.out.println("-Food : "+ g.food);
		System.out.println("-Water: "+ g.water);
		System.out.println("-Herb : "+ g.herb);
		if(e.dmg == -1 ) {
			System.out.println("1.Build Shelter");
			System.out.println("2.Consume Food");
			System.out.println("3.Drink Water");
			System.out.println("4.Use Herbs");
			System.out.println("5.Gather Wood");
			System.out.println("6.Hunt for food");
			System.out.println("7.Gather herbs");
		}else if( e.dmg == -2 ) {
			System.out.println("1.Build Shelter");
			System.out.println("2.Consume Food");
			System.out.println("3.Drink Water");
			System.out.println("4.Use Herbs");
			System.out.println("5.Hunt for food");
		}else {
			System.out.println("1.Gather Wood");
			System.out.println("2.Build Shelter");
			System.out.println("3.Hunt for food");
			System.out.println("4.Consume food");
			System.out.println("5.collect Water");
			System.out.println("6.Drink Water");
			System.out.println("7.Gather Herbs");
			System.out.println("8.Use Herbs");
		}
	}

}
