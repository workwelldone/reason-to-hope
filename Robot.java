import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Robot {

	private static List<String> allNames = new ArrayList<>();

	String name;

	public Robot() {
		assignName();
	}

	private final void assignName() {
		do {
			this.name = getLetters(2) + Math.round(Math.random() * 1000);
		} while (allNames.contains(this.name));

		allNames.add(this.name);
	}
	
	private final String getLetters(int quantity) {
		Random random = new Random();
		String letters = "";
		for (int i = 0; i < quantity; i++) {
			letters += (char)(random.nextInt(26) + 'A');
		}
		return letters;
	}

	public String getName() {
		return this.name;
	}

	public void reset() {
		assignName();
	}
}