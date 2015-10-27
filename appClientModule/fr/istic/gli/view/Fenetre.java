package fr.istic.gli.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import fr.istic.gli.controller.Controller;
import fr.istic.gli.main.TypeAction;

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
	
	/**
	 *  The view. 
	 */
	private View view;

	/**
	 * Instantiates a new fenetre.
	 */
	public Fenetre() {
		this.setTitle("mon stock");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title.setText(" ");
		this.getContentPane().add(title, BorderLayout.SOUTH);

		view = new View();
		view.initCamembert();
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new Controller(view, TypeAction.ADD_ITEM));
		this.getContentPane().add(btnAdd, BorderLayout.SOUTH);
		
		JButton btnPrev = new JButton("-");
		btnPrev.addActionListener(new Controller(view, TypeAction.PREV_ITEM));
		btnPrev.setBounds(180, 480, 50, 50);
		this.getContentPane().add(btnPrev);
		
		JButton btnNext = new JButton("+");
		btnNext.addActionListener(new Controller(view, TypeAction.NEXT_ITEM));
		btnNext.setBounds(280, 480, 50, 50);
		this.getContentPane().add(btnNext);
		
		view.addMouseListener(new Controller(this.view, null));

		this.getContentPane().add(view);
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
