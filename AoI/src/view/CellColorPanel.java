/**
 * Age of Industry
 * 19/6/2012
 */
package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author dimitri.tiago
 *
 */
public class CellColorPanel extends JPanel
{
	private Color color;
		
	public void paintComponent(Graphics g)
	{	
		g.setColor(color);
		g.fillRect(2, 0, 19, 14);
	
		g.setColor(Color.BLACK);
		g.drawRect(2, 0, 19, 14);
	}
	
	public void setColor (Color color)
	{
		this.color = color;
	}
}
