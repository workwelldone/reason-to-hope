import java.util.Map;
import java.util.HashMap;

public class WordCount {

	public Map<String, Integer> phrase(String phrase) {
		
		Map<String, Integer> pMap = new HashMap<>();
		String[] pArr = phrase.split(" ");
		
		for (String s: pArr) {
			String temp = s.toLowerCase().replaceAll("[^a-z0-9]","");
			if (temp.length() == 0) continue;
			if (pMap.get(temp) == null) {
				pMap.put(temp,1);
			} else pMap.put(temp, pMap.get(temp) + 1);
		}
		
		return pMap;
	}
}
