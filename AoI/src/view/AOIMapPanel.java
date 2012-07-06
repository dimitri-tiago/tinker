/**
 * June 7, 2012
 * Age of Industry
 */
package view;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import model.AOIMapSubject;
import model.AOIMapObserver;
import model.Drawable;

import controller.AOIEditorControllerStrategy;

/**
 * @author dimitri.tiago
 */
public class AOIMapPanel extends JPanel implements AOIMapObserver, MouseListener, MouseMotionListener
{
	private AOIMapSubject mapSubject; 				// observer pattern model subject implementation
	private AOIEditorControllerStrategy controller;
	private ArrayList<Drawable> drawableObjects;	// array list of drawable objects to display.
	
	private Point startPosition;
	private Point nextPosition;
	private Point endPosition;
	
	/**
	 * Default constructor initializes AOIMapPanel
	 */
	public AOIMapPanel(AOIMapSubject mapSubject, AOIEditorControllerStrategy controller)
	{
		// TODO: finish this...
		this.mapSubject = mapSubject;
		this.controller = controller;
		drawableObjects = new ArrayList<Drawable>();
		
		nextPosition 	= new Point();
		endPosition 	= new Point();
		
		this.mapSubject.registerObserver(this);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setBackground(Color.WHITE);
	}

	/**
	 * Update map state
	 */
	@Override
	public void updateObserver(Drawable d)
	{		
		if (drawableObjects.contains(d) == false)
		{
			drawableObjects.add(d);
		}
		
		repaint();
	}
	
	/**
	 * TODO:
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Drawable d : drawableObjects)
		{			
			d.draw(g);
		}
	}

	// TODO: mouse mouse listeners to event handling class.
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// get start location
		startPosition = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{	
		//endPosition = e.getPoint();
		//controller.updateLocation(nextPosition, endPosition);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		nextPosition = e.getPoint();
		controller.updateLocation(startPosition, nextPosition);
		startPosition = nextPosition;
	}
		
	@Override
	public void mouseMoved(MouseEvent e)
	{
		
	}
}