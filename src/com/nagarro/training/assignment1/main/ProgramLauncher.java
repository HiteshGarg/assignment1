
/**
 * @author hiteshgarg
 *This class is used to initialize the program
 *
 */
package com.nagarro.training.assignment1.main;

import com.nagarro.training.assignment1.userInterface.UserInteractor;

public class ProgramLauncher {

	public static void main(String[] args)
	{
		UserInteractor userInteractor = new UserInteractor();
		userInteractor.getUserInput();
		System.out.println("Thank You !!!");

	}
}
