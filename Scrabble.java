class Scrabble {
	
	private String word;
	
	public Scrabble(String word) {
		if (word != null) this.word = word.trim().toUpperCase();
	}
	
	public int getScore(){
		if (word == null || word.isEmpty()) return 0;
		int score = 0;
		for (int i = 0, length = word.length(); i < length; i++){
			String piece = "" + word.charAt(i);
			if (piece.matches("[AEIOULNRST]")) {score +=1;	continue;}
			if (piece.matches("[DG]")) {score +=2; continue;}
			if (piece.matches("[BCMP]")) {score +=3; continue;}
			if (piece.matches("[FHVWY]")) {score +=4; continue;}
			if (piece.matches("[K]")) {score +=5; continue;}
			if (piece.matches("[JX]")) {score +=8; continue;}
			if (piece.matches("[QZ]")) {score +=10;continue;}
		}
		return score;
	}
}