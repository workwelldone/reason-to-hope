public class Hexadecimal {

	public static int toDecimal(String input) {
		input = input.toUpperCase();
		if (!input.equals(input.replaceAll("[^0-9A-F]", ""))) return 0;
		
		int pow = input.length() - 1;
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			sum += getCharValue(input.charAt(i)) * Math.pow(16, pow--);
		}
		return sum;
	}
	
	private static int getCharValue(char c) {
		if (Character.isDigit(c)) return Character.getNumericValue(c);
		else return c - 55; // char value of A is 65
	}
}
