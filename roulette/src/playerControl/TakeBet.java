package playerControl;

import java.util.Scanner;

import roulette.PlacedBet;
import roulette.bettingOpts.Colors;
import roulette.bettingOpts.Columns;
import roulette.bettingOpts.EvenOrOdd;

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
			System.out.println("6 --> Board Half");
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
	
	private static void execOption(Player player, Scanner in, int option) {
		String input = "";
		long amount = 0L;
		switch(option) {
		case 1:
			do {
				System.out.print("Input either even or odd --> ");
				input = in.nextLine();
			} while(!input.equalsIgnoreCase("even") || !input.equalsIgnoreCase("odd"));
			
			EvenOrOdd evenOrOddChoice = null;
			if(input.equalsIgnoreCase("even")) {
				evenOrOddChoice = EvenOrOdd.Even;
			} else {
				evenOrOddChoice = EvenOrOdd.Odd;
			}
			
			amount = getAmount(player, in);
			
			player.addBet(new PlacedBet(evenOrOddChoice, amount));
		break;
		case 2:
			do {
				System.out.print("Input either red or black --> ");
				input = in.nextLine();
			} while(!input.equalsIgnoreCase("red") || !input.equalsIgnoreCase("black"));
			
			Colors colorChoice = null;
			if(input.equalsIgnoreCase("red")) {
				colorChoice = Colors.RED;
			} else {
				colorChoice = Colors.BLACK;
			}
			
			amount = getAmount(player, in);
			
			player.addBet(new PlacedBet(colorChoice, amount));
		break;
		case 3:
			// Column
			do {
				System.out.print("Input the column, first second or third --> ");
				input = in.nextLine();
			} while(!(input.equalsIgnoreCase("first") && input.equalsIgnoreCase("second") && input.equalsIgnoreCase("third")));
			
			Columns columnChoice = null;
			if(input.equalsIgnoreCase("first")) {
				columnChoice = Columns.First;
			} else if(input.equalsIgnoreCase("second")) {
				columnChoice = Columns.Second;
			} else {
				columnChoice = Columns.Third;
			}
			
			amount = getAmount(player, in);
			
			player.addBet(new PlacedBet(columnChoice, amount));
		break;
		case 4:
			// Section
		break;
		case 5:
			// Numbers
		break;
		case 6:
			// Half
		break;
		default:
		}
	}
	
	private static long getAmount(Player player, Scanner in) {
		long amt = 0;
		
		do {
			try {
				System.out.print("Enter your bet amount --> ");
				String tmpStr = in.nextLine();
				long tmpLng = Long.parseLong(tmpStr.replaceAll("\\s+", ""));
				if(tmpLng <= 0 || !player.getCanPlaceBet(tmpLng)) {
					throw new Exception();
				} else {
					amt = tmpLng;
				}
			} catch(Exception e) {
				System.err.println("Enter a valid amount above 0");
				System.err.println("Your current balance is: "+player.getHoldingsMinusBet());
			}
			
		} while(amt == 0);
		
		return amt;
	}
}
