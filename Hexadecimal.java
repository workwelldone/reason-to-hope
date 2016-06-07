public class Hexadecimal {

	public static int toDecimal(String input) {
		input = input.toUpperCase();
		if (!input.matches("[0-9A-F]+")) return 0;
		return input.chars()
					.mapToObj(c -> (char)c)
					.map(c -> (c >= 'A') ? c - 'A' + 10  : c - '0')
					.reduce(0, (result, c) -> result * 16 + c);
	}
}
