public class Player {
	
	public Player(String name) {
		this.name = name;
	}
	
	public void scoreRoll(int[] dice, int category) {
		points[category] = getPoints(dice, category);
	}
	
	private String name;
	private int[] points = new int[17];
}
