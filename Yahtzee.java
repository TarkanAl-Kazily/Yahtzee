/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		rgen.setSeed(1);
		IODialog dialog = getDialog();
		nPlayers = 5;
		while ((nPlayers > MAX_PLAYERS) || (nPlayers <= 0)) {
			nPlayers = dialog.readInt("Enter number of players");
		}
		players = new Player[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			players[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		 for(int rounds = 0; rounds < N_SCORING_CATEGORIES; rounds++) {
			for(int turn = 1; turn < nPlayers; turn++) {
				display.printMessage(playerNames[turn - 1] + "'s turn.");
		 		display.waitForPlayerToClickRoll(turn);
		 		int[] dice = getDice();
		 		display.displayDice(dice);
		 		display.waitForPlayerToSelectDice();
		 		display.waitForPlayerToClickRoll(turn);
		 		dice = rerollDice(dice);
		 		display.displayDice(dice);
		 		display.waitForPlayerToSelectDice();
		 		display.waitForPlayerToClickRoll(turn);
		 		dice = rerollDice(dice);
		 		display.displayDice(dice);
		 		int category = display.waitForPlayerToSelectCategory();
		 		
			}
 		}
	}
	
	private int[] getDice() {
		int[] dice = new int[5];
		for(int i = 0; i < dice.length; i++) {
			dice[i] = rgen.nextInt(1, 6);
		}
		return dice;
	}
	
	private int[] rerollDice(int[] dice) {
		int[] rerolled = new int[5];
		for(int i = 0; i < dice.length; i++) {
			if (display.isDieSelected(i)) rerolled[i] = rgen.nextInt(1, 6);
			else rerolled[i] = dice[i];
		}
		return rerolled;
	}
	
/* Private instance variables */
	private int nPlayers;
	private Player[] players;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
}
