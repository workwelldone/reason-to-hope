import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Pangrams {

	static boolean isPangram(String sentence){

		String[] temp = sentence.toUpperCase().replaceAll("[^A-Z]","").split("");
		Set<String> letters = new HashSet<>(Arrays.asList(temp));

		return (letters.size() == 26);
	}
}