/**
 * Age of Industry
 * 18/5/2011
 */
package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import controller.AOIEditorControllerStrategy;

/**
 * This class is responsible for building the map editor menu bar
 * @author dimitri.tiago
 */
public class MapEditorToolBar extends JToolBar
{
	private AOIEditorControllerStrategy controller;
	private JComponent componentPanel;					// component panel that is used to obtain coordinates on component
														// for actions that need to store point coordinates.
	private JButton locAddButton;
	
	
	/**
	 * One argument controller initializes fields and build GUI.
	 * @param controller concrete instance of <code>AoIControllerStrategy</code> interface. 
	 */
	public MapEditorToolBar(AOIEditorControllerStrategy controller, JComponent componentPanel)
	{
		this.controller 	= controller;
		this.componentPanel	= componentPanel;
	
		createButtons();
	}
	
	/**
	 * This method creates the tool bar buttons
	 */
	private void createButtons()
	{
		ImageIcon locAddIcon = new ImageIcon(getClass().getResource("addLocIcon.gif"));	// add location button
		LocAddAction locAddAction = new LocAddAction(null, locAddIcon, componentPanel);
		locAddAction.setController(controller);
		locAddButton = new JButton(locAddAction);
		locAddButton.setToolTipText("Add Location");
		add(locAddButton);
	}
}
