import java.util.Arrays;
import java.util.stream.Collectors;

public class Luhn {
	
	private final long inputValue;
	private final int[] input;

	public Luhn(long input) {
		this.inputValue = input;
		this.input = (Long.toString(input)).chars().map(c -> Character.getNumericValue(c)).toArray();
	}
	
	public int getCheckDigit() {
		return input[input.length -1];
	}
	
	public int[] getAddends() {
		int[] addends = Arrays.copyOf(input, input.length);
		
		for (int i = input.length - 2; i >= 0; i -= 2) {
			int n = addends[i];
			addends[i] = (n * 2) > 9 ? (n * 2) - 9 : (n * 2);
		}
		return addends;
	}
	
	public int getCheckSum() {
		return Arrays.stream(getAddends()).sum();
	}
	
	public boolean isValid() {
		return getCheckSum() % 10 == 0;
	}
	
	public long create() {
		int checkDigit = getCheckSum() % 10;
		return (checkDigit == 0) ? inputValue : inputValue * 10 + checkDigit;
	}
}
