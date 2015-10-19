package fr.istic.gli.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 */
public class Camembert extends Model implements Observer {

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
	
	public List<Item> getMloItems() {
		return super.getMloItems();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
