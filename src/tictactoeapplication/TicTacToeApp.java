package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApp {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		Allows for continuous game:
		boolean doYouWantToPlay = true;
		while(doYouWantToPlay) {
			System.out.println("Welcome to Tic Tac Toe!\n ");
			System.out.println();
			System.out.println("Enter a single character that will represent you on the board: ");
			char playerToken = scan.next().charAt(0);
			System.out.println("Enter a single character that will represent the computer on the board: ");
			char computerToken = scan.next().charAt(0);
			
			TicTacToe game = new TicTacToe(playerToken, computerToken);
			Computer cpu = new Computer();
		}
		
	}
}
