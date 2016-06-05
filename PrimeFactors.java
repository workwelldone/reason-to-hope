import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Long> getForNumber(Long number) {
		List<Long> primeFactors = new ArrayList<>();
		if (number == 1) return primeFactors;
		
		long divisor = 2;
		long remainder = number;
		
		while (remainder != divisor) {
			if (remainder % divisor == 0) {
				remainder = remainder / divisor;
				primeFactors.add(divisor);
			} else divisor++;
		}
		primeFactors.add(remainder);
		return primeFactors;
	}
}