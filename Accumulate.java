import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Accumulate {

	public static <E> List<E> accumulate(List<E> list, Function<E,E> function) {
		
		List<E> nList = new ArrayList<>(list);
		for (int i = 0; i < nList.size(); i++) {
			nList.set(i, function.apply(nList.get(i)));
		}
 		return nList;
	}
}