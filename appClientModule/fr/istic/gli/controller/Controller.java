package fr.istic.gli.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.istic.gli.model.Camembert;

public class Controller implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888821953295699072L;
	
	/**
	 * The model
	 */
	private Camembert moCamembert;

	/**
	 * 
	 */
	public Controller(Camembert poCamembert) {
		super();
		this.moCamembert = poCamembert;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		moCamembert.getMloItems().get(0).setMiValue(100);
		moCamembert.notifyObservers();
		System.out.println("J'ai cliqué");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("J'ai appuyé");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("J'ai relaché");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Je suis entré");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Je suis sortis");
		
	}

	
}
