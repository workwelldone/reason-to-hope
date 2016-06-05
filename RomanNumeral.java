import java.util.TreeMap;

class RomanNumeral {

/** I found the general idea from
* http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
* However I did work it through on my own.  I think it is awesome.
**/

	private static TreeMap<Integer, String> map = new TreeMap<>();
	
	static {
		map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
	}

	private int number;
	
	public RomanNumeral(int number) {
		this.number = number;
	}
	
	public String determineRomanNumeral(int number) {
		int floor = map.floorKey(number);
		if (floor == number) return map.get(number);
		else return map.get(floor) + determineRomanNumeral(number - floor);
	}
	
	public String getRomanNumeral() {
		return (number == 0) ? "" : determineRomanNumeral(number);
	}
}