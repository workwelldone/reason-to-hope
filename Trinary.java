class Trinary {

	public static int toDecimal(String input) {
		if (!input.equals(input.replaceAll("[^0-2]", ""))) return 0;
		
		int length = input.length();
		int pow = length - 1;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += Character.getNumericValue(input.charAt(i)) * Math.pow(3, pow--);
		}
		return sum;
	}
}