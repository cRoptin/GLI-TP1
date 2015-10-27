package fr.istic.gli.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class CamembertImpl implements Camembert {
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

	@Override
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
			oNewItem.setMbHighLights(true);
			bAdded = true;
			this.miValue += piValue;
			if (this.loItems == null) {
				this.loItems = new ArrayList<Item>();
			}
			initSelection();
			this.loItems.add(oNewItem);
		}
		return bAdded;
	}

	@Override
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
	
	@Override
	public int getSelectedIdx() {
		int iRes = -1;
		if (this.getMloItems() != null && this.getMloItems().size() > 0) {
			for (int iIdx = 0; iIdx < this.getMloItems().size(); iIdx++) {
				if (this.getMloItems().get(iIdx).getMbHighLights()) {
					iRes = iIdx;
				}
			}
		}
		return iRes;
	}
	
	/**
	 * Update the total value of a camembert
	 */
	private void calculTotal() {
		int total = 0;
		for (Item oItem : this.getMloItems()) {
			total += oItem.getMiValue();
		}
		this.setMiValue(total);
	}
	
	@Override
	public void updateAddItem(int piSlcArc) {
		for (int i = 0; i < this.getMloItems().size(); i++) {
			Item oTmpItem = this.getMloItems().get(i);
			if (i == piSlcArc) {
				oTmpItem.setMbHighLights(true);
			} else {
				oTmpItem.setMbHighLights(false);
			}
		}
	}
	
	@Override
	public void updateItem(Item poUpdItem) {
		int iSlcIdx = getSelectedIdx();
		if (poUpdItem.getMiValue() == 0) {
			removeItem(iSlcIdx);
		} else {
			this.getMloItems().set(iSlcIdx, poUpdItem);
		}
		calculTotal();
	}

	@Override
	public String getMsTitle() {
		return msTitle;
	}

	@Override
	public void setMsTitle(String msTitle) {
		this.msTitle = msTitle;
	}

	@Override
	public int getMiValue() {
		return miValue;
	}

	@Override
	public void setMiValue(int miValue) {
		this.miValue = miValue;
	}

	@Override
	public float getPourcentage(int piIndex) {
		float fRes = 0;
		int iPartValue = 0;
		if (loItems != null && loItems.size() >= piIndex && loItems.get(piIndex) != null) {
			iPartValue = loItems.get(piIndex).getMiValue();
		}
		fRes = (float) (iPartValue * 100) / this.miValue;
		return fRes;
	}

	@Override
	public List<Item> getMloItems() {
		return this.loItems;
	}

	@Override
	public void initSelection() {
		if (this.loItems != null) {
			for (int iIdx = 0; iIdx < this.loItems.size(); iIdx++) {
				Item tmpItem = this.loItems.get(iIdx);
				tmpItem.setMbHighLights(false);
				this.loItems.set(iIdx, tmpItem);
			}
		}
	}
}