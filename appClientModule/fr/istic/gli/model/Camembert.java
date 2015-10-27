package fr.istic.gli.model;

import java.util.List;

public interface Camembert {
	
	/**
	 * Add an new item
	 * @param psTitle the title : String
	 * @param psDescription the description : String
	 * @param piValue the value : superior or equal to 0 integer
	 */
	public boolean addItem(String psTitle, String psDescription, int piValue);

	/**
	 * Remove an item from the camembert
	 * @param index of the arc to remove
	 */
	public void removeItem(int piIndex);
	
	/**
	 * Found the selected arc index
	 * @return the arc index (int)
	 */
	public int getSelectedIdx();
	
	/**
	 * Update item to select the good item
	 * @param piSlcArc
	 */
	public void updateAddItem(int piSlcArc);
	
	/**
	 * Update an item of camembert
	 * @param poUpdItem
	 */
	public void updateItem(Item poUpdItem);

	/**
	 * Get the item title
	 * @return the msTitle
	 */
	public String getMsTitle();

	/**
	 * Set the item title
	 * @param msTitle the msTitle to set
	 */
	public void setMsTitle(String msTitle);

	/**
	 * Get the item value
	 * @return the miValue
	 */
	public int getMiValue();

	/**
	 * Set the item value
	 * @param miValue the miValue to set
	 */
	public void setMiValue(int miValue);

	/**
	 * Calcul of part pourcentage
	 * @param piIndex : Index of the element
	 * @return the pourcentage
	 */
	public float getPourcentage(int piIndex);

	public List<Item> getMloItems();

	public void initSelection();
}
