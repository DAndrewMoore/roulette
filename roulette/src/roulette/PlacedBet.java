package roulette;

import java.util.HashMap;

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
	private Long[] multiNumBetAmt;
	private String betID;
	
	// Optional Fields
	private Integer[] chosenNumbers;
	private Colors chosenColor;
	private Columns column;
	private Sections section;
	private Halves half;
	private EvenOrOdd evenOrOdd;
	
	
	public PlacedBet(Colors color, long amt, String betID) {
		this.betCategory = BetOptions.Color;
		this.chosenColor = color;
		this.amount = amt;
		this.betID = betID;
	}
	
	public PlacedBet(Integer[] chosenNumbers, Long[] amt, String betID) {
		this.betCategory = BetOptions.SpecificNumbers;
		this.chosenNumbers = chosenNumbers;
		this.multiNumBetAmt = amt;
		this.betID = betID;
	}
	
	public PlacedBet(Columns column, long amt, String betID) {
		this.betCategory = BetOptions.ColumnNumber;
		this.column = column;
		this.amount = amt;
		this.betID = betID;
	}
	
	public PlacedBet(Sections section, long amt, String betID) {
		this.betCategory = BetOptions.SectionNumber;
		this.section = section;
		this.amount = amt;
		this.betID = betID;
	}
	
	public PlacedBet(Halves half, long amt, String betID) {
		this.betCategory = BetOptions.Half;
		this.half = half;
		this.amount = amt;
		this.betID = betID;
	}
	
	public PlacedBet(EvenOrOdd eOo, long amt, String betID) {
		this.betCategory = BetOptions.EvenOrOdd;
		this.evenOrOdd = eOo;
		this.amount = amt;
		this.betID = betID;
	}
	
	public long getBetAmount() {
		return amount;
	}
	
	public long returnResult(HashMap<BetOptions, Integer> results, int numberRolled) {
		long total = 0;
		switch(betCategory) {
		case Color:
			if(chosenColor.ordinal() == results.get(betCategory)) {
				total = Odds.colorWin * amount;
			}
		break;
		case EvenOrOdd:
			if(evenOrOdd.ordinal() == results.get(betCategory)) {
				total = Odds.evenOrOddWin * amount;
			}
		break;
		case SpecificNumbers:
			for(int i=0; i<chosenNumbers.length; i++) {
				if(chosenNumbers[i] == numberRolled) {
					total += Odds.straightNumber * multiNumBetAmt[i];
				} else {
					total += -1 * multiNumBetAmt[i];
				}
			}
		break;
		case SectionNumber:
			if(section.ordinal() == results.get(betCategory)) {
				total = Odds.sectionWin * amount;
			}
		break;
		case ColumnNumber:
			if(column.ordinal() == results.get(betCategory)) {
				total = Odds.columnWin * amount;
			}
		break;
		case Half:
			if(half.ordinal() == results.get(betCategory)) {
				total = Odds.highLowWin * amount;
			}
		break;
		default:
		break;
		}
		
		if(total == 0L && betCategory != BetOptions.SpecificNumbers) {
			total = -1 * amount;
		}
		
		return total;
	}
	
	public boolean equals(String id) {
		return this.betID.equals(id);
	}
}
