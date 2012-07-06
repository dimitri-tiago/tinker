/**
 * Age of Industry
 * 20/06/2011
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * @author dimitri.tiago
 */
public class LocAddDialog extends JDialog implements MouseListener
{
	private final int LOC_NAME_LENGTH 	= 15;						// default length of location name input possible 
	private final Color [] LOC_COLORS 	= 							// default location colors
		{Color.RED, Color.CYAN, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.GRAY};	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JButton okButton;
	private JButton cancelButton;
	private JComboBox<Color> comboBoxColor;
	private JComboBox<ImageIcon> comboBoxSymbol;
	
	private boolean okPressed;										// store state of ok button
	
	private String locName;											// location details provided by user
	private Color locColor;
	private Icon locSymbol;
	private Point locCoordinates;
	
	
	/**
	 * Create the dialog.
	 */
	public LocAddDialog() 
	{
		// build dialog
		setTitle("Age of Industry");
		setModal(true);
		setBounds(100, 100, 238, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblColor = new JLabel("Color:");
		
		JLabel lblSymbol = new JLabel("Symbol:");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		comboBoxColor = new JComboBox<Color>(LOC_COLORS);
		comboBoxColor.setRenderer(new CellColorRenderer());
		
		ImageIcon[] icons = {new ImageIcon(getClass().getResource("AoIStarIcon_small.gif"))};
		comboBoxSymbol 	  = new JComboBox<ImageIcon>(icons);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblSymbol)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxSymbol, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblColor))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(comboBoxColor, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(comboBoxColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSymbol)
						.addComponent(comboBoxSymbol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addMouseListener(this);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(this);
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(90, Short.MAX_VALUE)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(14))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(cancelButton)
							.addComponent(okButton))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		
		// initialize fields 
		okPressed = false;
		
		// display dialog
		setModal(true);
		setLocationRelativeTo(null);			// set dialog location
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource().equals(okButton))
		{			
			locName  		= textFieldName.getText();
			locColor 		= (Color) comboBoxColor.getSelectedItem();
			locSymbol		= (ImageIcon) comboBoxSymbol.getSelectedItem();
			
			int xPos 		= e.getXOnScreen();
			int yPos 		= e.getYOnScreen();
			locCoordinates 	= new Point(xPos, yPos);
			
			okPressed = true;
		}
		
		dispose();
	}

	public boolean getOkPressed()
	{
		return okPressed;
	}
	
	public String getLocationName()
	{
		return locName;
	}
	
	public Color getLocationColor()
	{
		return locColor;
	}
	
	public Icon getLocationSymbol()
	{
		return locSymbol;
	}
	
	public Point getLocationCoordinates()
	{
		return locCoordinates;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
