import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DNA {

	String strand;
	private static final List<Character> nucleotides = Arrays.asList('A', 'C', 'G', 'T');

	public DNA(String strand) {
		this.strand = strand;
	}

	/**
	 * Determines the quantity of the nucleotide that is contained in this strand.
	 * @param nt nucleotide to find in the strand
	 * @return quantity of this nucleotide contained in this strand
	 * @throws IllegalArgumentException
	 */
	public int count(char nt) throws IllegalArgumentException {
		if (!nucleotides.contains(nt)) throw new IllegalArgumentException();
		String temp = this.strand.replaceAll("[^" + nt + "]", "");
		return temp.length();		
	}

	/**
	 * Maps the quantity of each nucleotide in the strand	
	 * @return map of each nucleotide and its quantity in the strand
	 * @throws IllegalArgumentException
	 */
	public Map<Character, Integer> nucleotideCounts() throws IllegalArgumentException {
		Map<Character, Integer> nucCount = new HashMap<>();
		for (Character n: nucleotides) {
			nucCount.put(n, count(n));
		}
		return nucCount;
	}
}
