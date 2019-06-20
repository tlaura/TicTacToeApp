package tictactoeapplication;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
//	Pick random location on board:
	public int pickSpot(TicTacToe game) {
		ArrayList<Integer> choices = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
//			if slot not taken add it as choice
			if(game.board[i] == '-') {
				choices.add(i+1);
			}
		}
		Random random = new Random();
//		pick a random index between 0 and the number of choices we have
		int choice = choices.get(Math.abs(random.nextInt()%choices.size()));
		return choice;
	}
}
