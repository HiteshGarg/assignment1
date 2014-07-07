/**
 * @author hiteshgarg
 * This class validates the input given by the user 
 * and adds the product in the Final List of Products
 * 
 * Here we use Map as a data structure keeping the future 
 * of the application in mind like change in the number of product specifications
 */
package com.nagarro.training.assignment1.validator;

import java.util.*;

import com.nagarro.training.assignment1.constants.Constants;
import com.nagarro.training.assignment1.dto.ItemDTO;
import com.nagarro.training.assignment1.itemCollection.ImportedItem;
import com.nagarro.training.assignment1.itemCollection.Item;
import com.nagarro.training.assignment1.itemCollection.ManufacturedItem;
import com.nagarro.training.assignment1.itemCollection.RawItem;

public class InputValidator {

	static public ItemDTO validateUserInput(String inputString) {

		ItemDTO dto = new ItemDTO();

		if (inputString.isEmpty()) {
			System.out.println(Constants.ERRORR_INPUT);
			dto.setDtoMap(null);
			return dto;
		}

		if (!inputString.startsWith(Constants.STRING_DELIMITTER
				+ Constants.NAME)) {
			System.out.println(Constants.ERROR_NAME_FIRST);
			dto.setDtoMap(null);
			return dto;
		}

		if (!inputString.contains(Constants.STRING_DELIMITTER + Constants.TYPE)) {
			System.out.println(Constants.ERROR_TYPE);
			dto.setDtoMap(null);
			return dto;
		}

		dto.setDtoMap(StringParser.parseString(inputString));

		if (dto.getDtoMap() == null) {
			System.out.println(Constants.ERRORR_INPUT);
			dto.setDtoMap(null);
			dto.setValidatedProduct(false);
			return dto;
		}

		for (Map.Entry<String, String> map : dto.getDtoMap().entrySet()) {
			switch (map.getKey()) {

			case Constants.STRING_DELIMITTER + Constants.NAME:
				dto.setValidatedProduct(validateName(map.getValue()));
				break;

			case Constants.STRING_DELIMITTER + Constants.TYPE:
				dto.setValidatedProduct(validateType(map.getValue()));
				break;

			case Constants.STRING_DELIMITTER + Constants.PRICE:
				dto.setValidatedProduct(validatePrice(map.getValue()));
				break;

			case Constants.STRING_DELIMITTER + Constants.QUANTITY:
				dto.setValidatedProduct(validateQuantity(map.getValue()));
				break;

			default:
				dto.setValidatedProduct(false);
				System.out.println(Constants.ERRORR_INPUT);
				break;
			}

			if (!dto.getisValidatedProduct()) {
				break;
			}
		}

		if (dto.getisValidatedProduct()) {
			return dto;
		} else {
			dto.setDtoMap(null);
			return dto;
		}
	}

	static boolean validateName(String name) {

		boolean nameValidate = false;
		if (!name.isEmpty()) {
			nameValidate = true;
		} else {
			System.out.println("Incorrect name. Please Try again");
		}
		return nameValidate;
	}

	static boolean validateType(String type) {

		boolean typeValidate = false;

		if (type.equalsIgnoreCase(Constants.RAW_ITEM)
				|| type.equalsIgnoreCase(Constants.MANUFACTURED_ITEM)
				|| type.equalsIgnoreCase(Constants.IMPORTED_ITEM)) {
			typeValidate = true;
		} else {
			System.out
					.println("incorrect Product type(Use only Raw, Manufactured or Imported)");
		}
		return typeValidate;
	}

	static boolean validatePrice(String price) {
		float cost = 0f;
		boolean priceValidate = true;
		try {
			cost = Float.parseFloat(price);
			if (cost < 0) {
				priceValidate = false;
				System.out.println("Invalid price. Please try again");
			}

		} catch (Exception e) {
			priceValidate = false;
			System.out.println("Invalid price. Please try again");
			// return priceValidate;
		}
		return priceValidate;
	}

	static boolean validateQuantity(String quantity) {
		int qty = 0;
		boolean quantityValidate = true;
		try {
			qty = Integer.parseInt(quantity);
			if (qty < 0) {
				quantityValidate = false;
				System.out.println("Invalid Quantity. Please try again");
			}
		} catch (Exception e) {
			// TODO: handle exception
			quantityValidate = false;
			System.out.println("Invalid Quantity. Please try again");
		}
		return quantityValidate;
	}

	public boolean itemExistence(Set<Item> itemSet, ItemDTO dto) {

		for (Item item : itemSet) {
			if (item.getName().equalsIgnoreCase(
					dto.getDtoMap().get(Constants.NAME))
					&& item.getType().equalsIgnoreCase(
							dto.getDtoMap().get(Constants.TYPE))) {
				if (dto.getDtoMap().containsKey(Constants.PRICE)) {
					item.setPrice(Float.parseFloat(dto.getDtoMap().get(
							Constants.PRICE)));
				}
				if (dto.getDtoMap().containsKey(Constants.QUANTITY)) {
					item.setQuantity(Integer.parseInt(dto.getDtoMap().get(
							Constants.QUANTITY)));
				}
				System.out.println("Item Exist Already.. Updated Successfully");
				return true;
			}
		}
		return false;
	}

	public Item addItemInList(ItemDTO dto) {
		Item itemList = null;

		if (dto.getDtoMap().get(Constants.TYPE)
				.equalsIgnoreCase(Constants.RAW_ITEM)) {
			itemList = new RawItem();
		} else if (dto.getDtoMap().get(Constants.TYPE)
				.equalsIgnoreCase(Constants.MANUFACTURED_ITEM)) {
			itemList = new ManufacturedItem();
		} else if (dto.getDtoMap().get(Constants.TYPE)
				.equalsIgnoreCase(Constants.IMPORTED_ITEM)) {
			itemList = new ImportedItem();
		}
		itemList.setName(dto.getDtoMap().get(Constants.NAME));
		itemList.setType(dto.getDtoMap().get(Constants.TYPE));

		if (dto.getDtoMap().containsKey(Constants.PRICE)) {
			itemList.setPrice(Float.parseFloat(dto.getDtoMap().get(
					Constants.PRICE)));
		}

		if (dto.getDtoMap().containsKey(Constants.QUANTITY)) {
			itemList.setQuantity(Integer.parseInt(dto.getDtoMap().get(
					Constants.QUANTITY)));
		}
		System.out.println("Item Added Successfully");

		return itemList;
	}

}
