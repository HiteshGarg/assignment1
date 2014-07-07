/**
 * @author hiteshgarg
 * This contains the data that is to be passed between classes for proccesing purpose
 */

package com.nagarro.training.assignment1.dto;

import java.util.*;

public class ItemDTO {

	private Map<String, String> dtoMap;
	boolean validatedProduct = false;

	public Map<String, String> getDtoMap() {
		return dtoMap;
	}

	public void setDtoMap(Map<String, String> dtoMap) {
		this.dtoMap = dtoMap;
	}

	public boolean getisValidatedProduct() {
		return validatedProduct;
	}

	public void setValidatedProduct(boolean validatedProduct) {
		this.validatedProduct = validatedProduct;
	}

}
