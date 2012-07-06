/**
 * Age of Industry
 * 11/17/2011
 */
package model;
	
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * Class represents a location on the map. A location is made up of 1 to n spaces.
 */
public class Location implements Drawable
{
	private final int WIDTH 	= 100;
	private final int HEIGHT 	= 20;
	
	private String name;					// location name
	private Color color;					// location color
	private Icon symbol;					// location symbol for color blind usability
	
	private Point coordinates;				// location coordinates on map
	private Rectangle locRectangle;			// location rectangle
	
	private int locWidth;					// location width
	
	ArrayList<Space> spaces;				// array of Space objects that comprise location
	ArrayList<RailwayTrack> tracks;			// list of potential railway tracks linking to other locations
	
	/**
	 * Constructor instantiates a fully initialized Location object.
	 * @param name location name
	 * @param color location color
	 * @param symbol location symbol (for color blind usability)
	 */
	public Location(String name, Color color, Icon symbol, Point coordinates)
	{
		// initialize instance variables 
		this.name 			= name;
		this.color 			= color;
		this.symbol 		= symbol;
		this.coordinates 	= coordinates;
		this.locRectangle	= new Rectangle( (int) coordinates.getX(), (int) coordinates.getY(), WIDTH, HEIGHT );
		this.locWidth 		= WIDTH;
		
		spaces		= new ArrayList<Space>();
		tracks		= new ArrayList<RailwayTrack>();	
	}
	
	/**
	 * This method draws the location
	 * @param g graphics context
	 */
	public void draw(Graphics g)
	{		
		g.setFont(new Font("Monospaced", Font.PLAIN, 15));		// set font 
		
		int nameWidth = g.getFontMetrics().stringWidth(name);	// resize location if necessary
		int iconWidth = symbol.getIconWidth();
		while ((iconWidth + 25 + nameWidth) > locWidth)
		{
			locWidth += 1;
			locRectangle.setSize(locWidth, HEIGHT);
		}
		
		int startX 	= (int) coordinates.getX();					// draw location rectangle
		int startY 	= (int) coordinates.getY();
		g.setColor(color);
		g.fillRect(startX, startY, locWidth, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(startX, startY, locWidth, HEIGHT);
		
		g.drawString(name, startX + 25, startY + 14);			// draw location name
		
		symbol.paintIcon(null, g, startX, startY);				// paint location icon
	}
	
	public boolean isLocation(Point coordinates)
	{		
		return locRectangle.contains(coordinates);
	}
	
	/**
	 * TODO:
	 * @return
	 */
	public Point getCoordinates()
	{
		return coordinates;
	}

	/**
	 * TODO:
	 * @param locCoordinates
	 */
	public void setCoordinates(Point locCoordinates)
	{
		this.coordinates = locCoordinates;
		this.locRectangle.setLocation(locCoordinates);
	}
}