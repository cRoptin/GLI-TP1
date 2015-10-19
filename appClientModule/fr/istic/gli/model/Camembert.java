package fr.istic.gli.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 */
public class Camembert extends Model implements Observer {

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
	
	
	@Override
	public boolean addItem(String psTitle, String psDescr, int piValue) {
		boolean bAdded = super.addItem(psTitle, psDescr, piValue);
		// notify observer
		setChanged();
		notifyObservers();
		return bAdded;
	}
	
	@Override
	public void removeItem(int piIndex) {
		super.removeItem(piIndex);
		// notify observer
		setChanged();
		notifyObservers();
	}
	

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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
