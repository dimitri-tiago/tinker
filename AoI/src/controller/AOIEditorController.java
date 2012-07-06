/**
 * Age of Industry
 * 22/5/2011
 */
package controller;

import java.awt.Color;
import java.awt.Point;

import model.AOIMapInterface;
import model.AOIMapObserver;
import model.AOIMapSubject;
import model.Drawable;

import view.AOIEditorView;

import javax.swing.Icon;
import javax.swing.JOptionPane;	// FOR TESTING

/**
 * This class provides a concrete controller strategy (strategy pattern).
 * @author dimitri.tiago
 */
public class AOIEditorController implements AOIEditorControllerStrategy, AOIMapObserver
{
	private AOIMapInterface mapModelInterface;	// map model interface that this controller makes requests to.
	private AOIMapSubject mapModelSubject;		// map model interface that this AOIMapObserver receives updates of interest from.
	private AOIEditorView ageOfIndustryView;	// view that this controller manages

	/**
	 * Default constructor initializes instance variables
	 * @param mapModelSubject map model interface that this AOIMapObserver receives updates of interest from.
	 * @param mapModelInterface map model interface that this controller makes requests to.
	 */
	public AOIEditorController(AOIMapSubject mapModelSubject, AOIMapInterface mapModelInterface)
	{
		this.mapModelInterface 	= mapModelInterface;
		this.mapModelSubject 	= mapModelSubject;
		this.ageOfIndustryView	= new AOIEditorView(mapModelSubject, this);
	}

	/**
	 * This method asks the map model to add a location to the map.
	 */
	@Override
	public void addLocation(String name, Color color, Icon symbol, Point coordinates)
	{
		mapModelInterface.addLocation(name, color, symbol, coordinates);
	}

	// TODO: comments
	@Override
	public void updateLocation(Point prevPosition, Point newPosition)
	{
		mapModelInterface.updateLocation(prevPosition, newPosition);
	}
	
	/**
	 * This method updates the controller when an event of notice occurs in the map model
	 */
	@Override
	public void updateObserver(Drawable d)
	{
		// TODO Auto-generated method stub	
	}
}
