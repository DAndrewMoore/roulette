package gameControl;

import java.util.List;
import java.util.Scanner;

import playerControl.Player;
import playerControl.PlayerSetup;
import playerControl.TakeBet;
import roulette.Table;

public class Main {
	
	private static final Scanner in = new Scanner(System.in);
	private static final Table tbl = new Table();

	public static void main(String[] args) throws Exception {
		
	}
	
	public static void driver() {
		List<Player> playerList = PlayerSetup.createListOfPlayers(in);
		while(!playerList.isEmpty()) {
			for(int curPlayerIdx=0; curPlayerIdx < playerList.size(); curPlayerIdx++) {
				Player curPlayer = playerList.get(curPlayerIdx);
				if(curPlayer.getCanBet()) {
					TakeBet.takeBetsFromCurrentPlayer(curPlayer, in);
				} else {
					playerList.remove(curPlayerIdx);
					curPlayerIdx--;
				}
			}
		}
	}
	
	
}
