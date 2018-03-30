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
	public static int colorWin = 2;
	
	/**
	 * Even or Odd
	 */
	public static int evenOrOddWin = 2;
	
	/**
	 * Within first or last half of numbers (not respective of name)
	 */
	public static int highLowWin = 2;
	
	/**
	 * Line of 12 numbers
	 */
	public static int columnWin = 3;
	
	/**
	 * On the first, middle, or last section
	 */
	public static int sectionWin = 3;
	
	/**
	 * On six numbers
	 */
	public static int lineBet = 5;
	
	/**
	 * On five numbers
	 */
	public static int fiveNum = 6;
	
	/**
	 * On four numbers
	 */
	public static int squareNum = 8;
	
	/**
	 * On three numbers
	 */
	public static int threeNum = 11;
	
	/**
	 * On two numbers
	 */
	public static int twoNumber = 17;
	
	/**
	 * On one number
	 */
	public static int straightNumber = 35;
}
