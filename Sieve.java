import java.util.ArrayList;
import java.util.List;

public class Sieve {
		
	private int limit;
	
	public Sieve(int limit) {
		this.limit = limit;
		
	}
	
	public List<Integer> getPrimes() {
		boolean[] nums = new boolean[limit + 1];
		for (int i = 2; i <= limit; i++) nums[i] = true;

		for (int i = 2; i < Math.sqrt(limit); i++) {
			if (nums[i]) {
				for (int j = i * i; j <= limit; j += i) {
					nums[j] = false;
				}
			}
		}
		List<Integer> primes = new ArrayList<>();
		for (int i= 2; i <= limit; i++) {
			if (nums[i]) primes.add(i);
		}
		
		return primes;
	}
}