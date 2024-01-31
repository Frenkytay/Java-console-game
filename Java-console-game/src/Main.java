import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	File filename = new File("player.txt");
	ArrayList<String > idList = new ArrayList<>();
	ArrayList<String> passList = new ArrayList<>();
	ArrayList<Integer> scoreList = new ArrayList<>();
	void readUser() {
		try {
			Scanner readF = new Scanner(filename);
			while(readF.hasNextLine()) {
				String line = readF.nextLine();
				String[] part = line.split("#");
				idList.add(part[0]);
				passList.add(part[1]);
				scoreList.add(Integer.parseInt(part[2]));
			}
			readF.close();
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	void writeUser() {
		try (FileWriter write = new FileWriter(filename)){
			for(int i = 0 ; i < idList.size(); i++) {
				write.write(idList.get(i) + "#" + passList.get(i)+ "#" + scoreList.get(i));
			}
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	int  checkIdPass(String id , String pass) {
		for(int i = 0 ; i < idList.size(); i++) {
			if(idList.get(i).equals(id) && passList.get(i).equals(pass)) {
				return i ; 
			}
		}
		return -1 ; 
	}
	
	public Main() {
		
		int menu ; 
		Boolean homepage= false ; 
		readUser();
		do {
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Highscore");
			System.out.println("4.Exit");
			menu = scan.nextInt();scan.nextLine();
			int idx ;
			String id ; 
			String pass ;
			if(menu == 1 ) {
				//Login
				 
				System.out.println("Input Id");
				id = scan.nextLine();
				System.out.println("Input Password");
				pass = scan.nextLine();
				if((idx = checkIdPass(id, pass)) != -1) {
					homepage = true ; 
					break ;
				}else {
					homepage = false ;
					System.out.println("Creadential not found");
				}
			}else if( menu == 2 ) {
				//Register
				 
				do {
					System.out.println("Input unique username [5- 20 ]:");
					id = scan.nextLine();
				}while(idList.contains(id) || id.length() < 5 || id.length() > 20 );
				do {
					System.out.println("Input Password [8-20]");
					pass = scan.nextLine();
				}while(pass.length() < 5 || pass.length() > 20 );
				idList.add(id);
				passList.add(pass);
				scoreList.add(0);
				writeUser();
			}
			
		}while(menu != 4 );
		if(homepage) {
			Game g = Game.createThread();
			Time t = Time.createThread();
			Event event = Event.createThread(t);
			Display d = Display.createThread(g, t,event);
			Volcanic v = Volcanic.createThread(event,g);
			MassiveBird mb = MassiveBird.createThread(event, g);
			MassiveEQ mq = MassiveEQ.createThread(event, g );
			SolarEclipse se = SolarEclipse.createThread(event, g );
			ScorhingSun ss = ScorhingSun.createThread(event, g);
			BloodMoon bm = BloodMoon.createThread(event, g );
			MassiveBat mBat = MassiveBat.createThread(event, g );
			AlienInvasion ai = AlienInvasion.createThread(event, g);
			BlackOut bo = BlackOut.createThread(event, g);
			MassiveThunder mt = MassiveThunder.createThread(event,g );
			Input i = Input.createThread(g);
			
			
			Thread t1= new Thread(g);
			Thread t2 = new Thread(t);
			Thread t3 = new Thread(d);
			Thread t4 = new Thread(v);
			Thread t5 = new Thread(event);
			Thread t6 = new Thread(mb);
			Thread t7 = new Thread(mq);
			Thread t8 = new Thread(se);
			Thread t9 = new Thread(ss);
			Thread t10 = new Thread(bm);
			Thread t11 = new Thread(mBat);
			Thread t12 = new Thread(ai);
			Thread t13 = new Thread(bo);
			Thread t14 = new Thread(mt);
			Thread t15 = new Thread(i);
	 		
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			t6.start();
			t7.start();
			t8.start();
			t9.start();
			t10.start();
			t11.start();
			t12.start();
			t13.start();
			t14.start();
			t15.start();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
