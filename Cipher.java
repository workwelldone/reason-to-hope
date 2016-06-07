import java.util.Random;

public class Cipher {

	private String key;
	private String message;
	private static final int SIMPLE_SHIFT = 3;
	private static final int AUTO_GENERATE_KEY_LENGTH = 100;
	
	public Cipher() {
		generateKey();
		message = "";
	}
	
	public Cipher(String key) {
		validate(key);
		this.key = key;
		message = "";
	}
	/**
	 * Do simple shift encoding of lower case letters only
	 * @param input message to process
	 * @param encode true to encode, false to decode
	 * @return encoded/decoded String
	 */
	private String simpleShift(boolean encode) {
		String result = "";
		for(int i = 0; i < message.length(); i++){
			result += charShift(message.charAt(i), (encode ? SIMPLE_SHIFT : -SIMPLE_SHIFT));
		}
		return result;
	}
	
	private void validate(String input) throws IllegalArgumentException {
		if (!input.equals(input.replaceAll("[^a-z]", "")) || input.isEmpty())
			throw new IllegalArgumentException();
	}
	
	/**
	 * Implements a simple Caesar cipher
	 * @param input lower case text to encode
	 * @return encoded text
	 */
	public String encodeSimpleShift(String input) {
		validate(input);
		message = input;
		return simpleShift(true);
	}
	
	/**
	 * Decodes a simple Caesar cipher
	 * @param input lower case Caesar cipher
	 * @return original decoded text
	 */
	public String decodeSimpleShift(String input) {
		validate(input);
		message = input;
		return simpleShift(false);
	}
	
	/**
	 * Performs single character shift, wrapping z-a/a-z as necessary.
	 * @param letter lower case letter
	 * @param shift steps to move, positive or negative
	 * @return shifted lower case letter
	 */
	private char charShift(char letter, int shift) {
		if (shift == 0) return letter;
		if (shift > 0) {
			int toZ = 'z' - letter;
			if (toZ < shift) return (char)('a' - 1 + shift - toZ);
			else return (char)(letter + shift);
		}
		
		// shift < 0
		int toA = letter - 'a';
		shift *= -1;
		if (toA < shift) return (char)('z' + 1 - shift + toA);
		else return (char)(letter - shift);
	}
	
	/**
	 * Performs substitution encoding/decoding based on key provided at instantiation.
	 * @param encode true to encode, false to decode
	 * @return encoded/decoded message
	 */
	private String substitutionShift(boolean encode) {
		String result = "";
		int keyPointer = 0;
		for(int i = 0; i < message.length(); i++){
			int keyShift = key.charAt(keyPointer++) - 'a';
			result += charShift(message.charAt(i), (encode ? keyShift : -keyShift));
			if (keyPointer == key.length()) keyPointer = 0;
		}
		return result;
	}
	
	/**
	 * Performs substitution encoding based on object map
	 * @param input lower case characters only
	 * @return encoded characters
	 */
	public String encode(String input) {
		validate(input);
		message = input;
		return substitutionShift(true);
	}
	
	/**
	 * Performs substitution decoding based on object map
	 * @param input encoded lower case characters
	 * @return decoded characters
	 */
	public String decode(String input) {
		validate(input);
		message = input;
		return substitutionShift(false);
	}
	
	public String getKey() {
		return key;
	}
	
	private void generateKey() {
		Random random = new Random();
		key = "";
		for(int i = 0; i < AUTO_GENERATE_KEY_LENGTH; i++) {
			key += (char)('a' + random.nextInt(26));
		}
	}
	
}