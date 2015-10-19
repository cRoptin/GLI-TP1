package fr.istic.gli.model;

import java.util.List;

/**
 * 
 */
public class Camembert {

	/**
	 * The name
	 */
	private String msName = "";
	
	/**
	 * The value
	 */
	private int miValue = 0;
	
	/**
	 * The list of items
	 */
	private List<Item> loItems = null;

	/**
	 * @return the msName
	 */
	public String getMsName() {
		return msName;
	}

	/**
	 * @param msName the msName to set
	 */
	public void setMsName(String msName) {
		this.msName = msName;
	}

	/**
	 * @return the miValue
	 */
	public int getMiValue() {
		return miValue;
	}

	/**
	 * @param miValue the miValue to set
	 */
	public void setMiValue(int miValue) {
		this.miValue = miValue;
	}

	/**
	 * @return the loItems
	 */
	public List<Item> getLoItems() {
		return loItems;
	}

	/**
	 * @param loItems the loItems to set
	 */
	public void setLoItems(List<Item> loItems) {
		this.loItems = loItems;
	}
}
