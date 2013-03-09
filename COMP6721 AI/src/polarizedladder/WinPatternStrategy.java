/**
 * COMP6721
 * Polarized Ladder Game
 * March 2, 2013 
 */
package polarizedladder;

import java.awt.Point;

public class WinPatternStrategy 
{
	private String[][] board;
	
	private Point rightWinPatterns[][] = { 			
			{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)},			//  right ladder patterns
			{new Point(0,0), new Point(-1,0), new Point (0,1), new Point (1,1) , new Point (1,2)},
			{new Point(0,0), new Point(1,0), new Point (1,1), new Point (0,-1) , new Point (-1,-1)},
			{new Point(0,0), new Point(0,1), new Point (-1,0), new Point (-1,-1) , new Point (-2,-1)},
			{new Point(0,0), new Point(0,-1), new Point (-1,-1), new Point (-1,-2) , new Point (-2,-2)},	//	left ladder patterns
			{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)},
			{new Point(0,0), new Point(1,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
			{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (0,-1) , new Point (1,-1)},
			{new Point(0,0), new Point(0,1), new Point (1,0), new Point (1,-1) , new Point (2,-1)},
			{new Point(0,0), new Point(0,-1), new Point (1,-1), new Point (1,-2) , new Point (2,-2)},
	};
	
	public WinPatternStrategy(String[][] board) 
	{
		this.board = board;
	}
	
	//TODO: check polarity of ladder.
	//TODO: check for win block positions.
	public boolean detectRightLadder(String playerToken, Point currPoint)
	{
		String token = " ";
		boolean win  = false;
		
		for (int i = 0; i < rightWinPatterns.length; i++)
		{
			int confirmedPoints = 0;
			
			for (int j = 0; j < rightWinPatterns[0].length; j++)
			{
				int xPos = currPoint.x + rightWinPatterns[i][j].x;
				int yPos = currPoint.y + rightWinPatterns[i][j].y;
				
				try
				{
					token = board[yPos][xPos];
				}
				catch (Exception e)
				{
					// array out of bounds position
					token = " ";
				}
				
				if ( token.equalsIgnoreCase(playerToken) )
				{
					confirmedPoints++;
				}
				else
				{
					confirmedPoints = 0;
					break;
				}
			}
			
			if (confirmedPoints == 5)
			{
				win = true;
				break;
			}
		}
			
		return win;
	}
	
	public static void main(String[] args) 
	{
		Board myBoard = new Board();
		
		// right ladder test
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(2, 5, "*");
		myBoard.setPosition(2, 6, "*");
		myBoard.setPosition(3, 6, "*");
		
		/* left ladder test
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(2, 4, "*");
		myBoard.setPosition(2, 3, "*");
		myBoard.setPosition(3, 3, "*");
		*/
		
		myBoard.printBoard();
		
		WinPatternStrategy detectWin = new WinPatternStrategy( myBoard.getState() );
		boolean win = detectWin.detectRightLadder("*", new Point(6, 3) );
		
		System.out.printf("Win detected? %b\n", win);
	}

}