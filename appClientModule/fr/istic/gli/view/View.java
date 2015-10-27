package fr.istic.gli.view;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import fr.istic.gli.model.CamembertImpl;

public interface View {
	
	/**
	 * Initialisation of the camembert
	 */
	public void initCamembert();
	
	/**	
	 * Gets the model.
	 *
	 * @return the model
	 */
	public CamembertImpl getCamembert();

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setCamembert(CamembertImpl camembert);

	public void paintComponent(Graphics g);

	/**
	 * Gets the arc point clicked.
	 * @param the clicked point
	 * @return the arc point clicked
	 */
	public int getArcPointClicked(Point2D poPoint);

	public void paintComponents(Graphics g);

}
