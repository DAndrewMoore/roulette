package roulette;

import roulette.bettingOpts.BetOptions;
import roulette.bettingOpts.Colors;
import roulette.bettingOpts.Columns;
import roulette.bettingOpts.EvenOrOdd;
import roulette.bettingOpts.Halves;
import roulette.bettingOpts.Sections;

public class PlacedBet {
	// Fields used with every bet
	private BetOptions betCategory;
	private long amount;
	
	// Optional Fields
	private int[] chosenNumbers;
	private Colors chosenColor;
	private Columns column;
	private Sections section;
	private Halves half;
	private EvenOrOdd evenOrOdd;
	
	
	public PlacedBet(Colors color, long amt) {
		this.betCategory = BetOptions.Color;
		this.chosenColor = color;
		this.amount = amt;
	}
	
	public PlacedBet(int[] chosenNumbers, long amt) {
		this.betCategory = BetOptions.SpecificNumbers;
		this.chosenNumbers = chosenNumbers;
		this.amount = amt;
	}
	
	public PlacedBet(Columns column, long amt) {
		this.betCategory = BetOptions.ColomnNumber;
		this.column = column;
		this.amount = amt;
	}
	
	public PlacedBet(Sections section, long amt) {
		this.betCategory = BetOptions.SectionNumber;
		this.section = section;
		this.amount = amt;
	}
	
	public PlacedBet(Halves half, long amt) {
		this.betCategory = BetOptions.Half;
		this.half = half;
		this.amount = amt;
	}
	
	public PlacedBet(EvenOrOdd eOo, long amt) {
		this.betCategory = BetOptions.EvenOrOdd;
		this.evenOrOdd = eOo;
		this.amount = amt;
	}
	
	public long getBetAmount() {
		return amount;
	}
	
	public int returnResult(int[] outcome) {
		int total = 0;
		
		
		
		return total;
	}
}
