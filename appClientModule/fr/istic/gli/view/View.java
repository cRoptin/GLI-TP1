package fr.istic.gli.view;

import java.awt.geom.Point2D;

import fr.istic.gli.model.CamembertImpl;

/**
 * The view
 */
public interface View {
	
	/**
	 * Initialisation of the camembert
	 */
	public void initCamembert();
	
	/**	
	 * Gets the model.
	 * @return the model
	 */
	public CamembertImpl getCamembert();

	/**
	 * Sets the model.
	 * @param model the new model
	 */
	public void setCamembert(CamembertImpl camembert);

	/**
	 * Gets the arc point clicked.
	 * @param the clicked point
	 * @return the arc point clicked
	 */
	public int getArcPointClicked(Point2D poPoint);

}
