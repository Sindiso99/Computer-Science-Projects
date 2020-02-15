/**
 * Rotates the characters of a String by 'n' number of letters
 * Where n is between 1 and 25
 * @author Sindiso Sibanda
 * @version 1.0
 */
public class Rotation {

	private char[] charRotation;
	private String newWord;
	private int rotation;
	private boolean valid = true;

	/**
	 * Commences the rotation algorithm
	 * 
	 * @param word String to be rotated
	 * @param rotation Number of letters String should be rotated by
	 */
	public Rotation(String word, int rotation) {
		this.rotation = checkRotation(rotation);
		readWord(word);
		rotateChar();
	}

	/**
	 * Checks that the rotation value is within the correct range
	 * 
	 * @param newRotation the rotation value
	 * @return the rotation value after validation
	 */
	private int checkRotation(Integer newRotation) {
		// if the input is outside the correct range, an error value of 0 is used
		if (newRotation < 1 || newRotation > 25) {
			// input is flagged as invalid for error handling
			valid = false;
			return 0;
		} else {
			return newRotation;
		}
	}

	/**
	 * Checks that a string has been input and handles an invalid rotation error
	 * 
	 * @param word the String to be changed
	 */
	private void readWord(String word) {
		if (word.equals(null) || !valid) {
			// String is altered to error message to be output to user
			word = "Incorrect Input";
		}
		//String is converted to characters in an array of type char
		char[] stringToChar = word.toCharArray();
		charRotation = stringToChar;

	}
	
	/**
	 * Runs through the character array and alters the characters accordingly
	 */
	private void rotateChar() {
		int curAscii;//the decimal Ascii value of the current character
		for (int x = 0; x < charRotation.length; x++) {
			curAscii = (int) charRotation[x];
			if (curAscii > 64 && curAscii < 91) { // Checking if the current character is an uppercase
				if (curAscii + rotation > 90) {
					// The code is first checking if the rotation value will put the character
					// outside of
					// its "alphabetical value" on the ASCII table.
					// If it is then it wraps round to the first letter of the alphabet until the
					// correct new character is found
					charRotation[x] = (char) (curAscii + rotation - 90 + 64);
				} else {
					curAscii += rotation;
					// assign the character it's new character based on rotation
					charRotation[x] = (char) curAscii;
				}
			}
			if (curAscii > 96 && curAscii < 123) { // Checking if the current character is a lowercase
				if (curAscii + rotation > 122) {
					// Similar to the above lines I am making sure the lower case letters stay
					// within the correct range
					charRotation[x] = (char) (curAscii + rotation - 122 + 96);
				} else {
					curAscii += rotation;
					charRotation[x] = (char) curAscii;
				}
			}
		}
		//the result of the rotation on the character array are assigned to a string
		newWord = new String(charRotation);
	}

	/**
	 * 
	 * @return the String after rotation has been performed
	 */
	public String getNewWord() {
		return newWord;
	}

}
