package fr.istic.gli.model;

public class Item extends ItemModel {

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
}
