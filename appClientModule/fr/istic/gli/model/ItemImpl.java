package fr.istic.gli.model;

public class ItemImpl extends ItemModelImpl {

	@Override
	public boolean addItem(String psTitle, String psDescr, int piValue) {
		boolean bAdded = super.addItem(psTitle, psDescr, piValue);
		// notify observer
		notifyObservers();
		return bAdded;
	}
	
	@Override
	public void removeItem() {
		super.removeItem();
		// notify observer
		notifyObservers();
	}
}
