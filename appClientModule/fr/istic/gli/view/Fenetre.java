package fr.istic.gli.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import fr.istic.gli.controller.Controller;
import fr.istic.gli.model.Camembert;
import fr.istic.gli.model.Item;

/**
 * The Class Fenetre.
 */
public class Fenetre extends JFrame {
		
	/** The title. */
	private JLabel title = new JLabel();
	
	/**
	 * The add button
	 */
	private JButton btnAdd = new JButton("Ajouter");
	
	/** The view. */
	private View view;
	
	/** The model. */
	final Camembert camembert;

	/**
	 * Instantiates a new fenetre.
	 */
	public Fenetre() {
		this.setTitle("mon stock");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Dessine le graphe représentant le stock
		this.camembert = new Camembert();
		this.camembert.addItem("livre", "", 40);
		this.camembert.addItem("tasse", "", 10);
		this.camembert.addItem("crayon", "", 50);
		this.camembert.addItem("gomme", "", 40);
		this.camembert.addItem("colle", "", 10);
		this.camembert.addItem("camembert", "", 50);
		
		title.setText(" ");
		this.getContentPane().add(title, BorderLayout.SOUTH);
		//btnAdd.addMouseListener(new Controller());
		this.getContentPane().add(btnAdd, BorderLayout.SOUTH);

		this.addMouseListener(new Controller(this.camembert));
		
		view = new View();
		view.setCamembert(camembert);

		this.getContentPane().add(view);

		//this.getContentPane().add(new JScrollPane(camembert), BorderLayout.EAST);
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView() {
		return view;
	}
	
	
	/**
	 * Handle mouse click.
	 *
	 * @param p the p
	 */
	public void handleMouseClick(Point2D p) {
		/*int index = view.getArcPointClicked(p);
		if (index != -1) {
			title.setText("produit : " + model.getElements().get(index).getName()
					+ " - " + " nombre en stock : " + model.getElements().get(index).getValue());
			revalidate();
		}*/
	}


}
