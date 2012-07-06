/**
 * Age of Industry
 * 22/5/2011
 */
package controller;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Icon;

/**
 * This interface implements the strategy pattern
 * @author dimitri.tiago
 */
public interface AOIEditorControllerStrategy
{
	/**
	 * This method asks the map model to add a location to the map.
	 * @param name location name
	 * @param color location color
	 * @param symbol location symbol
	 */
	public void addLocation(String name, Color color, Icon symbol, Point coordinates);
	
	//TODO: comments
	public void updateLocation(Point prevPosition, Point newPosition);
}
