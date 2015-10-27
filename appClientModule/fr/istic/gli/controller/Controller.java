package fr.istic.gli.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

import javax.swing.JTextField;

import fr.istic.gli.main.ConstantProperties;
import fr.istic.gli.main.TypeAction;
import fr.istic.gli.model.CamembertImpl;
import fr.istic.gli.model.Item;
import fr.istic.gli.view.ViewImpl;

public class Controller implements MouseListener, ActionListener {

	/**
	 * The model
	 */
	private ViewImpl moView;
	private TypeAction moTypeAction;

	/**
	 * 
	 */
	public Controller(ViewImpl poView, TypeAction poTypeAction) {
		super();
		this.moView = poView;
		this.moTypeAction = poTypeAction;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CamembertImpl oCamembert = moView.getCamembert();
		Point2D oPoint = moView.getMousePosition();
		int iSlcArc = moView.getArcPointClicked(oPoint);
		oCamembert.updateAddItem(iSlcArc);
		moView.repaint();
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
		CamembertImpl oCamembert = this.moView.getCamembert();
		int slcIdx = oCamembert.getSelectedIdx();
		if (TypeAction.ADD_ITEM.equals(this.moTypeAction)) {
			oCamembert.addItem("", "", 1);
			moView.repaint();
		} else if (TypeAction.PREV_ITEM.equals(this.moTypeAction)) {
			int iSlcItem = oCamembert.getSelectedIdx();
			if (iSlcItem <= 0) {
				iSlcItem = oCamembert.getMloItems().size() - 1;
			} else {
				iSlcItem--;
			}
			oCamembert.updateAddItem(iSlcItem);
			moView.repaint();
		} else if (TypeAction.NEXT_ITEM.equals(this.moTypeAction)) {
			int iSlcItem = oCamembert.getSelectedIdx();
			if (iSlcItem == oCamembert.getMloItems().size() - 1) {
				iSlcItem = 0;
			} else {
				iSlcItem++;
			}
			oCamembert.updateAddItem(iSlcItem);
			moView.repaint();
		} else {
			if (TypeAction.EDIT_ITEM.equals(this.moTypeAction)) {
				Item oEditItem = oCamembert.getMloItems().get(slcIdx);
				for (Component oComp : this.moView.getComponents()) {
					if (oComp != null && oComp.getName() != null) {
						JTextField oText = (JTextField) oComp;
						if(oComp.getName().equals(new StringBuilder(ConstantProperties.ITEM_TITLE).append(slcIdx).toString())) {
							oEditItem.setMsName(oText.getText());
						} else if(oComp.getName().equals(new StringBuilder(ConstantProperties.ITEM_DESCR).append(slcIdx).toString())) {
							oEditItem.setMsDescription(oText.getText());
						} else if(oComp.getName().equals(new StringBuilder(ConstantProperties.ITEM_VALUE).append(slcIdx).toString())) {
							if (oText.getText().matches("^-?\\d+$")) {
								oEditItem.setMiValue(Integer.parseInt(oText.getText()));
							}
						}
					}
				}
				oCamembert.updateItem(oEditItem);
				moView.repaint();
			}
		}
	}
	
}
