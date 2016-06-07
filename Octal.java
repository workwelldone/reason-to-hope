public class Octal {

	private final String input;

	public Octal(String input) {
		this.input = input;
	}

	public int getDecimal() {
		if (!input.matches("[0-7]+")) return 0;
		return input.chars()
					.map(c -> (char)c - '0')
					.reduce(0, (result, c) -> result * 8 + c);
	}
}