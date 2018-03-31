package gameControl;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import playerControl.Player;
import playerControl.PlayerSetup;
import playerControl.TakeBet;
import roulette.Table;
import roulette.bettingOpts.BetOptions;

public class Main {
	
	private static final Scanner in = new Scanner(System.in);
	private static final Table tbl = new Table();

	public static void main(String[] args) throws Exception {
		
	}
	
	public static void driver() throws Exception {
		List<Player> playerList = PlayerSetup.createListOfPlayers(in);
		while(!playerList.isEmpty()) {
			// Take bets from current players
			for(int curPlayerIdx=0; curPlayerIdx < playerList.size(); curPlayerIdx++) {
				Player curPlayer = playerList.get(curPlayerIdx);
				if(curPlayer.getCanBet()) {
					TakeBet.takeBetsFromCurrentPlayer(curPlayer, in);
				} else {
					playerList.remove(curPlayerIdx);
					curPlayerIdx--;
				}
			}
			
			// Get the random number
			int num = tbl.getRandomNumber();
			System.out.println("\nThe Rolled number is: "+num+"\n");
			
			// Calculate results
			HashMap<BetOptions, Integer> results = tbl.getResults(num);
			
			// Distribute bets
			for(int curPlayerIdx=0; curPlayerIdx < playerList.size(); curPlayerIdx++) {
				playerList.get(curPlayerIdx).distributeBetStuff(results, num);
			}
		}
	}
	
	
}
