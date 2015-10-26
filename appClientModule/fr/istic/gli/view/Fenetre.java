package fr.istic.gli.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import fr.istic.gli.controller.Controller;
import fr.istic.gli.main.TypeAction;
import fr.istic.gli.model.Camembert;

/**
 * The Class Fenetre.
 */
public class Fenetre extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4175199347831090483L;

	/** The title. */
	private JLabel title = new JLabel();
	
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
		camembert.setMsTitle("Camembert");
		this.camembert.addItem("livre", "", 10);
		this.camembert.addItem("tasse", "", 10);
		this.camembert.addItem("crayon", "", 10);
		this.camembert.addItem("gomme", "", 10);
		this.camembert.addItem("pbs", "", 10);
		this.camembert.addItem("pb", "", 10);
		
		this.camembert.initSelection();
		
		title.setText(" ");
		this.getContentPane().add(title, BorderLayout.SOUTH);

		view = new View();
		view.setCamembert(camembert);
		JButton newBtn = new JButton("Ajouter");
		newBtn.addActionListener(new Controller(view, TypeAction.ADD_ITEM));
		this.getContentPane().add(newBtn, BorderLayout.SOUTH);
		
		view.addMouseListener(new Controller(this.view, null));

		this.getContentPane().add(view);

		this.getContentPane().add(new JScrollPane(camembert), BorderLayout.EAST);
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView() {
		return view;
	}


}
