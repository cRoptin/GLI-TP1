package fr.istic.gli.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ItemModelImpl extends Observable {
	
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
	 * The item's description
	 */
	private String msDescription;
	/**
	 * The item's value
	 */
	private int miValue;
	/**
	 * List of items containing by main item
	 */
	private List<ItemModelImpl> ploItems;

	/**
	 * Add an new item
	 * @param psTitle the title : String
	 * @param psDescription the description : String
	 * @param piValue the value : superior or equal to 0 integer
	 */
	public boolean addItem(String psTitle, String psDescription, int piValue) {
		boolean bAdded = false;
		if (piValue >= 0) {
			ItemModelImpl oNewItem = new ItemModelImpl();
			String sNewTitle = psTitle;
			if ("".equals(sNewTitle)) {
				sNewTitle = DEFAULT_TITLE;
			}
			oNewItem.setMsTitle(sNewTitle);
			
			String sNewDescr = psDescription;
			if ("".equals(sNewDescr)) {
				sNewDescr = DEFAULT_DESCR;
			}
			oNewItem.setMsDescription(sNewDescr);
			oNewItem.setMiValue(piValue);
			if (this.ploItems == null) {
				this.ploItems = new ArrayList<ItemModelImpl>();
			}
			this.ploItems.add(oNewItem);
			bAdded = true;
		}
		return bAdded;
	}
	
	public void removeItem() {
		
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
	 * Get the item description 
	 * @return the msDescription
	 */
	public String getMsDescription() {
		return msDescription;
	}

	/**
	 * Set the item description
	 * @param msDescription the msDescription to set
	 */
	public void setMsDescription(String msDescription) {
		this.msDescription = msDescription;
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
	
}
