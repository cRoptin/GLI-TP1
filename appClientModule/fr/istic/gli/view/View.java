package fr.istic.gli.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JComponent;

import fr.istic.gli.model.Camembert;
import fr.istic.gli.model.Item;

/**
 * The Class View.
 */
public class View extends JComponent implements Observer {
	
	/** The angle. */
	private float angle = 0;
	
	/**
	 * The model
	 */
	private Camembert camembert;
	
	/** The list arcs. */
	private List<Arc2D> listArcs;

	/**
	 * Instantiates a new view.
	 */
	public View() {
		listArcs = new ArrayList<Arc2D>();
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Camembert getCamembert() {
		return camembert;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setCamembert(Camembert camembert) {
		this.camembert = camembert;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Camembert camembert = this.getCamembert();
		List<Item> elements = camembert.getLoItems();
		
		// Calcul la taille des arcs et les ajoute à la view
		for (int i = 0; i < elements.size(); i++) {
			float pourcentage = (float) 1.0;//item.getPourcentage(i) * 3.6f;
			Arc2D.Double arc = new Arc2D.Double(20, 20, 300, 300, angle,
					pourcentage, Arc2D.PIE);

			g2.setColor(new Color(new Random().nextInt()));
			g2.fill(arc);

			angle += pourcentage;
			listArcs.add(arc);
		}
	}

	/**
	 * Gets the arc point clicked.
	 *
	 * @param p the p
	 * @return the arc point clicked
	 */
	public int getArcPointClicked(Point2D p) {
		for (int i = 0; i < listArcs.size(); i++) {
			if (listArcs.get(i).contains(p.getX(), p.getY())) {
				return i;
			}
		}
		return -1;
	}


	/*@Override
	public void update(Observable arg0, Object arg1) {
		//repaint();
	}*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
