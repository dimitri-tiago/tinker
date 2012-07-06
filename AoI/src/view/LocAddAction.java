/**
 * Age of Industry
 * 3/06/2011
 */
package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import controller.AOIEditorControllerStrategy;

/**
 * This class implements the location add action. It handles the user location add button action event, displays a dialog to 
 * collect information for the location to be added, and asks the controller to add a new location to the aoi map.
 * @author dimitri.tiago
 */
public class LocAddAction extends AbstractAction
{
	private AOIEditorControllerStrategy controller;		// controller that this action will ask to add a location to the aoi map
	private JComponent componentPanel;					// component panel that is used to obtain actual coordinates of location (on component)
	
	/**
	 * Default constructor instantiates action and sets default image icon
	 * @param image icon that will be displayed on action.
	 */
	public LocAddAction(String text, ImageIcon icon, JComponent componentPanel)
	{
		super(text, icon);
		this.componentPanel = componentPanel;
	}
	
	/**
	 * This method sets the controller that this action will use to request the addition of a location to the map.
	 * @param controller controller that this action will use to request the addition of a location to the map.
	 */
	public void setController(AOIEditorControllerStrategy controller)
	{
		this.controller = controller;
	}
	
	/**
	 * This method handles the user location add button action event, displays a dialog to 
	 *collect information for the location to be added, and asks the controller to add a new location to the aoi map.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		LocAddDialog locAddDialog = new LocAddDialog();
		
		if (locAddDialog.getOkPressed() == true)
		{
			String locName 			= locAddDialog.getLocationName();
			Color locColor	 		= locAddDialog.getLocationColor();
			Icon locSymbol			= locAddDialog.getLocationSymbol();
			Point locCoordinates 	= locAddDialog.getLocationCoordinates();
		
			SwingUtilities.convertPointFromScreen(locCoordinates, componentPanel);	// convert location add coordinates from screen 
																					// coordinates to container panel component coordinates
																					// so that it is displayed on correct location 
																					// (mouse arrow tip).
			
			controller.addLocation(locName, locColor, locSymbol, locCoordinates);
		}
		
	}
}
