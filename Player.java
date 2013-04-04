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
		else if ((points[category] == 0)) {
			points[category] = getPoints(dice, category);
			points[YahtzeeConstants.TOTAL] = 0;
			points[YahtzeeConstants.TOTAL] = totalArr(points);
			return true;
		}
		else return false;
	}
	
	public void calculateEndCategories() {
		points[YahtzeeConstants.UPPER_SCORE] = (points[YahtzeeConstants.ONES] + points[YahtzeeConstants.TWOS] 
                                                + points[YahtzeeConstants.THREES] + points[YahtzeeConstants.FOURS]
                                                + points[YahtzeeConstants.FIVES] + points[YahtzeeConstants.SIXES]);
		if (points[YahtzeeConstants.UPPER_SCORE] >= 63) points[YahtzeeConstants.UPPER_BONUS] = 35;
		points[YahtzeeConstants.LOWER_SCORE] = (points[YahtzeeConstants.THREE_OF_A_KIND] + points[YahtzeeConstants.FOUR_OF_A_KIND]
                                                + points[YahtzeeConstants.FULL_HOUSE] + points[YahtzeeConstants.SMALL_STRAIGHT]
                                                + points[YahtzeeConstants.LARGE_STRAIGHT] + points[YahtzeeConstants.YAHTZEE] + points[YahtzeeConstants.CHANCE]);
		points[YahtzeeConstants.TOTAL] = 0;
		points[YahtzeeConstants.TOTAL] = totalArr(points);
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
		return result;
	}
	
	private int pointsThreeOfAKind(int[] arr) {
		if (numOfAKind(arr, 3)) return totalArr(arr);
		else return 0;
	}
	
	private int pointsFourOfAKind(int[] arr) {
		if (numOfAKind(arr, 4)) return totalArr(arr);
		else return 0;
	}

	private int pointsFullHouse(int[] arr) {
		if (fullHouse(arr)) return 25;
		else return 0;
	}
	
	private int pointsSmallStraight(int[] arr) {
		if (smallStraight(arr)) return 30;
		else return 0;
	}
	
	private int pointsLargeStraight(int[] arr) {
		if (largeStraight(arr)) return 40;
		else return 0;
	}
	
	private int pointsYahtzee(int[] arr) {
		if (yahtzee(arr)) return 50;
		else return 0;
	}
	
	private int pointsChance(int[] arr) {
		return totalArr(arr);
	}
	
	private boolean yahtzee(int[] arr) {
		int counter = 0;
		for(int i: arr) {
			if (i == arr[0]) counter++;
		}
		return (counter == arr.length);
	}
	
	private boolean smallStraight(int [] arr) {
		for(int i = 0; i < (arr.length - 3); i++) {
			if ((arr[i] == (arr[i+1] - 1)) && (arr[i] == (arr[i+2] - 2)) && (arr[i] == (arr[i+3] - 3))) return true;
		}
		return false;
	}
	
	private boolean largeStraight(int[] arr) {
		for(int i = 0; i < (arr.length - 4); i++) {
			if ((arr[i] == (arr[i+1] -1)) && (arr[i] == (arr[i+2] - 2)) && (arr[i] == arr[i+3] - 3)) return true;
		}
		return false;
	}
	
	private boolean fullHouse(int[] arr) {
		boolean threeOfAKind = false;
		boolean twoOfAKind = false;
		for(int i = 0; i < arr.length; i++) {
			int counter = 0;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) counter++;
			}
			if (counter == 2) {
				threeOfAKind = true;
				break;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			int counter = 0;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) counter++;
			}
			if (counter == 1) {
				twoOfAKind = true;
				break;
			}
		}
		return threeOfAKind && twoOfAKind;
	}
	
	private boolean numOfAKind(int[] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			int counter = 0;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) counter++;
			}
			if (counter >= num) {
				return true;
			}
		}
		return false;
	}
	
	private int totalArr(int[] arr) {
		int result = 0;
		for(int i : arr) {
			result += i;
		}
		return result;
	}

	public String getName() {
		return name;
	}
	
	public int getPoints(int category) {
		return points[category];
	}
	
	private String name;
	private int[] points = new int[(YahtzeeConstants.N_CATEGORIES + 1)];
}
