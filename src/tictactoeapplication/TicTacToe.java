package tictactoeapplication;

public class TicTacToe {
	protected char[] board;
	protected char userMarker;
	protected char computerMarker;
	protected char winner;
	protected char currentMarker;
	
	public TicTacToe(char playerToken, char computerMarker) {
		this.userMarker = playerToken;
		this.computerMarker = computerMarker;
		this.winner = '-';
		this.board = setBoard();
	}
	
	public char[] setBoard() {
		char[] board = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}
	
//	see who's turn it is:
	public boolean playTurn(int spot) {
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		if(isValid) {
			board[spot-1] = currentMarker;
			currentMarker = (currentMarker == userMarker) ? computerMarker : userMarker;
		}
		return isValid;
	}
	
	
//	check if spot is in range of board
	public boolean withinRange(int num) {
		return num > 0 && num < board.length + 1;
	}
	
//	check if spot is taken
	public boolean isSpotTaken(int num) {
		return board[num-1] != '-';
	}
	
	
	public void printBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if(i%3==0 && i != 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.println(" | " + board[i]);
		}
		System.out.println();
	}
	
//	show user how to input their data
	public void printIndexBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if(i%3==0 && i != 0) {
				System.out.println();
				System.out.println("------------");
			}
			System.out.println(" | " + (i+1));
		}
		System.out.println();
	}
	
//	public boolean isThereAWinner() {
//		
//	}
}
