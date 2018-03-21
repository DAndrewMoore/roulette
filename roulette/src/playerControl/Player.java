package playerControl;

import java.util.ArrayList;
import java.util.List;

import roulette.PlacedBet;

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
	
	public long getHoldingsMinusBet() {
		return holdings - currentBetAmount;
	}
	
	public boolean getCanPlaceBet(long amt2bet) {
		return holdings >= amt2bet;
	}
	
	public boolean getCanBet() {
		return (holdings - currentBetAmount) >= 0;
	}
	
	public void updateHoldings(long updateVal) {
		holdings += updateVal;
	}
	
	public void resetBets() {
		placedBet = new ArrayList<>();
		currentBetAmount = 0;
	}
	
	public void addBet(PlacedBet pb) {
		placedBet.add(pb);
		currentBetAmount += pb.getBetAmount();
	}
	
	public String toString() {
		return name+" has $"+holdings;
	}
	
	public boolean equals(int uuid) {
		return this.uuid == uuid;
	}
}
