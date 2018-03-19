package gameControl;

import java.util.List;
import java.util.Scanner;

import playerControl.Player;
import playerControl.PlayerSetup;

public class Main {
	
	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		driver();
	}
	
	public static void driver() {
		List<Player> playerList = PlayerSetup.createListOfPlayers(in);
		System.out.println();
		for(Player player : playerList) {
			System.out.println(player);
		}
	}
	
	
}
