public class Prime {

	public static int nth(int numberOfPrime) throws IllegalArgumentException {
		if (numberOfPrime <= 0) throw new IllegalArgumentException();
		int primeCount = 0;
		int numToCheck = 2;
		while (true) {
			if (isPrime(numToCheck)) {
				primeCount++;
				if (primeCount == numberOfPrime) break;
			}
			numToCheck++;
		}
		return numToCheck;
	}
	   
   private static boolean isPrime(int n){
	   if (n == 2) return true;
	   if (n % 2 == 0) return false;
	   for (int i = 3; i <= Math.sqrt(n); i+=2) {
		   if (n % i == 0) return false;
	   }
	   return true;
   }
}