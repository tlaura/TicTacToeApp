package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApp {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		allows for continuous game:
		boolean doYouWantToPlay = true;
		while(doYouWantToPlay) {
			System.out.println("Welcome to Tic Tac Toe!\n You must pick which character you want to be"
					+ "and which character the computer will be.");
		}
		
	}
}
