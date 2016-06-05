class Acronym {

	public static String generate(String phrase){
		String acronym = "";
		String[] word = phrase.split("[ :-]");

		for (int i = 0; i < word.length; i++){
			// Check for all uppercase words
			if (word[i] == word[i].toUpperCase()) return word[i];
			
			// Add first letter of every word
			acronym += word[i].toUpperCase().charAt(0);
		
			// Capital Letters inside words
			String allCaps = word[i].replaceAll("[^A-Z]", "");
			if (allCaps.length() > 1) acronym += allCaps.substring(1); 
		}
		return acronym;
	}
	
}