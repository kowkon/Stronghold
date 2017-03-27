package people;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Peasant {

	private final int nameLength = 20;

	private String firstName;
	private String lastName;
	private char gender;

	/**
	 * Constructor with names
	 * 
	 * @param firstName
	 *            Peasant's first name.
	 * @param lastName
	 *            Peasant's last name.
	 */
	public Peasant(String firstName, String lastName) {
		this.gender = chooseGender();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Constructor without parameter. This constructor choose first name and
	 * last name randomly.
	 */
	public Peasant() {
		this.firstName = chooseFirstNameMale();
	}

	private String chooseFirstNameMale() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("firstNamesMale.txt", "r");
			long fileLength = file.length();
			int seekLength = nameLength + 1;
			int rows = (int) (fileLength / seekLength);
			Random rndm = new Random();
			file.seek(seekLength * rndm.nextInt(rows));
			return file.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * Choose random gender
	 * 
	 * @return 'm' or 'f'
	 */
	private char chooseGender() {
		Random rndm = new Random();
		return rndm.nextBoolean() ? 'm' : 'f';
	}

	// GETTERS AND SETTERS

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
