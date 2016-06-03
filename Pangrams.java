class Pangrams {

	static boolean isPangram(String sentence){

		boolean[] letters = new boolean[26];

		char[] temp = sentence.toUpperCase().replaceAll("[^A-Z]","").toCharArray();
		for (char c: temp) {
			letters[c - 'A'] = true;
		}

		for (boolean b: letters) {
			if (!b) return false;
		}

		return true;
	}
}