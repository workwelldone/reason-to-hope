public class Octal {

	private final String input;

	public Octal(String input) {
		this.input = input;
	}

	public int getDecimal() {
		if (!input.matches("[0-7]+")) return 0;
		
		int pow = input.length() - 1;
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			sum += getCharValue(input.charAt(i)) * Math.pow(8, pow--);
		}
		return sum;
	}
	
	private static int getCharValue(char c) {
		if (Character.isDigit(c)) return Character.getNumericValue(c);
		else return c - 55;
	}
}