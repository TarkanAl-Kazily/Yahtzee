import java.util.Arrays;

public class Player {
	
	public Player(String name) {
		this.name = name;
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
	private static int[][][] scores = new int[17][5][1];
}
