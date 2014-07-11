/**
 * @author hiteshgarg
 * 
 */

package com.nagarro.training.assignment1.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.training.assignment1.constants.Constants;
import com.nagarro.training.assignment1.dto.ItemDTO;
import com.nagarro.training.assignment1.itemCollection.Item;
import com.nagarro.training.assignment1.validator.*;
/**
This class interacts with user
* Takes the input and sends it to the validator
* After validation it checks for product existence and updates it
* and then adds the product in Set if product is not found and input gets validated
* and finally calls proper function to print the output
*/
public class UserInteractor {

	private Set<Item> itemSet = new HashSet<>();

	public void getUserInput() {

		ItemDTO dto;
		InputValidator validator;
		Item item;
		boolean exist = false;
		Character choice = 'y';
		String userInput = new String("");

		System.out
				.println("To Enter details of the product\n"
						+ "(format is -name <itemname> and similar for price, quantity and type)\n"
						+ "(Start with the name)");

		while (choice == 'y' || choice == 'Y') {

			System.out.println("Please Enter the Product Details");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				userInput = br.readLine();
			} catch (IOException e) {

				System.out.println(Constants.IOException);
			}

			dto = InputValidator.validateUserInput(userInput);

			validator = new InputValidator();

			if (dto.getisValidatedProduct()) {

				// dto.setDtoMap(StringParser.parseString(userInput));
				exist = validator.itemExistence(itemSet, dto);

				if (!exist) {
					item = validator.addItemInList(dto);
					setitemSet(item);
				}
			}

			do {
				System.out
						.println(dto.getisValidatedProduct() ? "Do you want to enter details of any other item (y/n):"
								: "Want to enter product details again (y/n)");

				try {

					choice = br.readLine().charAt(0);

				} catch (IOException e) {

					System.out.println(Constants.IOException);
				} catch (StringIndexOutOfBoundsException e) {

					System.out.println("Please enter some Input");
				}
			} while (choice != 'y' && choice != 'n');
		}

		DisplayOutput.displayFinalItemList(itemSet);

	}

	public void setitemSet(Item item) {
		itemSet.add(item);
	}

	public Set<Item> getitemSet() {
		return itemSet;
	}

}
