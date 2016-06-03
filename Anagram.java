import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

	private String word;

	public Anagram(String word) {
		this.word = word.toLowerCase();
	}

	private String[] sortToLower(String word) {
		String[] temp = word.split("");
		Arrays.sort(temp);
		return temp;
	}
	
	public List<String> match(List<String> checkList){
		String[] sorted = sortToLower(this.word);
		List<String> matchingWords = new ArrayList<>();
		
		for (String s: checkList) {
			String temp = s.toLowerCase();
			if (!temp.equals(this.word)) {
				String[] wordArray = temp.split("");
				Arrays.sort(wordArray);
				
				if (Arrays.equals(wordArray, sorted)) {
					matchingWords.add(s);
				}
			}
		}
		return matchingWords;
	}
}
