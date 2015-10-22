package fr.istic.gli.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 */
public class Camembert extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Default value for items title
	 */
	private static final String DEFAULT_TITLE = "<Title>";
	/**
	 * Default value for items description
	 */
	private static final String DEFAULT_DESCR = "<Description>";
	/**
	 * The item's title
	 */
	private String msTitle;
	/**
	 * The item's value
	 */
	private int miValue;
	/**
	 * The list of items
	 */
	private List<Item> loItems = null;
	
	/**
	 * Add an new item
	 * @param psTitle the title : String
	 * @param psDescription the description : String
	 * @param piValue the value : superior or equal to 0 integer
	 */
	public boolean addItem(String psTitle, String psDescription, int piValue) {
		boolean bAdded = false;
		if (piValue >= 0) {
			Item oNewItem = new Item();
			String sNewTitle = psTitle;
			if ("".equals(sNewTitle)) {
				sNewTitle = DEFAULT_TITLE;
			}
			oNewItem.setMsName(sNewTitle);
			
			String sNewDescr = psDescription;
			if ("".equals(sNewDescr)) {
				sNewDescr = DEFAULT_DESCR;
			}
			oNewItem.setMsDescription(sNewDescr);
			oNewItem.setMiValue(piValue);
			bAdded = true;
			this.miValue += piValue;
			if (this.loItems == null) {
				this.loItems = new ArrayList<Item>();
			}
			this.loItems.add(oNewItem);
		}
		return bAdded;
	}
	
	public void removeItem(int piIndex) {
		if (this.loItems != null && this.loItems.size() > 0) {
			for (int iIdx = 0; iIdx < loItems.size(); iIdx++) {
				if (iIdx == piIndex) {
					this.loItems.remove(iIdx);
					this.miValue -= loItems.get(iIdx).getMiValue();
				}
			}
		}
	}
	
	/**
	 * Get the item title
	 * @return the msTitle
	 */
	public String getMsTitle() {
		return msTitle;
	}

	/**
	 * Set the item title
	 * @param msTitle the msTitle to set
	 */
	public void setMsTitle(String msTitle) {
		this.msTitle = msTitle;
	}

	/**
	 * Get the item value
	 * @return the miValue
	 */
	public int getMiValue() {
		return miValue;
	}

	/**
	 * Set the item value
	 * @param miValue the miValue to set
	 */
	public void setMiValue(int miValue) {
		this.miValue = miValue;
	}
	
	/**
	 * Calcul of part pourcentage
	 * @param piIndex : Index of the element
	 * @return the pourcentage
	 */
	public float getPourcentage(int piIndex) {
		float fRes = 0;
		int iPartValue = 0;
		if (loItems != null && loItems.size() >= piIndex && loItems.get(piIndex) != null) {
			iPartValue = loItems.get(piIndex).getMiValue();
		}
		fRes = (iPartValue * 100) / this.miValue;
		return fRes;
	}
	
	public List<Item> getMloItems() {
		return this.loItems;
	}

}