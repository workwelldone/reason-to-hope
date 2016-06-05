import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

	public static <E> List<E> keep(List<E> list, Predicate<E> predicate) {
		if (list.isEmpty()) return new LinkedList<>();
		List<E> keep = new ArrayList<>();
		for (E i: list) {
			if (predicate.test(i)) keep.add(i);
		}
		return keep;
	}
	
	public static <E> List<E> discard(List<E> list, Predicate<E> predicate) {
		if (list.isEmpty()) return new LinkedList<>();
		List<E> discard = new ArrayList<>();
		for (E i: list) {
			if (!predicate.test(i)) discard.add(i);
		}
		return discard;
	}
}