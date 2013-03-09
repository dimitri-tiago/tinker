/**
 * COMP6721
 * Polarized Ladder Game
 * March 2, 2013 
 */
package polarizedladder;

import java.util.Scanner;

public class PLGame {

	/**
	 * main method executes polarized ladder game
	 * @param args n/a
	 */
	public static void main(String[] args) {

		int gameType = displayMainMenu();
		
		if (gameType == 1) {
			
			// human vs human
			
			Board board = new Board();
			
			Player [] players = new Player[2];	// instantiate human players
			players[0] = new Player("Player One", 'o', 22, board);
			players[1] = new Player("Player Two", Character.toChars(8226)[0], 22, board);
			
			startGame(board, players);
			
		} else if (gameType == 4) {
			
			// quit game
			
		} else {
			
			System.out.println("Game type not availabe at this time.");
		}
	}
	
	private static void startGame(Board board, Player [] players) {
		
		boolean gameOver 	= false;	
		int playerTurn 		= 1;
		
		while (!gameOver) {
	
			board.printBoard();				// display board state
			
			// TODO: add win condition check
			if (board.isBoardFull()) {		// check win condition or draw
				
				System.out.printf("The game ended in a draw!\n");
				gameOver = true;
			}
			
			if (playerTurn == 1) {			// player turn
				
				doPlayerTurn(players[0]);
				playerTurn = 2;
			
			} else {
			
				doPlayerTurn(players[1]);
				playerTurn = 1;
			}
		}
		
		System.out.printf("Game over!\n");
	}
	
	private static void doPlayerTurn(Player player) {
		
		System.out.printf("Please enter your next move %s (ex. 5A):", player.getPlayerName());
		
		Scanner input 		= new Scanner(System.in);	// command line input scanner
		String playerMove 	= input.nextLine();
		
		String rowTemp 	= playerMove.substring(0,1);
		int row 		= Integer.parseInt(rowTemp);
		char [] colTemp = playerMove.toUpperCase().toCharArray();
		int col 		= Character.getNumericValue( colTemp[1] ) - 9;
		
		if ( player.setDisc(row, col) == false) {
			
			doPlayerTurn(player);
		}
	}
	
	private static int displayMainMenu() {
		
		System.out.println("Welcome to the Polarized Ladders Game!");			
		System.out.println("Please select game type:");
		System.out.println("(1) Human vs Human");
		System.out.println("(2) Human vs AI");
		System.out.println("(3) AI vs Human");
		System.out.println("(4) Quit!");
		
		Scanner input 	= new Scanner(System.in);	// command line input scanner
		return input.nextInt();
	}
}
