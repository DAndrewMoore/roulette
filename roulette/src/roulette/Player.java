package roulette;

public class Player {

	private int holdings = 0;
	
	public Player(int holdings) {
		this.holdings = holdings;
	}
	
	public int getHoldings() {
		return holdings;
	}
	
	public void updateHoldings(int updateVal) {
		holdings += updateVal;
	}
}
