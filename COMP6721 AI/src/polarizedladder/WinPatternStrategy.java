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
			{new Point(1,0), new Point(0,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
			{new Point (1,-1), new Point (0,-1), new Point(0,0), new Point(-1,0), new Point (-1,1)},
			{new Point (2,-1), new Point (1,-1), new Point (1,0), new Point(0,0), new Point(0,1)},
			{new Point (2,-2),  new Point (1,-2), new Point (1,-1), new Point(0,-1), new Point(0,0)},
	};
	
	private Point leftSidePolarity[] = { new Point(1,1), new Point(2,2), new Point(3,3), 
			new Point(4,4), new Point(5,5), new Point(6,6), new Point(7,7)};
	
	private Point rightSidePolarity[] = { new Point(13,1), new Point(12,2), new Point(11,3), 
			new Point(10,4), new Point(9,5), new Point(8,6), new Point(7,7)};
	
	public WinPatternStrategy(String[][] board) 
	{
		this.board = board;
	}
	
	//TODO: check for win block positions.
	public boolean detectLadder(String playerToken, String opposingPlayerToken, Point currPoint)
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
					return isWinBlocked(ladder, ladderDirection, opposingPlayerToken) ? false : true;
				}
			}
		}
			
		return false;
	}
	
	public boolean isPolarized(Point[] ladder, String ladderDirection)
	{
		// check polarity
		if ( (ladder[0].y == 1) && (ladder[1].y == 1) )		// base 
		{
			return true;
		}
		else if (ladderDirection.equalsIgnoreCase("RIGHT")) // left polarity
		{
			for (int j = 0; j < (leftSidePolarity.length - 1); j++)
			{
				if ( ladder[0].equals(leftSidePolarity[j])
						&& ladder[2].equals(leftSidePolarity[j+1])
						&& ladder[4].equals(leftSidePolarity[j+2]) )
				{
					System.out.println("Right Ladder Polarized!");	
					return true;
				}
			}
		}	
		else if (ladderDirection.equalsIgnoreCase("LEFT")) 	// right polarity
		{
			for (int j = 0; j < (rightSidePolarity.length - 1); j++)
			{
				if ( ladder[0].equals(rightSidePolarity[j])
						&& ladder[2].equals(rightSidePolarity[j+1])
						&& ladder[4].equals(rightSidePolarity[j+2]) )
				{
					System.out.println("Left Ladder Polarized!");					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isWinBlocked(Point[] ladder, String ladderDirection, String opposingPlayerToken)
	{
		if ( ladderDirection.equalsIgnoreCase("LEFT") )
		{
			Point p1 = new Point(ladder[0].x - 2, ladder[0].y);	// block point 1
			Point p2 = new Point(ladder[0].x, ladder[0].y + 2);	// block point 2
			
			// if board points p1 and p2 do not contain player token...
			if ( (board[p1.y][p1.x].equalsIgnoreCase(opposingPlayerToken)) &&
					(board[p2.y][p2.x].equalsIgnoreCase(opposingPlayerToken)))
			{
				// win blocked
				System.out.println("Left Win Blocked!");
				return true;
			}
		}
		else if ( ladderDirection.equalsIgnoreCase("RIGHT") )
		{
			Point p1 = new Point(ladder[0].x + 2, ladder[0].y);	// block point 1
			Point p2 = new Point(ladder[0].x, ladder[0].y + 2);	// block point 2
			
			// if board points p1 and p2 do not contain player token...
			if ( (board[p1.y][p1.x].equalsIgnoreCase(opposingPlayerToken)) &&
					(board[p2.y][p2.x].equalsIgnoreCase(opposingPlayerToken)))
			{
				// win blocked
				System.out.println("Right Win Blocked!");
				return true;
			}
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
		
		/* left ladder test
		myBoard.setPosition(1, 5, "*");
		myBoard.setPosition(1, 4, "*");
		myBoard.setPosition(2, 4, "*");
		myBoard.setPosition(2, 3, "*");
		myBoard.setPosition(3, 3, "*");
		*/
		
		/* polarity test right ladder
		myBoard.setPosition(2, 2, "*");
		myBoard.setPosition(2, 3, "*");
		myBoard.setPosition(3, 3, "*");
		myBoard.setPosition(3, 4, "*");
		myBoard.setPosition(4, 4, "*");
		*/
		
		/* polarity test left ladder
		myBoard.setPosition(7, 7, "*");
		myBoard.setPosition(6, 7, "*");
		myBoard.setPosition(6, 8, "*");
		myBoard.setPosition(5, 8, "*");
		myBoard.setPosition(5, 9, "*");
		*/
		
		/* win left ladder blocked
		myBoard.setPosition(2, 7, "*");
		myBoard.setPosition(2, 6, "*");
		myBoard.setPosition(3, 6, "*");
		myBoard.setPosition(3, 5, "*");
		myBoard.setPosition(4, 5, "*");
		myBoard.setPosition(2, 5, "o");
		myBoard.setPosition(4, 7, "o");
		*/
		
		// win right ladder blocked
		myBoard.setPosition(3, 7, "*");
		myBoard.setPosition(3, 8, "*");
		myBoard.setPosition(4, 8, "*");
		myBoard.setPosition(4, 9, "*");
		myBoard.setPosition(5, 9, "*");
		myBoard.setPosition(5, 7, "o");
		myBoard.setPosition(3, 9, "o");
		
		myBoard.printBoard();
		
		WinPatternStrategy detectWin = new WinPatternStrategy( myBoard.getState() );
		boolean win = detectWin.detectLadder("*", "o", new Point(8, 4) );
		
		System.out.printf("Win detected? %b\n", win);
	}

}