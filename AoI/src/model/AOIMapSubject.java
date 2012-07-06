/**
 * Age of Industry
 * 25/5/2011
 */
package model;

/**
 * This interface implements the observer pattern subject(s) to decouple the view from the model.
 * It is used to notify observers of map events of notice and provides the api contract for
 * all aoi map subjects.
 * @author dimitri.tiago
 */
public interface AOIMapSubject
{
	/**
	 * This method registers observers of subject
	 * @param o Reference to observer
	 */
	public void registerObserver(AOIMapObserver o);
	
	/**
	 * This method unregisters observers of subject
	 * @param o Reference to observer
	 */
	public void removeObserver(AOIMapObserver o);
	
	/**
	 * This method notifies observers of an event.
	 */
	public void notifyObservers(Drawable d);
}
