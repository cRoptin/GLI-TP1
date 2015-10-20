package fr.istic.gli.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;

import fr.istic.gli.model.Camembert;
import fr.istic.gli.view.View;

public class Controller implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888821953295699072L;
	
	/**
	 * The model
	 */
	private View moView;

	/**
	 * 
	 */
	public Controller(View poView) {
		super();
		this.moView = poView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point2D oPoint = moView.getMousePosition();
		int iSlcArc = moView.getArcPointClicked(oPoint);
		
		moView.update(new Camembert(), iSlcArc);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	
}
