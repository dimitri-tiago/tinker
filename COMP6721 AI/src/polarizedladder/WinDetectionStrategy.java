/**
 * COMP6721
 * Polarized Ladder Game
 * March 2, 2013 
 */
package polarizedladder;

import java.awt.Point;

public class WinDetectionStrategy 
{
	private String[][] board;
	
	private Point rightWinPattern[] = { new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2) };
	private Point leftWinPattern[]  = { new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2) };
	
	public WinDetectionStrategy(String[][] board) 
	{
		
		this.board = board;
	}
	
	public boolean detectRightLadder(String playerToken, Point currPoint)
	{
		Point expectedLadderPosition[] 	= new Point[5];
		
		// generate expected ladder position
		for (int i = 0; i < expectedLadderPosition.length; i++)
		{
			Point nextExpectedPoint 	= new Point(currPoint.x + rightWinPattern[i].x, currPoint.y + rightWinPattern[i].y ); 
			expectedLadderPosition[i] 	= nextExpectedPoint;
		}

		// compare expected ladder with board points
		
		int confirmedLadderPoints = 1;
		int xPos = expectedLadderPosition[0].x;
		int yPos = expectedLadderPosition[0].y;
		
		String boardMarkAtPos = board[yPos][xPos];
		
		while ( (playerToken.equalsIgnoreCase(boardMarkAtPos)) && (confirmedLadderPoints < 5) )
		{
			for (int i = 1; i < expectedLadderPosition.length; i++)
			{
				xPos = expectedLadderPosition[i].x;
				yPos = expectedLadderPosition[i].y;
				
				boardMarkAtPos = board[yPos][xPos];
				
				if ( boardMarkAtPos.equalsIgnoreCase(playerToken) )
				{
					confirmedLadderPoints++;
				}
				else
				{
					/*
					// test parity of array position
					int parity = i % 2;	
					
					if ( parity == 0 )
					{
						// even, shift left and down
						currPoint.translate(-1, -1);
					}
					else
					{
						// odd, shift left
						currPoint.translate(-1, 0);
					}
					*/
					
					if (rightWinPattern[i - 1].x == rightWinPattern[i -  1].y)
					{
						// we are at a corner, shift left and down
						currPoint.translate(-1, -1);
					}
					else
					{
						// we are at at junction, shift left
						currPoint.translate(-1, 0);
					}
									
					xPos = currPoint.x;
					yPos = currPoint.y;
					boardMarkAtPos = board[yPos][xPos];
					confirmedLadderPoints = 1;
					
					// generate expected ladder position
					for (int j = 0; j < expectedLadderPosition.length; j++)
					{
						Point nextExpectedPoint 	= new Point(currPoint.x + rightWinPattern[j].x, currPoint.y + rightWinPattern[j].y ); 
						expectedLadderPosition[j] 	= nextExpectedPoint;
					}
					
					// exit for loop and test shifted point
					break;
				}
			}
		}
			
		return (confirmedLadderPoints == 5 ? true : false);
	}
	
	public static void main(String[] args) 
	{
		Board myBoard = new Board();
		
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(2, 5, "*");
		myBoard.setPosition(2, 6, "*");
		myBoard.setPosition(3, 6, "*");
		
		myBoard.printBoard();
		
		WinDetectionStrategy detectWin = new WinDetectionStrategy( myBoard.getState() );
		boolean win = detectWin.detectRightLadder("*", new Point(5, 1) );
		
		System.out.printf("Win detected? %b\n", win);
	}

}
