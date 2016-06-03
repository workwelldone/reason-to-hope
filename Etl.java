import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
   		Map<String, Integer> newMap = new HashMap<>();
   		for (Integer i: old.keySet()) {
   			for (String s: old.get(i)) {
   				newMap.put(s.toLowerCase(), i);
   			}
   		}
      return newMap;
   }
}
