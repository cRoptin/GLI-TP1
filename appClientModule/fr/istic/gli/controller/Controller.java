package fr.istic.gli.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import fr.istic.gli.main.ConstantProperties;
import fr.istic.gli.main.TypeAction;
import fr.istic.gli.model.Camembert;
import fr.istic.gli.view.View;

public class Controller implements MouseListener, ActionListener {

	/**
	 * The model
	 */
	private View moView;
	private TypeAction moTypeAction;

	/**
	 * 
	 */
	public Controller(View poView, TypeAction poTypeAction) {
		super();
		this.moView = poView;
		this.moTypeAction = poTypeAction;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point2D oPoint = moView.getMousePosition();
		int iSlcArc = moView.getArcPointClicked(oPoint);
		moView.update(null, iSlcArc);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Camembert tmpCamembert = this.moView.getCamembert();
		int slcIdx = tmpCamembert.getSelectedIdx();
		if (TypeAction.ADD_ITEM.equals(this.moTypeAction)) {
			tmpCamembert.addItem("", "", 1);
			moView.repaint();
		} else {
			if (TypeAction.EDIT_TITLE.equals(this.moTypeAction)) {
				for (Component oComp : this.moView.getComponents()) {
					if (oComp != null && oComp.getName() != null
							&& oComp.getName().equals(new StringBuilder(ConstantProperties.ITEM_TITLE).append(slcIdx).toString())) {
						JTextField oText = (JTextField) oComp;
						System.out.println(oText.getText());
					}
				}
			}
		}
	}
	
}
