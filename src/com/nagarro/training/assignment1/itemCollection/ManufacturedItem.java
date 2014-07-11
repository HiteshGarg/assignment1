/**
 * @author hiteshgarg
 * 
 */
package com.nagarro.training.assignment1.itemCollection;

/*
 * This extends Item class and add calculate price for Manufactured items
 */
public class ManufacturedItem extends Item {

	@Override
	public float calculateCost() {
		float cost = getPrice();
		cost = (float) (cost + (0.125 * cost) + 0.2 * (cost + .125 * cost));
		return cost;
	}

}
