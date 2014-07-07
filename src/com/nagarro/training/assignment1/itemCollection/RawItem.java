/**
 * @author hiteshgarg
 * 
 * This extends Item class and add calculate price for Raw items
 */
package com.nagarro.training.assignment1.itemCollection;

public class RawItem extends Item {

	@Override
	public float calculateCost() {
		float cost = getPrice();
		cost = (float)(cost + (0.125* cost));

		return cost;
	}
}
