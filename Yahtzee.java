/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
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
			for(int turn = 1; turn <= nPlayers; turn++) {
				runTurn(turn);
			}
 		}
		for(int p = 0; p < nPlayers; p++) {
			players[p].calculateEndCategories();
			display.updateScorecard(YahtzeeConstants.UPPER_SCORE, p + 1, players[p].getPoints(YahtzeeConstants.UPPER_SCORE));
			display.updateScorecard(YahtzeeConstants.UPPER_BONUS, p + 1, players[p].getPoints(YahtzeeConstants.UPPER_BONUS));
			display.updateScorecard(YahtzeeConstants.LOWER_SCORE, p + 1, players[p].getPoints(YahtzeeConstants.LOWER_SCORE));
			display.updateScorecard(YahtzeeConstants.TOTAL, p + 1, players[p].getPoints(YahtzeeConstants.TOTAL));
		}
		int maxPoints = 0;
		String winner = "";
		for(Player p : players) {
			if (p.getPoints(YahtzeeConstants.TOTAL) >= maxPoints) {
				maxPoints = p.getPoints(YahtzeeConstants.TOTAL);
				winner = p.getName();
			}
		}
		display.printMessage("Congratulations, " + winner + ", you're the winner with a total score of " + maxPoints + "points!");
	}
	
	private int[] getDice() {
		int[] dice = new int[5];
		for(int i = 0; i < dice.length; i++) {
			dice[i] = rgen.nextInt(1, 6);
		}
		int[] test = {1, 2, 2, 3, 4};
		return test;
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
 		display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\".");
 		display.waitForPlayerToSelectDice();
 		dice = rerollDice(dice);
 		display.displayDice(dice);
 		display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\".");
 		display.waitForPlayerToSelectDice();
 		dice = rerollDice(dice);
 		display.displayDice(dice);
 		display.printMessage("Select a category for this roll.");
 		int category = display.waitForPlayerToSelectCategory();
 		while(!players[turn - 1].scoreRoll(dice, category)) {
 			display.printMessage("Invalid category. Please choose another.");
 			category = display.waitForPlayerToSelectCategory();
 		}
 		display.updateScorecard(category, turn, (players[turn - 1].getPoints(category)));
 		display.updateScorecard(YahtzeeConstants.TOTAL, turn, (players[turn - 1].getPoints(YahtzeeConstants.TOTAL)));
	}
	
/* Private instance variables */
	private int nPlayers;
	private Player[] players;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
}
