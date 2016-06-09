import java.util.Arrays;

class PascalsTriangle {

	public static int[][] computeTriangle(int numRows) throws IllegalArgumentException{
		
		// validation
		if (numRows < 0) throw new IllegalArgumentException();
		int[][] rows = new int[numRows][];
		if (numRows == 0) return rows;
		
		// initialize
		rows[0] = new int[1];
		rows[0][0] = 1;

		// pascals triangle
		for (int i = 1; i < numRows; i++) {
			int lengthUp = rows[i - 1].length;
			rows[i] = new int[lengthUp + 1];
			rows[i][0] = 1;
			rows[i][lengthUp] = 1;
			for (int j = 1; j < lengthUp; j++) {
				rows[i][j] = rows[i - 1][j - 1] + rows[i - 1][j];
			}
		}
		return rows;
	}
	
	public static boolean isTriangle(int[][] input) {
		int[][] valid = computeTriangle(input.length);
		return Arrays.deepEquals(input, valid);
		
	}
}