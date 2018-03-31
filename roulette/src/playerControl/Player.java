package playerControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import roulette.PlacedBet;
import roulette.bettingOpts.BetOptions;

public class Player {

	private String name = "";
	private long holdings = 0;
	private long uuid = -1;
	private List<PlacedBet> placedBet = new ArrayList<PlacedBet>();
	private long currentBetAmount = 0;
	
	public Player(String name, long wallet, long uuid) {
		this.name = name;
		this.holdings = wallet;
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public long getHoldings() {
		return holdings;
	}
	
	public void updateCurrentBetTotal(long updateVal) {
		currentBetAmount += updateVal;
	}
	
	public boolean getCanBetAlreadyBet() {
		return (holdings - currentBetAmount) > 0;
	}
	
	public long getHoldingsMinusBet() {
		return holdings - currentBetAmount;
	}
	
	public long getCurrentBet() {
		return currentBetAmount;
	}
	
	public boolean getCanPlaceBet(long amt2bet) {
		return (holdings - currentBetAmount) >= amt2bet;
	}
	
	public boolean getCanBet() {
		return holdings > 0;
	}
	
	public void updateHoldings(long updateVal) {
		holdings += updateVal;
	}
	
	public void resetBets() {
		placedBet = new ArrayList<>();
		currentBetAmount = 0;
	}
	
	public void addBet(PlacedBet pb) {
		System.out.println("This bet's unique identifier is "+name+(placedBet.size()+1));
		placedBet.add(pb);
		currentBetAmount += pb.getBetAmount();
	}
	
	public void distributeBetStuff(HashMap<BetOptions, Integer> results, int numberRolled) {
		long total = 0;
		for(PlacedBet bet : placedBet) {
			total += bet.returnResult(results, numberRolled);
		}
		System.out.println("\n"+name);
		System.out.println("Your bet results in: $"+total);
		System.out.println("Your current holdings are: $"+(holdings+total)+"\n");
		holdings += total;
		
		resetBets();
	}
	
	public String toString() {
		return name+" has $"+holdings;
	}
	
	public boolean equals(int uuid) {
		return this.uuid == uuid;
	}
}
