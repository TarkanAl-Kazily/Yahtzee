public class Player {
	
	public Player(String name) {
		this.name = name;
	}
	
	public void scoreRoll(int[] dice, int category) {
		if (points[category] != 0) {
			
		}
		points[category] = getPoints(dice, category);
		}
	
	public int getPoints(int[] dice, int category) {
		
	}
	
	private String name;
	private int[] points = new int[17];
}
