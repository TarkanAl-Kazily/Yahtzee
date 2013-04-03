import java.util.Arrays;

public class Player {
	
	public Player(String name) {
		this.name = name;
	}
	
	public static void initializeScores() {
		for(int i = 0; i < YahtzeeConstants.N_CATEGORIES; i++) {
			for(int j = 0; j < YahtzeeConstants.N_DICE; j++) {
				
			}
		}
	}
	
	public boolean scoreRoll(int[] dice, int category) {
		if (points[category] != 0) {
			points[category] = getPoints(dice, category);
			return true;
		}
		else return false;
		}
	
	public int getPoints(int[] dice, int category) {
		Arrays.sort(dice);
		
		
		
	}
	
	private String name;
	private int[] points = new int[17];
	private static int[][][] scores = new int[YahtzeeConstants.N_CATEGORIES][YahtzeeConstants.N_DICE][1];
}
