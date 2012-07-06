/**
 * Age of Industry
 * 18/5/2011
 */
package view;

import javax.swing.JFrame; 
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JOptionPane;	/* FOR TESTING */

import java.awt.BorderLayout;

import model.AOIMapSubject;
import controller.AOIEditorControllerStrategy;

//TODO: refactor view classes making use of java's AbstractAction actions to encapsulate component event handling.

/**
 * This class is responsible for the main AoI application window.
 * @author dimitri.tiago
 */
public class AOIEditorView extends JFrame
{	
	private AOIMapSubject mapSubject;					// reference to observer pattern map subject to register for event notfication
	private AOIEditorControllerStrategy controller;		// reference to controller that manages this view
	
	private MapEditorToolBar mapEditorToolBar;			// map editor tool bar gui component
	private AOIMapPanel mapPanel;						// map panel gui component
	
	/**
	 * The default constructor creates the age of industry frame and registers the view with the model for event notification.
	 * @param mapSubject the map subject that will notify this view of map events
	 * @param controller the controller that will manage this view
	 */
	public AOIEditorView(AOIMapSubject mapSubject, AOIEditorControllerStrategy controller)
	{
		this.mapSubject = mapSubject;
		this.controller = controller;

		setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		buildFrame();
	}
	
	/**
	 * This method sets the frame look and feel
	 * @param lookAndFeel java look and field name
	 */
	private void setLookAndFeel(String lookAndFeel)
	{
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo look : looks)
		{
			if (look.getClassName().contains(lookAndFeel))
			{
				try
				{
					UIManager.setLookAndFeel(look.getClassName());
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				catch (InstantiationException e)
				{
					e.printStackTrace();
				} 
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				} 
				catch (UnsupportedLookAndFeelException e)
				{
					e.printStackTrace();
				}
				
				SwingUtilities.updateComponentTreeUI(this);
				break;
			}
		}
	}
	
	/**
	 * This method builds the AOIView
	 */
	private void buildFrame()
	{
		// create view frame
		BorderLayout layout = new BorderLayout(0, 0);	// set frame layout
		setLayout(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);					// center frame on screen
		setTitle("Age of Industry");

		// create map panel
		mapPanel = new AOIMapPanel(mapSubject, controller);
		add(mapPanel, BorderLayout.CENTER);
		
		// create tool bar
		mapEditorToolBar = new MapEditorToolBar(this.controller, this.mapPanel);
		add(mapEditorToolBar, BorderLayout.NORTH);
				
		// display frame
		setVisible(true);
	}
}

