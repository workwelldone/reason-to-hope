public class RnaTranscription {
	
	public static String ofDna(String input) {
		String RNA = "";
		for (int i = 0; i < input.length(); i++) {
			RNA += match(input.charAt(i));
		}
		return RNA;
	}
	
	private static char match(char c){
		switch (c) {
		case 'G': return 'C';
		case 'C': return 'G';
		case 'T': return 'A';
		default:  return 'U';
		}
	}
}