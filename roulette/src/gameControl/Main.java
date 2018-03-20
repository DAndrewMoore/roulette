package gameControl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import playerControl.Player;
import playerControl.PlayerSetup;
import roulette.Table;

public class Main {
	
	private static final Scanner in = new Scanner(System.in);
	private static final Table tbl = new Table();

	public static void main(String[] args) throws Exception {
		int[] x = tbl.getResults(0);
		System.out.println(Arrays.toString(x));
	}
	
	public static void driver() {
		List<Player> playerList = PlayerSetup.createListOfPlayers(in);
		while(!playerList.isEmpty()) {
			for(Player curPlayer : playerList) {
				
			}
		}
	}
	
	
}
