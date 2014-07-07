/**
 * @author hiteshgarg
 * 
 * This extends Item class and add calculate price for imported items
 */
package com.nagarro.training.assignment1.itemCollection;

public class ImportedItem extends Item {

	@Override
	public float calculateCost() {
		float cost = getPrice();
		cost = (float) (cost + (0.125 * cost) + (.1 * cost));

		if (cost > 0) {
			if (cost <= 100) {
				cost += 5;
			} else if (cost <= 200) {
				cost += 10;
			} else {
				cost = (float) (cost + (0.05 * cost));
			}
		}
		return cost;

	}

}
