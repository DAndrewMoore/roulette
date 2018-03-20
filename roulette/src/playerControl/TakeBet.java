package playerControl;

import java.util.Scanner;

public class TakeBet {
	
	public static void takeBetsFromCurrentPlayer(Player player, Scanner in) {
		int curOptSelect = -1;
		do {
			System.out.println("Select the betting option");
			System.out.println("1 --> Even or Odd");
			System.out.println("2 --> Red or Black");
			System.out.println("3 --> Column Number");
			System.out.println("4 --> Section Number");
			System.out.println("5 --> Specific Numbers");
			System.out.println("0 --> Finish Betting");
			System.out.print("==>");
			try {
				curOptSelect = Integer.parseInt(in.nextLine());
				if(curOptSelect < 0 || curOptSelect > 5) {
					throw new Exception();
				} else {
					execOption(player, in, curOptSelect);
				}
			} catch(Exception e) {
				System.err.println("Enter a number between 0 and 5");
			}
			
		} while(curOptSelect != 0);
	}
	
	public static void execOption(Player player, Scanner in, int option) {
		switch(option) {
		case 1:
		break;
		case 2:
		break;
		case 3:
		break;
		case 4:
		break;
		case 5:
		break;
		default:
		}
	}
}
