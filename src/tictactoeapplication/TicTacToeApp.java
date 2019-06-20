package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApp {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		Allows for continuous game:
		boolean doYouWantToPlay = true;
		while(doYouWantToPlay) {
//			Setting up tokens
			System.out.println("Welcome to Tic Tac Toe!\n ");
			System.out.println();
			System.out.println("Enter a single character that will represent you on the board: ");
			char playerToken = scan.next().charAt(0);
			System.out.println("Enter a single character that will represent the computer on the board: ");
			char computerToken = scan.next().charAt(0);
			
			TicTacToe game = new TicTacToe(playerToken, computerToken);
			Computer cpu = new Computer();
			
//			Set up game
			System.out.println();
			System.out.println("The numbers on the board go from 1 to 9, left to right.\n"
					+ "To play, enter a number: ");
			TicTacToe.printIndexBoard();
			
			System.out.println();
//			Until game is over
			while(game.gameOver().equals("notOver")) {
				if(game.currentMarker == game.userMarker) {
//					User's turn
					System.out.println("It's your turn! Enter a spot for your token: ");
					int spot = scan.nextInt();
//					while we cannot play the turn
					while(!game.playTurn(spot)) {
						System.out.println("Try again. " 
								+ spot + " is already taken or out of range.");
						spot = scan.nextInt();
					}
					System.out.println("You picked " + spot + "!");
				} else {
//				Cpu's turn 
					System.out.println("Computer's turn!");
//					Pick a random spot 
					int cpuSpot = cpu.pickSpot(game);
					game.playTurn(cpuSpot);
					System.out.println("Computer picked " + cpuSpot + "!");
				}
//				Print out new board
				System.out.println();
				game.printBoard();
			}
			System.out.println();
			System.out.println(game.gameOver());
			System.out.println();
//			Set up a new game or quit game
			System.out.println("Do you want to play again?\n"
					+ "Enter 'y if you do, or anything else if not.");
			char response = scan.next().charAt(0);
			doYouWantToPlay = (response == 'y');
			System.out.println();
			System.out.println();
		}
		scan.close();
	}
}
