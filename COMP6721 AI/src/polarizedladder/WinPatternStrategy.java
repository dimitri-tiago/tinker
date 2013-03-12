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
	
	/*
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
	*/
	
	private Point winPatterns[][] = { 			
			{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)},			//  right ladder patterns
			{new Point(-1,0), new Point(0,0), new Point (0,1), new Point (1,1) , new Point (1,2)},
			{new Point (-1,-1), new Point (0,-1), new Point(0,0), new Point(1,0), new Point (1,1)},
			{new Point (-2,-1), new Point (-1,-1), new Point (-1,0), new Point(0,0), new Point(0,1)},
			{new Point (-2,-2), new Point (-1,-2), new Point (-1,-1), new Point(0,-1), new Point(0,0)},
			{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)},		//	left ladder patterns
			{new Point(0,0), new Point(1,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
			{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (0,-1) , new Point (1,-1)},
			{new Point(0,0), new Point(0,1), new Point (1,0), new Point (1,-1) , new Point (2,-1)},
			{new Point(0,0), new Point(0,-1), new Point (1,-1), new Point (1,-2) , new Point (2,-2)},
	};
	
	private Point rightSidePolarity[] = { new Point(1,1), new Point(2,2), new Point(3,3), 
			new Point(4,4), new Point(5,5), new Point(6,6), new Point(7,7)};
	
	private Point leftSidePolarity[] = { new Point(1,13), new Point(2,12), new Point(3,11), 
			new Point(4,10), new Point(5,9), new Point(6,8), new Point(7,7)};
	
	public WinPatternStrategy(String[][] board) 
	{
		this.board = board;
	}
	
	//TODO: check polarity of ladder.
	//TODO: check for win block positions.
	public boolean detectRightLadder(String playerToken, Point currPoint)
	{
		String token = " ";
		
		for (int i = 0; i < winPatterns.length; i++)
		{
			int confirmedPoints = 0;
			
			for (int j = 0; j < winPatterns[0].length; j++)
			{
				int xPos = currPoint.x + winPatterns[i][j].x;
				int yPos = currPoint.y + winPatterns[i][j].y;
				
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
				// obtain ladder matching pattern, and ladder direction
				Point[] ladder 			= new Point[5];
				String ladderDirection 	= ( i > 4 ) ? "LEFT" : "RIGHT";
				
				for (int j = 0; j < winPatterns[0].length; j++)
				{
					ladder[j] = new Point( currPoint.x + winPatterns[i][j].x, currPoint.y + winPatterns[i][j].y);
				}
				
				// check ladder polarity
				if ( isPolarized(ladder, ladderDirection) )
				{
					// ladder polarized, win.
					return true;
				}
				else
				{
					// ladder not polarized, if no block, then win
					return isWinBlocked(ladder, ladderDirection) ? false : true;
				}
			}
		}
			
		return false;
	}
	
	//TODO: optimize by removing points that are not worth checking
	public boolean isPolarized(Point[] ladder, String ladderDirection)
	{
		// check polarity
		if ( (ladder[0].y == 1) && (ladder[1].y == 1) )		// base 
		{
			return true;
		}
		else if (ladderDirection.equalsIgnoreCase("RIGHT")) // left side
		{
			for (int i = 0; i < ladder.length; i++)
			{
				for (int j = 0; j < leftSidePolarity.length; j++)
				{
					if ( ladder[i].equals(leftSidePolarity[j])
							&& ladder[i+1].equals(leftSidePolarity[j+1])
							&& ladder[i+2].equals(leftSidePolarity[j+2]) )
					{
						return true;
					}
				}
			}
		}	
		else if (ladderDirection.equalsIgnoreCase("LEFT")) 	// right side
		{
			for (int i = 0; i < ladder.length; i++)
			{
				for (int j = 0; j < rightSidePolarity.length; j++)
				{
					if ( ladder[i].equals(rightSidePolarity[j])
							&& ladder[i+1].equals(rightSidePolarity[j+1])
							&& ladder[i+2].equals(rightSidePolarity[j+2]) )
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isWinBlocked(Point[] ladder, String ladderDirection)
	{
		if ( ladderDirection.equalsIgnoreCase("LEFT") )
		{
		
		}
		else if ( ladderDirection.equalsIgnoreCase("RIGHT") )
		{
			
			
		}
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		Board myBoard = new Board();
		
		/* right ladder test
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(2, 5, "*");
		myBoard.setPosition(2, 6, "*");
		myBoard.setPosition(3, 6, "*");
		*/
		
		// left ladder test
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(2, 4, "*");
		myBoard.setPosition(2, 3, "*");
		myBoard.setPosition(3, 3, "*");
		
		
		myBoard.printBoard();
		
		WinPatternStrategy detectWin = new WinPatternStrategy( myBoard.getState() );
		boolean win = detectWin.detectRightLadder("*", new Point(4, 2) );
		
		System.out.printf("Win detected? %b\n", win);
	}

}