package tictactoeapplication;

/* For storage: 
 *(for user board is numbered 1 to 9)
 *  0 | 1 | 2 
 * -----------
 *  3 | 4 | 5 
 * -----------
 *  6 | 7 | 8 
 * */


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
	
//	See who's turn it is:
	public boolean playTurn(int spot) {
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		if(isValid) {
			board[spot-1] = currentMarker;
			currentMarker = (currentMarker == userMarker) ? computerMarker : userMarker;
		}
		return isValid;
	}
	
	
//	Check if spot is in range of board
	public boolean withinRange(int num) {
		return num > 0 && num < board.length + 1;
	}
	
//	Check if spot on board is taken
	public boolean isSpotTaken(int num) {
		return board[num-1] != '-';
	}
	
	
	public void printBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if(i%3==0 && i != 0) {
				System.out.println();
				System.out.println("-----------");
			}
			System.out.println(" | " + board[i]);
		}
		System.out.println();
	}
	
//	Show user how to input their data
	public void printIndexBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if(i%3==0 && i != 0) {
				System.out.println();
				System.out.println("-----------");
			}
			System.out.println(" | " + (i+1));
		}
		System.out.println();
	}
	
	public boolean isThereAWinner() {
//		Check if 3 identical tokens connected on board
		boolean diagonalsAndMiddleWin = rightDi() || leftDi() || middleRow() || secondCol() && board[4] != '-';
		boolean topAndFirst = topRow() || firstCol() && board[0] != '-';
		boolean bottomAndThird = bottomRow() || thirdCol() && board[8] != '-';
		
//		If we have a winner, the winner token is at common spot
		if(diagonalsAndMiddleWin) {
			this.winner = board[4];
		} else if(topAndFirst) {
			this.winner = board[0];
		} else if(bottomAndThird) {
			this.winner = board[8];
		}
		
//		If no one is winner it returns false
		return diagonalsAndMiddleWin || topAndFirst || bottomAndThird;
	}
	
	public boolean topRow() {
		return board[0] == board[1] && board[1] == board[2];
	}
	
	public boolean firstCol() {
		return board[0] == board[3] && board[3] == board[6];
	}
	
	public boolean middleRow() {
		return board[4] == board[5] && board[5] == board[6];
	}
	
	public boolean secondCol() {
		return board[1] == board[4] && board[4] == board[7];
	}
	
	public boolean leftDi() {
		return board[2] == board[4] && board[4] == board[6];
	}
	
	public boolean rightDi() {
		return board[0] == board[4] && board[4] == board[8];
	}
	
	public boolean bottomRow() {
		return board[6] == board[7] && board[7] == board[8];
	}
	
	public boolean thirdCol() {
		return board[2] == board[5] && board[5] == board[8];
	}
	
	
	public boolean isTheBoardFilled() {
		for (int i = 0; i < board.length; i++) {
			if(board[i] == '-') {
				return false;
			}
		}
		return true;
	}
	
	public String gameOver() {
		boolean didSomeoneWin = isThereAWinner();
		if(didSomeoneWin) {
			return "The winner is: " + this.winner;
		} else if (isTheBoardFilled()) {
			return "Draw: Game Over!";
		} else {
			return "notOver";
		}
	}
	
}
