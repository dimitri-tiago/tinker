/**
 * Age of Industry
 * 25/5/2011
 */
package model;

/**
 * This interface implements the observer pattern obsever(s) to decouple the view from the model.
 * It is used to receive map events of notice.
 * @author dimitri.tiago
 */
public interface AOIMapObserver
{
	/**
	 * This method updates the observer when an event of notice occurs;
	 * @param d drawable object that shall be rendered by the view.
	 */
	public void updateObserver(Drawable d);
}
