class Trinary {

	public static int toDecimal(String input) {
		if (!input.matches("[0-2]+")) return 0;
		return input.chars()
					.map(c -> (char)c - '0')
					.reduce(0, (result, c) -> result * 3 + c);
	}
}