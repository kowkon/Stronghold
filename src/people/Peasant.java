package people;

import java.io.RandomAccessFile;
import java.util.Random;

public class Peasant {

	private final static int firstNameLength = 20;
	private final static int lastNameLength = 20;

	private String firstName;
	private String lastName;
	private String gender;

	/**
	 * Constructor without parameter. This constructor chooses first name, last
	 * name and gender randomly.
	 */
	public Peasant() {
		this.gender = chooseGender();
		this.firstName = chooseFirstName(this.gender);
		this.lastName = chooseLastName();
	}

	/**
	 * Chooses a random first name according to gender.
	 * 
	 * @param gender
	 *            that defines which file will be opened.
	 * @return Chosen random first name.
	 */
	private String chooseFirstName(String gender) {
		String result = "";
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("firstNames" + gender + ".txt", "r");
			long fileLength = file.length();
			int seekLength = firstNameLength + 1;
			int rows = (int) (fileLength / seekLength);
			Random rndm = new Random();
			file.seek(seekLength * rndm.nextInt(rows));
			result = file.readLine();
			result = removeBlanks(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	/**
	 * Chooses a random last name.
	 * 
	 * @return Chosen random last name.
	 */
	private String chooseLastName() {
		String result = "";
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("lastNames.txt", "r");
			long fileLength = file.length();
			int seekLength = lastNameLength + 1;
			int rows = (int) (fileLength / seekLength);
			Random rndm = new Random();
			file.seek(seekLength * rndm.nextInt(rows));
			result = file.readLine();
			result = removeBlanks(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Removes blanks from the given string.
	 * 
	 * @param s
	 *            String that blanks will be removed from.
	 * @return String that has no blank.
	 */
	private String removeBlanks(String s) {
		String result = s;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				result = s.substring(0, i);
				break;
			}
		}
		return result;
	}

	/**
	 * Choose random gender
	 * 
	 * @return 'm' or 'f'
	 */
	private String chooseGender() {
		Random rndm = new Random();
		return rndm.nextBoolean() ? "Male" : "Female";
	}

	// GETTERS AND SETTERS

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

}
