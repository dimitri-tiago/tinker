/**
 * Age of Industry
 * 11/17/2011
 */
package model;

/**
 * Class represents a potential railway track link between two Locations.
 */
public class RailwayTrack 
{
	private Location loc1;		// location linked at track end-point 
	private Location loc2;		// location linked at track end-point 
	
	/**
	 * Constructor instantiates and initializes a <code>RailwayTrack</code> link object between two locations.
	 * @param loc1 location linked at track end-point
	 * @param loc2 location linked at track end-point
	 */
	public RailwayTrack(Location loc1, Location loc2)
	{
		this.loc1 = loc1;
		this.loc2 = loc2;
	}
}
