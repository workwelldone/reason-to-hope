import java.util.Random;

public class Cipher {

	private String key;
	private String message;
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
	
	private void validate(String input) throws IllegalArgumentException {
		if (!input.matches("[a-z]+"))
			throw new IllegalArgumentException();
	}
	
	private char charShift(char letter, int shift) {
		if (shift == 0) return letter;
		if (shift > 0) {
			int toZ = 'z' - letter;
			if (toZ < shift) return (char)('a' - 1 + shift - toZ);
			else return (char)(letter + shift);
		}
		
		// shift to left
		int toA = letter - 'a';
		shift *= -1;
		if (toA < shift) return (char)('z' + 1 - shift + toA);
		else return (char)(letter - shift);
	}
	
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
	
	public String encode(String input) {
		validate(input);
		message = input;
		return substitutionShift(true);
	}
	
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
