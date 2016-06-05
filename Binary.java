public class Binary {

	private String input;
	
	public Binary(String input) {
		this.input = input;
	}
	
	public int getDecimal() {
		if (!input.replaceAll("[^10]", "").equals(input)) return 0;
		
		int decimal = 0;
		int power = input.length() - 1;
		for (int i = 0; i < input.length(); i++ ) {
			decimal += Character.getNumericValue(input.charAt(i)) * Math.pow(2, power--);
		}
		return decimal;
	}
}