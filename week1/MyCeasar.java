package week1;

public class MyCeasar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static int k = 4;// shift step to the right of the alphabet

	public static char encryptChar(char c) {
		boolean isUpper = Character.isUpperCase(c);
		if (!isUpper) {
			c = Character.toUpperCase(c);
		}
		int index = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return c;
		} else {
			return (isUpper ? ALPHABET[(index + k) % 26] : Character.toLowerCase(ALPHABET[(index + k) % 26]));
		}
	}

	public static String encrypt(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result += encryptChar(s.charAt(i));
		}
		return result;
	}

	public static char decryptChar(char c) {
		boolean isUpper = Character.isUpperCase(c);
		if (!isUpper) {
			c = Character.toUpperCase(c);
		}
		int index = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			return c;
		} else {
			return (isUpper) ? ALPHABET[(index - k) % 26] : Character.toLowerCase(ALPHABET[(index - k) % 26]);
		}
	}

	public static String decrypt(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result += decryptChar(s.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "Hmm";
		System.out.println("Og string: " + s);
		System.out.println("Encryted string: " + encrypt(s));
		System.out.println("Decypted string: " + decrypt(encrypt(s)));
	}
}
