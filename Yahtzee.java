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
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
			players.add(new Player(playerNames[i-1]));
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		 for(int rounds = 0; rounds < N_SCORING_CATEGORIES; rounds++) {
			for(int turn = 1; turn < nPlayers; turn++) {
				display.printMessage(playerNames[turn - 1] + "'s turn.");
		 		display.waitForPlayerToClickRoll(turn);
			}
 		}
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private ArrayList<Player> players = new ArrayList<Player>();
}
