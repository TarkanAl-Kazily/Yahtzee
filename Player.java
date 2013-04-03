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
		sort(dice);
		
	}
	
	private void sort(int[] arr) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			int test = arr[i];
			for(int j = 0; j < arr.length; j++) {
				
			}
		}
	}
	
	private String name;
	private int[] points = new int[17];
}
