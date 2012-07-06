/**
 * Age of Industry
 * 18/5/2011
 */
package controller;

import model.AOIMapModel;

/**
 * This class is responsible for executing the AoI application
 */
public class AoI
{
	/**
	 * This method executes the application
	 * @param args application does not require arguments from command line
	 */
	public static void main(String args[])
	{
		// execute application
		AOIMapModel mapModel	= new AOIMapModel("Germany");
		AOIEditorController app = new AOIEditorController(mapModel, mapModel);
	}
}
