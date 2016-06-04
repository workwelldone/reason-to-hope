class Bob {

	public String hey(String wuzUp) {
		if (wuzUp.trim().isEmpty()) return "Fine. Be that way!";
		if (wuzUp == wuzUp.toUpperCase() && wuzUp.replaceAll("[a-zA-Z]","") != wuzUp) return "Whoa, chill out!";
		if (wuzUp.endsWith("?")) return "Sure.";
		return "Whatever.";
	}
}
