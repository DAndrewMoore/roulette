package playerControl;

public class Player {

	private String name = "";
	private long holdings = 0;
	private long uuid = -1;
	
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
	
	public boolean getCanPlaceBet(long amt2bet) {
		return holdings >= amt2bet;
	}
	
	public boolean getCanBet() {
		return holdings >= 0;
	}
	
	public void updateHoldings(long updateVal) {
		holdings += updateVal;
	}
	
	public String toString() {
		return name+" has $"+holdings;
	}
}
