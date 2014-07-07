
/**
 * @author hiteshgarg
 * This class prints the final output as the list of the items,
 * Price, Tax and Final price
 */

package com.nagarro.training.assignment1.userInterface;


import java.util.Set;

import com.nagarro.training.assignment1.itemCollection.Item;


public class DisplayOutput {

	 static void displayFinalItemList(Set<Item> itemSet) {
		System.out
				.println("-------------------------------------------------------------------------------------");
		System.out.printf("|%-30s | %-15s | %-15s | %-15s|\n", "Item Name",
				"Item Price", "Tax Liabilities", "Final Price");
		System.out
				.println("-------------------------------------------------------------------------------------");

		for (Item item : itemSet) {

			System.out.printf("|%-30s | %-15.2f | %-15.2f | %-15.2f|\n",
					item.getName(), item.getPrice(), item.calculateCost()
							- item.getPrice(), item.calculateCost());
		}
	}

}
