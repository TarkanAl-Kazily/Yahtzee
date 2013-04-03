import java.util.Arrays.*;

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
	
//	private void sort(int[] arr) {
//		for(int i = 0; i < arr.length; i++) {
//			int test = arr[i];
//			for(int j = 0; j < arr.length; j++) {
//				if (arr[j] < arr[i]) {
//					int moved = arr[j];
//					shiftArray(i, j);
//					arr[i] = moved;
//				}
//			}
//		}
//	}
	
	
	/* Precondition: Array
	 * Postcondition: An array which has arr[end] deleted,
	 * and arr[initial] is in the place of arr[initial + 1]
	 * and so on, until arr[end].
	 */
	private void shiftArray(int initial, int end) {
		for(int i = end; i > (initial + 1); i--) {
			
			
			
		}
	}
	
	private String name;
	private int[] points = new int[17];
}
