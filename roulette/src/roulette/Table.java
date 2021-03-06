package roulette;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import roulette.bettingOpts.BetOptions;
import roulette.bettingOpts.Colors;

public class Table {
	
	private Set<Integer> redColorSet = new HashSet<>();
	private Set<Integer> blackColorSet = new HashSet<>();
	
	private SecureRandom random = new SecureRandom();
	
	/**
	 * Default constructor for the table
	 */
	public Table() {
		redColorSet.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36}));
		blackColorSet.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35}));
	}
	
	public int getRandomNumber() {
		int randomNum = -1;
		byte[] randBytes = new byte[7];
		random.nextBytes(randBytes);
		for(int i=0; i<7; i++) {
			randomNum += (randomNum << 8) + (randBytes[i] & 0xff);
		}
		return Math.abs(randomNum % 37);
	}
	
	/**
	 * Returns the results of a given number. 
	 * <br>Results are in the order of:<br>
	 * - Section Number (0, 1, 2, 3)<br>
	 * - Halve Number (0, 1, 2)<br>
	 * - Color Number (0=NA, 1=Red, 2=Black)<br>
	 * - Column Number (0, 1, 2, 3) (-1 Offset)<br>
	 * - Even/Odd (-1, 0=Even, 1=Odd)<br>
	 * 
	 * @param numLandedOn - The number the ball landed on
	 * @return Result array corresponding to the number that was landed on
	 * @throws Exception If the number is out of bounds for the board
	 */
	public HashMap<BetOptions, Integer> getResults(final int numLandedOn) throws Exception {
		if(numLandedOn < 0 || numLandedOn > 36) {
			throw new Exception("Invalid number given");
		}
		
		HashMap<BetOptions, Integer> results = new HashMap<>();
		results.put(BetOptions.SectionNumber, getSection(numLandedOn));
		results.put(BetOptions.Half, getCurrentHalf(numLandedOn));
		results.put(BetOptions.Color, getColor(numLandedOn).ordinal());
		results.put(BetOptions.ColumnNumber, getColumnNum(numLandedOn));
		results.put(BetOptions.EvenOrOdd, getEvenOrOdd(numLandedOn));
		
		return results;
	}
	
	/**
	 * Gets the sections (Zeroth, First, Second, Third)
	 * 
	 * @param num - The number to check
	 * @return the section number
	 */
	private int getSection(final int num) {
		return (int) Math.ceil(num / 12.);
	}
	
	/**
	 * Gets the half of the board the number is on
	 * 
	 * @param num - The number to check
	 * @return the half of the board (or zero if num == 0)
	 */
	private int getCurrentHalf(final int num) {
		return (int) Math.ceil(num / 18.);
	}
	
	/**
	 * Gets the color of the number rolled
	 * 
	 * @param num - The number to check
	 * @return The color of the number
	 */
	private Colors getColor(final int num) {
		if(num == 0) {
			return Colors.NA;
		} else if(redColorSet.contains(num)) {
			return Colors.RED;
		} else {
			return Colors.BLACK;
		}
	}
	
	/**
	 * Gets the column number of the number rolled (zero indexed)
	 * 
	 * @param num - The number to check
	 * @return The column of the number
	 */
	private int getColumnNum(final int num) {
		if(num == 0) {
			return -1;
		} else {
			return ((num-1) % 3);
		}
	}
	
	/**
	 * Gets whether the number is even or odd
	 * 
	 * @param num - The number to check
	 * @return The evenness or oddness of the number (or -1 if 0)
	 */
	private int getEvenOrOdd(final int num) {
		if(num == 0) {
			return -1;
		} else {
			return num % 2;
		}
	}
}
