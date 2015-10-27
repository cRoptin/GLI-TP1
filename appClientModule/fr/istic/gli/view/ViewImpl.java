package fr.istic.gli.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import fr.istic.gli.controller.Controller;
import fr.istic.gli.main.ConstantProperties;
import fr.istic.gli.main.TypeAction;
import fr.istic.gli.model.CamembertImpl;
import fr.istic.gli.model.Item;

/**
 * The Class View.
 */
public class ViewImpl extends JComponent implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -542653201176862734L;

	/**
	 *  The angle. 
	 */
	private float angle = 0;

	/**
	 * The model
	 */
	private CamembertImpl camembert;

	/**
	 *  The list arcs.
	 */
	private List<Arc2D> listArcs;

	/**
	 * 
	 */
	private static Graphics2D g2;

	/**
	 * 
	 */
	private final int iStdSize = 400;
	/**
	 * 
	 */
	private final int iExtSize = 20;

	/**
	 * Instantiates a new view.
	 */
	public ViewImpl() {
		listArcs = new ArrayList<Arc2D>();
	}

	@Override
	public void initCamembert() {
		CamembertImpl initCam= new CamembertImpl();
		initCam.setMsTitle("Camembert");
		initCam.addItem("", "", 1);
		initCam.initSelection();
		setCamembert(initCam);
	}
	
	@Override
	public CamembertImpl getCamembert() {
		return camembert;
	}

	@Override
	public void setCamembert(CamembertImpl camembert) {
		this.camembert = camembert;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;

		CamembertImpl camembert = this.getCamembert();
		List<Item> elements = camembert.getMloItems();

		this.removeAll();

		listArcs = new ArrayList<Arc2D>();

		// Calcul la taille des arcs et les ajoute à la view
		for (int i = 0; i < elements.size(); i++) {
			float pourcentage = (float) camembert.getPourcentage(i) * 3.6f;

			int iSize = iStdSize;
			if (elements.get(i).getMbHighLights()) {
				iSize += iExtSize;
			}
			Color tmpColor = new Color(new Random().nextInt());
			if(elements.get(i).getMcColor() != null){
				tmpColor = elements.get(i).getMcColor();
			}
			else{
				elements.get(i).setMcColor(tmpColor);
			}
			Arc2D.Double arc = new Arc2D.Double(50 - ((iSize - iStdSize) / 2), 50 - ((iSize - iStdSize) / 2), iSize, iSize, angle, pourcentage, Arc2D.PIE);
			g2.setColor(tmpColor);
			g2.fill(arc);

			if (elements.get(i).getMbHighLights()) {

				JTextField oTitleField = new JTextField();
				oTitleField.addActionListener(new Controller(this, TypeAction.EDIT_ITEM));
				oTitleField.setText(elements.get(i).getMsName());
				oTitleField.setName(ConstantProperties.ITEM_TITLE + i);
				JTextField oValueField = new JTextField();
				oValueField.setText(String.valueOf(elements.get(i).getMiValue()));
				oValueField.addActionListener(new Controller(this, TypeAction.EDIT_ITEM));
				oValueField.setName(ConstantProperties.ITEM_VALUE + i);
				JTextField oDescrField = new JTextField();
				oDescrField.setText(elements.get(i).getMsDescription());
				oDescrField.addActionListener(new Controller(this, TypeAction.EDIT_ITEM));
				oDescrField.setName(ConstantProperties.ITEM_DESCR + i);

				double dXPoint = arc.getBounds2D().getX();
				double dYPoint = arc.getBounds2D().getY();

				if (dXPoint < 90 && dYPoint < 90) {
					oTitleField.setBounds(10, 30, 80, 20);
					oValueField.setBounds(10, 50, 80, 20);
					oDescrField.setBounds(10, 70, 80, 40);
				}
				if (dXPoint > 90 && dYPoint < 90) {
					oTitleField.setBounds(430, 30, 80, 20);
					oValueField.setBounds(430, 50, 80, 20);
					oDescrField.setBounds(430, 70, 80, 40);
				}
				if (dXPoint < 90 && dYPoint > 90) {
					oTitleField.setBounds(10, 470, 80, 20);
					oValueField.setBounds(10, 490, 80, 20);
					oDescrField.setBounds(10, 510, 80, 40);
				}
				if (dXPoint > 90 && dYPoint > 90) {
					oTitleField.setBounds(430, 470, 80, 20);
					oValueField.setBounds(430, 490, 80, 20);
					oDescrField.setBounds(430, 510, 80, 40);
				}
				this.add(oTitleField);
				this.add(oValueField);
				this.add(oDescrField);
			}

			angle += pourcentage;
			listArcs.add(arc);
		}

		Arc2D.Double blanckArc = new Arc2D.Double(110, 110, 280, 280, 0, 360, Arc2D.PIE);
		g2.setColor(Color.WHITE);
		g2.fill(blanckArc);

		Arc2D.Double centralArc = new Arc2D.Double(175, 175, 150, 150, 0, 360, Arc2D.PIE);
		g2.setColor(Color.BLACK);
		g2.fill(centralArc);

		JTextPane oGlbText = new JTextPane();
		String sCentralTxt = camembert.getMsTitle() + "\r\n" + String.valueOf(camembert.getMiValue());
		oGlbText.setText(sCentralTxt);
		oGlbText.setForeground(Color.WHITE);
		oGlbText.setEditable(false);
		oGlbText.setBounds(200, 200, 100, 100);
		oGlbText.setBackground(Color.BLACK);
		oGlbText.setBorder(null);
		StyledDocument doc = oGlbText.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		
		
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		
		this.add(oGlbText);

		listArcs.add(blanckArc);

		listArcs.add(centralArc);
	}

	@Override
	public int getArcPointClicked(Point2D poPoint) {
		if (poPoint != null) {
			for (int i = 0; i < listArcs.size(); i++) {
				if (listArcs.get(i).contains(poPoint.getX(), poPoint.getY())) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}

}
