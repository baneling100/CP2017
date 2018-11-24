/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Assignment3_Side {
	private int[][] side;
	private int size;

	public Assignment3_Side(int size, int value) {
		side = new int[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				side[i][j] = value;
		this.size = size;
	}
	public void changeRow(int loc, int[] row) {
		for(int i = 0; i < size; i++)
			side[loc][i] = row[i];
	}
	public void changeCol(int loc, int[] col) {
		for(int i = 0; i < size; i++)
			side[i][loc] = col[i];
	}
	public int[] getRow(int loc) {
		int[] row = new int[size];
		for(int i = 0; i < size; i++)
			row[i] = side[loc][i];
		return row;
	}
	public int[] getCol(int loc) {
		int[] col = new int[size];
		for(int i = 0; i < size; i++)
			col[i] = side[i][loc];
		return col;
	}
	public int[][] get() { return side; }
}
