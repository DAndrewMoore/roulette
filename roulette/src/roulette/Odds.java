package roulette;

/**
 * Represents the odds of a certain bet
 * 
 * @author andrew
 * @since 0.0
 */
public class Odds {
	
	/**
	 * Red VS Black
	 */
	public static final long colorWin = 1;
	
	/**
	 * Even or Odd
	 */
	public static final long evenOrOddWin = 1;
	
	/**
	 * Within first or last half of numbers (not respective of name)
	 */
	public static final long highLowWin = 1;
	
	/**
	 * Line of 12 numbers
	 */
	public static final long columnWin = 2;
	
	/**
	 * On the first, middle, or last section
	 */
	public static final long sectionWin = 2;
		
	/**
	 * On one number
	 */
	public static final long straightNumber = 35;
}
