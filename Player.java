import java.util.Arrays;

public class Player {
	
	public Player(String name) {
		this.name = name;
	}
	
	public static void initializeScores() {
		int[][] dice = new int[252][5];
		for(int i = 0; i < YahtzeeConstants.N_DICE; i++) {
			
		}
		
		
		for(int category = 0; category < YahtzeeConstants.N_CATEGORIES; category++) {
			for(int diceCombo = 0; diceCombo < YahtzeeConstants.N_DICE; diceCombo++) {
				
			}
		}
	}
	
	public boolean scoreRoll(int[] dice, int category) {
		if ((points[category] != 0)) {
			points[category] = getPoints(dice, category);
			return true;
		}
		else return false;
		}
	
	public int getPoints(int[] dice, int category) {
		Arrays.sort(dice);
		
		
		
	}
	
	private String name;
	private int[] points = new int[YahtzeeConstants.N_CATEGORIES];
	private static int[][][] scores = new int[YahtzeeConstants.N_CATEGORIES][YahtzeeConstants.N_DICE][1];
}
