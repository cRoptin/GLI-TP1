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
	
	private static Graphics2D g2;
	
	/**
	 * 
	 */
	private final int iStdSize = 400;
	/**
	 * 
	 */
	private final int iExtSize = 50;

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
		g2 = (Graphics2D) g;

		Camembert camembert = this.getCamembert();
		List<Item> elements = camembert.getMloItems();
		
		// Calcul la taille des arcs et les ajoute à la view
		for (int i = 0; i < elements.size(); i++) {
			float pourcentage = (float) camembert.getPourcentage(i) * 3.6f;
			int iSize = iStdSize;
			if (elements.get(i).getMbHighLights()) {
				iSize += iExtSize;
			}
			Arc2D.Double arc = new Arc2D.Double(50 - ((iSize - iStdSize) / 2), 50 - ((iSize - iStdSize) / 2), iSize, iSize, angle, pourcentage, Arc2D.PIE);
			g2.setColor(new Color(new Random().nextInt()));
			g2.fill(arc);

			angle += pourcentage;
			listArcs.add(arc);
		}
		
		Arc2D.Double blanckArc = new Arc2D.Double(110, 110, 280, 280, 0, 360, Arc2D.PIE);
		g2.setColor(Color.WHITE);
		g2.fill(blanckArc);
		
		Arc2D.Double centralArc = new Arc2D.Double(175, 175, 150, 150, 0, 360, Arc2D.PIE);
		g2.setColor(Color.BLACK);
		g2.fill(centralArc);
		
		listArcs.add(blanckArc);
		
		listArcs.add(centralArc);
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

	@Override
	public void update(Observable o, Object arg) {
		int iSlcArc = (int) arg;
		for (int i = 0; i < camembert.getMloItems().size(); i++) {
			Item oTmpItem = camembert.getMloItems().get(i);
			if (i == iSlcArc) {
				oTmpItem.setMbHighLights(true);
			} else {
				oTmpItem.setMbHighLights(false);
			}
		}
		repaint();
	}

}
