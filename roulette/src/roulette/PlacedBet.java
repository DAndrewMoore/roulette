package roulette;

import roulette.bettingOpts.BetOptions;
import roulette.bettingOpts.Colors;
import roulette.bettingOpts.Columns;
import roulette.bettingOpts.Sections;

public class PlacedBet {
	// Fields used with every bet
	private BetOptions betCategory;
	private long amount;
	
	// Optional Fields
	private int chosenNumber;
	private int[] chosenNumbers;
	private Colors chosenColor;
	private Columns column;
	private Sections section;
	
	
	public PlacedBet(BetOptions category, int chosenNumber, long amt) {
		this.betCategory = category;
		this.chosenNumber = chosenNumber;
		this.amount = amt;
	}
	
	public PlacedBet(BetOptions category, Colors color, long amt) {
		this.betCategory = category;
		this.chosenColor = color;
		this.amount = amt;
	}
	
	public PlacedBet(BetOptions category, int[] chosenNumbers, long amt) {
		this.betCategory = category;
		this.chosenNumbers = chosenNumbers;
		this.amount = amt;
	}
	
	public PlacedBet(BetOptions category, Columns column, long amt) {
		this.betCategory = category;
		this.column = column;
		this.amount = amt;
	}
	
	public PlacedBet(BetOptions category, Sections section, long amt) {
		this.betCategory = category;
		this.section = section;
		this.amount = amt;
	}
	
	public int returnResult(int[] outcome) {
		int total = 0;
		
		
		
		return total;
	}
}
