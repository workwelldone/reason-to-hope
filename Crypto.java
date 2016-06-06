import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crypto {

	private String normalized;
	private int cols;
	private int rows;
	private List<String> segments;
	private String cipherText;
	private String normalizedSegments;
	
	public Crypto(String input) {
		normalized = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		cols = (int)Math.ceil(Math.sqrt(normalized.length()));
		rows = (int)Math.round(Math.sqrt(normalized.length()));
		segments = setPlaintextSegments();
		cipherText = setCipherText();
		normalizedSegments = setNormalizedCipherText();
	}
		
	private final List<String> setPlaintextSegments() {
		List<String> segments = new ArrayList<>();
		for(int i = 0; i < rows; i++) {
			int length = normalized.length();
			int start = i * cols;
			int end = start + cols > length ? length : start + cols; 
			segments.add(normalized.substring(start, end));
		}
		return segments;
	}
	
	private String setCipherText() {
		String cipher = "";
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (i < segments.get(j).length()) cipher += segments.get(j).charAt(i);
			}
		}
		return cipher;
	}
	
	private String setNormalizedCipherText() {
		List<String> normalizedText = new ArrayList<>();
		for (int i = 0; i < cols; i++) {
			String cipher = "";
			for (int j = 0; j < rows; j++) {
				if (i < segments.get(j).length()) cipher += segments.get(j).charAt(i);
			}
			normalizedText.add(cipher);
		}
		return normalizedText.stream().collect(Collectors.joining(" "));
	}
	
	public String getNormalizedPlaintext(){
		return normalized;
	}
	
	public int getSquareSize() {
		return cols;
	}
	
	public List<String> getPlaintextSegments() {
		return segments;
	}
	
	public String getCipherText(){
		return cipherText;
	}
	
	public String getNormalizedCipherText() {
		return normalizedSegments;
	}
}