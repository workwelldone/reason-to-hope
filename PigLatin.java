import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {

	private static final String VOWELS = "[aeiou].*|[yt].*|[xr].*";
	private static final String DOUBLE_CONSONANTS = "ch.*|qu.*|th.*";
	private static final String TRIPLE_CONSONANTS = ".qu.*|thr.*|sch.*";
	
	public static String translate(String input) {
		return Arrays.stream(input.split(" ")).map(s -> translateWord(s))
				.collect(Collectors.joining(" "));
	}

	private static String translateWord(String word) {
		if (word.matches(VOWELS)) return word + "ay";
		if (word.matches(DOUBLE_CONSONANTS)) return word.substring(2) + word.substring(0,1) + "ay";
		if (word.matches(TRIPLE_CONSONANTS)) return word.substring(3) + word.substring(0,2) + "ay";
		return word.substring(1) + word.charAt(0) + "ay";
	}
}
