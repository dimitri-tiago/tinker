/**
 * COMP6721
 * Polarized Ladder Game
 * March 2, 2013 
 */
//package polarizedladder;

import java.util.Scanner;

/**
 * @author dimitri.tiago
 * 
 */
public class Player {

	private int discs;			// number of discs available
	
	private String playerName;	
	private char playerToken;
	
	Board board;
	
	public Player(String playerName, char playerToken, int discs, Board board) {
		
		this.playerName 	= playerName;
		this.discs 			= discs;
		this.playerToken 	= playerToken;
		
		this.board = board;
	}
	
	public boolean setDisc(int i, int j) {
		
		return board.setPosition(i, j, String.valueOf(playerToken));
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerToken() {
		return String.valueOf(playerToken);
	}
	
	public int getDiscs() {
		return discs;
	}
}
