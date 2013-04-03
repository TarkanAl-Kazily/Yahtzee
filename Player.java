import java.util.Arrays;

public class Player {
	
	public Player(String name) {
		this.name = name;
	}
	
	public boolean scoreRoll(int[] dice, int category) {
		if ((category == YahtzeeConstants.UPPER_BONUS) ||
			(category == YahtzeeConstants.UPPER_SCORE) ||
			(category == YahtzeeConstants.LOWER_SCORE) ||
			(category == YahtzeeConstants.TOTAL)) return false;
		else if ((points[category] != 0)) {
			points[category] = getPoints(dice, category);
			return true;
		}
		else return false;
	}
	
	private int getPoints(int[] dice, int category) {
		Arrays.sort(dice);
		switch(category) {
		case YahtzeeConstants.ONES: return pointsSingle(dice, 1);
		case YahtzeeConstants.TWOS: return pointsSingle(dice, 2);
		case YahtzeeConstants.THREES: return pointsSingle(dice, 3);
		case YahtzeeConstants.FOURS: return pointsSingle(dice, 4);
		case YahtzeeConstants.FIVES: return pointsSingle(dice, 5);
		case YahtzeeConstants.SIXES: return pointsSingle(dice, 6);
		case YahtzeeConstants.THREE_OF_A_KIND: return pointsThreeOfAKind(dice);
		case YahtzeeConstants.FOUR_OF_A_KIND: return pointsFourOfAKind(dice);
		case YahtzeeConstants.FULL_HOUSE: return pointsFullHouse(dice);
		case YahtzeeConstants.SMALL_STRAIGHT: return pointsSmallStraight(dice);
		case YahtzeeConstants.LARGE_STRAIGHT: return pointsLargeStraight(dice);
		case YahtzeeConstants.YAHTZEE: return pointsYahtzee(dice);
		case YahtzeeConstants.CHANCE: return pointsChance(dice);
		default: return 0;
		}
	}
		
	private int pointsSingle(int[] arr, int num) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				result += num;
			}
		}
		return num;
	}
	
	private int pointsNumOfAKind(int[] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			int counter = 0;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) counter++;
			}
			if (counter >= num) {
				break;
			}
		}
	}
	
	private int totalArr(int[] arr) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	private String name;
	private int[] points = new int[YahtzeeConstants.N_CATEGORIES];
}
