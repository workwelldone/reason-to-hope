public class Hamming {

	public static int compute(String one, String two) throws IllegalArgumentException {
		
		if (one.length() != two.length()) throw new IllegalArgumentException();

		int count = 0;
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) count++;
		}

		return count;
	}

}
