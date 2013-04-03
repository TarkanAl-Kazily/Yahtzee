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
	
	public int getPoints(int[] dice, int category) {
		Arrays.sort(dice);
		switch(category) {
		case YahtzeeConstants.ONES: return pointsOnes(dice);
		case YahtzeeConstants.TWOS: return pointsTwos(dice);
		case YahtzeeConstants.THREES: return pointsThrees(dice);
		}
	}
	
	private String name;
	private int[] points = new int[YahtzeeConstants.N_CATEGORIES];
}
