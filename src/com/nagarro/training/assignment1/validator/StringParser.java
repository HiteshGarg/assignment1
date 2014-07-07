/**
 * @author hiteshgarg
 * 
 * This class is used to parse the string 
 * and break it into its components 
 * and return to the calling function in the form of Map
 */
package com.nagarro.training.assignment1.validator;

import java.util.HashMap;
import java.util.Map;

import com.nagarro.training.assignment1.constants.Constants;


public class StringParser {
	
	public static Map<String, String> parseString(String inputString) {
		
		Map<String, String> map = new HashMap<>();
		String[] localArray = inputString.substring(1).split(
				Constants.STRING_DELIMITTER);

		for (String x : localArray) {
			x = x.trim();
			if (x.contains(Constants.NAME_VALUE_SEPERATOR)) {
				String key = Constants.STRING_DELIMITTER
						+ x.substring(0, x.indexOf(Constants.NAME_VALUE_SEPERATOR)).trim();
				String value = x.substring(x.indexOf(Constants.NAME_VALUE_SEPERATOR) + 1).trim();
				map.put(key, value);
			} else {
				
				return null;
			}
		}
		return map;
	}

}
