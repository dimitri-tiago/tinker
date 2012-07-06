/**
 * Age of Industry
 * 11/17/2011
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * Class represents a game map. A game map contains locations and railway tracks.
 */
public class AOIMapModel implements AOIMapSubject, AOIMapInterface
{
	private String name;								// name of map
	
	private ArrayList<AOIMapObserver> mapObservers;		// map observes (e.g. view, controller)
	private ArrayList<Location> locations;				// locations on the board
	private ArrayList<Space> spaces;					// stand-alone spaces on the board (e.g. coal, iron supplies)
	
	/**
	 * Constructor initializes <code>Map</code> object instance with a name.
	 * @param name map name
	 */
	public AOIMapModel(String name)
	{
		// initialize instance variables
		this.name = name;
		
		mapObservers = new ArrayList<AOIMapObserver>();
		locations 	= new ArrayList<Location>();
		spaces 		= new ArrayList<Space>();
	}
	
	/**
	 * This method adds a location to the map and notifies map observers that the state of the map has changed.
	 * @param name location name
	 * @param color location color
	 * @param symbol location symbol
	 */
	@Override
	public void addLocation(String name, Color color, Icon symbol, Point coordinates)
	{
		Location newLoc = new Location(name, color, symbol, coordinates);
		locations.add(newLoc);
		notifyObservers(newLoc);
	}
	
	//TODO: bug on two locations containing same point. 
	//      need to differentiate with additional attribue (e.g. name).
	public void updateLocation(Point prevPosition, Point newPosition)
	{
		boolean isLocation = false;
		
		for (Location l : locations)
		{
			if ( (l.isLocation(prevPosition) == true) && (isLocation == false) )
			{
				l.setCoordinates(newPosition);
				notifyObservers(l);
				isLocation = true;
			}
		}
	}
	
	/**
	 * This method registers an observer into the list of map observers.
	 * @param o observer
	 */
	@Override
	public void registerObserver(AOIMapObserver o)
	{
		mapObservers.add(o);
	}
	
	/**
	 * This method de-registers observers from the observers list of map observers.
	 * @param o observer
	 */
	@Override
	public void removeObserver(AOIMapObserver o)
	{
		mapObservers.remove(o);
	}

	/**
	 * This method notifies observers that the state of the map has changed.
	 */
	@Override
	public void notifyObservers(Drawable d)
	{
		for (AOIMapObserver o : mapObservers)
		{
			o.updateObserver(d);
		}
	}
}