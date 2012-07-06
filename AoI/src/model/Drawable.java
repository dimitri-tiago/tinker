/**
 * Age of Industry
 * 03/06/2011
 */
package model;

import java.awt.Graphics;
import java.awt.Point;

/**
 * This interface should be subclassed for any drawable objects that need be drawn on the aoi view.
 * @author dimitri.tiago
 */
public interface Drawable
{
	/**
	 * This method must be overriden for specific draw implementation of drawable objects.
	 */
	public void draw(Graphics g);
	
	//TODO: this needs to be refactored (and moved out of here). Coordinates should be already converted to displaying component
	/**
	 * TODO:
	 * @return
	 */
	public Point getCoordinates();

	/**
	 * TODO:
	 * @param locCoordinates
	 */
	public void setCoordinates(Point locCoordinates);
}
