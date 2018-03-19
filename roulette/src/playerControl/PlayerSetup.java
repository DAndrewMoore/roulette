package playerControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerSetup {
	
	public static List<Player> createListOfPlayers(final Scanner in) {
		int numPlayers = getNumberOfPlayers(in);
		List<Player> players = new ArrayList<Player>(numPlayers);
		for(int i=0; i<numPlayers; i++) {
			String name = getPlayerName(in);
			long wallet = getPlayerStartWallet(in);
			players.add(new Player(name, wallet, (long) i));
		}
		
		return players;
	}
	
	private static int getNumberOfPlayers(final Scanner in) {
		int num = 0;
		do {
			try {
				System.out.print("Please enter the number of players ==> ");
				num = in.nextInt();
				in.nextLine();
			} catch(Exception e) {
				System.err.println("Please enter a numeric amount");
			}
		} while(num == 0);
		
		return num;
	}
	
	private static String getPlayerName(final Scanner in) {
		String name = "";
		do {
			System.out.print("Please enter your player name ==> ");
			name = in.nextLine();
		} while(name.length() == 0);
		
		return name;
	}
	
	private static long getPlayerStartWallet(final Scanner in) {
		long amt = 0L;
		do {
			try {
				System.out.print("Please enter your starting wallet ammount ==> ");
				amt = in.nextLong();
				in.nextLine();
			} catch(Exception e) {
				System.err.println("Please enter a numeric amount");
			}
			
		} while(amt == 0L);
		
		return amt;
	}
}
