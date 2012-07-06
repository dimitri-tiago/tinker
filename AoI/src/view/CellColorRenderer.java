/**
 * Age of Industry
 * 16/6/2012
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * This class implements a combo box color renderer. 
 */
public class CellColorRenderer extends JPanel implements ListCellRenderer
{		
	private Color color;	
	private CellColorPanel colorPanel;
		
	public CellColorRenderer()
	{
		setOpaque(true);
		setPreferredSize(new Dimension(25, 25));
		
		colorPanel = new CellColorPanel();
		colorPanel.setPreferredSize(new Dimension(25, 25));
		add(colorPanel);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
	{
		if (isSelected)
		{
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		else
		{
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}	
		
		colorPanel.setColor((Color) value);
		
		return this;	
	}
}
