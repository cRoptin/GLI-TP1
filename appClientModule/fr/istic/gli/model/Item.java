package fr.istic.gli.model;

public class Item {

	/**
	 * The item name
	 */
	private String msName = "";
	/**
	 * The item description
	 */
	private String msDescription = "";
	/**
	 * The item value
	 */
	private int miValue = 0;
	/**
	 * True if selected
	 */
	private boolean mbHighLights = false;
	
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
	 * @return the msDescription
	 */
	public String getMsDescription() {
		return msDescription;
	}
	/**
	 * @param msDescription the msDescription to set
	 */
	public void setMsDescription(String msDescription) {
		this.msDescription = msDescription;
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
	 * @return the mbHighLights
	 */
	public boolean getMbHighLights() {
		return mbHighLights;
	}
	/**
	 * @param mbHighLights the mbHighLights to set
	 */
	public void setMbHighLights(boolean mbHighLights) {
		this.mbHighLights = mbHighLights;
	}
	
}
