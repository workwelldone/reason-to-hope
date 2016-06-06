import java.util.stream.Collectors;

public class Atbash {
	
	public static String encode(String input) {
		int count = 1;
		String encoded = "";
		input = input.toLowerCase().trim().replaceAll("[^A-Za-z0-9]", "");
		for (int i = 0; i < input.length(); i++){
			encoded += encodeChar(input.charAt(i));
			if (count++ == 5 && i != input.length() - 1) {
				encoded += " ";
				count = 1;
			}
		}
		return encoded;
	}

	public static String decode(String input){
		input = input.replaceAll("[ ]", "");
		return input.chars()
			        .mapToObj(i -> "" + encodeChar((char)i))
			        .collect(Collectors.joining(""));
	}
	
	/** encode lower case letters */
	private static char encodeChar(char c) {
		if (Character.isDigit(c)) return c;
		if (c <= 'm') return (char)('m' - c + 'n'); 
		else return (char)('m' - (c - 'n'));
	}
}