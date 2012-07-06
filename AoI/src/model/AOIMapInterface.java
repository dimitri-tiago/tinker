/**
 * Age of Industry
 * 6/03/2012
 */
package model;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Icon;

/**
 * This interface defines the operations that all AOI map models must interface.
 * @author dimitri.tiago
 */
public interface AOIMapInterface
{
	/**
	 * This method adds a location to the map
	 * @param name location name
	 * @param color location color
	 * @param symbol location symbol
	 */
	public void addLocation(String name, Color color, Icon symbol, Point coordinates);
	
	public void updateLocation(Point prevPosition, Point newPosition);
}
