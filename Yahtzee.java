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
			players[i - 1] = new Player(dialog.readLine("Enter name for player " + i));
		}
		String[] playerNames = new String[nPlayers];
		for(int i = 0; i < nPlayers; i++) {
			playerNames[i] = players[i].getName();
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		 for(int rounds = 0; rounds < N_SCORING_CATEGORIES; rounds++) {
			for(int turn = 1; turn < nPlayers; turn++) {
				runTurn(turn);
			}
 		}
		display.printMessage("Game over");
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
	
	private void runTurn(int turn) {
		display.printMessage(players[turn - 1].getName() + "'s turn! Click \"Roll Dice\" to roll the dice.");
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
 		while(!players[turn - 1].scoreRoll(dice, category)) {
 			display.printMessage("Invalid category. Please choose another.");
 			category = display.waitForPlayerToSelectCategory();
 		}
 		display.updateScorecard(category, turn - 1, (players[turn - 1].getPoints(category)));
	}
	
/* Private instance variables */
	private int nPlayers;
	private Player[] players;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
}
