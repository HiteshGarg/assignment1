/**
 * Contains the Data structure of items 
 * and is and abstract so that more specific types 
 * can extend it and add their type pecific features 
 */

package com.nagarro.training.assignment1.itemCollection;

public abstract class Item {

	private String name;
	private String type;
	private int quantity = 0;
	private float price = 0f;
//	private float finalPrice = 0f;

	public abstract float calculateCost();

//	/**
//	 * @return the finalPrice
//	 */
//	public float getFinalPrice() {
//		return finalPrice;
//	}
//
//	/**
//	 * @param finalPrice the finalPrice to set
//	 */
//	public void setFinalPrice(float finalPrice) {
//		this.finalPrice = finalPrice;
//	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}
