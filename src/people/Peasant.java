package people;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Peasant {

	private static ArrayList<String> firstNames = new ArrayList<>();
	private static ArrayList<String> lastNames = new ArrayList<>();
	private static boolean namesLoaded = false;

	private String firstName;
	private String lastName;

	/**
	 * Constructor with names
	 * 
	 * @param firstName
	 *            Peasant's first name.
	 * @param lastName
	 *            Peasant's last name.
	 */
	public Peasant(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Constructor without parameter. This constructor choose first name and
	 * last name randomly.
	 */
	public Peasant() {
		if (!namesLoaded) { // check if names are loaded
			getFirstNames();
			getLastNames();
			namesLoaded = true; // names are loaded
		}
		this.firstName = chooseFirstName();
		this.lastName = chooseLastName();
	}

	/**
	 * Loads first names.
	 */
	private void getFirstNames() {
		File names = new File("firstNames.txt");
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(names);
			while (inputStream.hasNextLine())
				firstNames.add(inputStream.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	/**
	 * Loads last names.
	 */
	private void getLastNames() {
		File names = new File("lastNames.txt");
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(names);
			while (inputStream.hasNextLine())
				lastNames.add(inputStream.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	/**
	 * Chooses a random first name from the list.
	 * 
	 * @return Random first name.
	 */
	private String chooseFirstName() {
		Random rndm = new Random();
		return firstNames.get(rndm.nextInt(firstNames.size()));
	}

	/**
	 * Chooses a random last name from the list.
	 * 
	 * @return Random last name.
	 */
	private String chooseLastName() {
		Random rndm = new Random();
		return lastNames.get(rndm.nextInt(lastNames.size()));
	}

	// GETTERS AND SETTERS

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
