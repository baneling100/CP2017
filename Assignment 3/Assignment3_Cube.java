/*
name: Woohyeon Baek
student number: 2017-15782
 */

import java.io.*;

public class Assignment3_Cube {
	private Assignment3_Side[] side;
	private int size;

	public Assignment3_Cube(String filename) {
		side = new Assignment3_Side[6];
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			size = Integer.parseInt(br.readLine());
			for(int i = 0; i < 6; i++)
				side[i] = new Assignment3_Side(size, i+1);

			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < num; i++) {
				String[] t = br.readLine().split(" ");
				int face = Integer.parseInt(t[0]);
				char type = t[1].charAt(0);
				char dir = t[2].charAt(0);
				int loc = Integer.parseInt(t[3]) - 1;

				if(1 <= face && face <= 4 && type == 'c') {
					if(dir == 'u') {
						int[] s = side[3].getCol(loc);
						for(int j = 3; j >= 1; j--)
							side[j].changeCol(loc, side[j - 1].getCol(loc));
						side[0].changeCol(loc, s);
					}
					else {
						int[] s = side[0].getCol(loc);
						for(int j = 0; j < 3; j++)
							side[j].changeCol(loc, side[j + 1].getCol(loc));
						side[3].changeCol(loc, s);
					}
				}
				else if((face == 1 || face == 3 || face == 5 || face == 6) && type == 'r') {
					if(face == 3)
						loc = size - loc - 1;
					if(face != 3 && dir == 'l' || (face == 3 && dir == 'r')) {
						int[] s = side[0].getRow(loc);
						side[0].changeRow(loc, side[5].getRow(loc));
						side[5].changeRow(loc, reverse(side[2].getRow(size - loc - 1)));
						side[2].changeRow(size - loc - 1, reverse(side[4].getRow(loc)));
						side[4].changeRow(loc, s);
					}
					else {
						int[] s = side[4].getRow(loc);
						side[4].changeRow(loc, reverse(side[2].getRow(size - loc - 1)));
						side[2].changeRow(size - loc - 1, reverse(side[5].getRow(loc)));
						side[5].changeRow(loc, side[0].getRow(loc));
						side[0].changeRow(loc, s);
					}
				}
				else {
					if(face == 4 || face == 6)
						loc = size - loc - 1;
					if((face == 2 && dir == 'r') || (face == 6 && dir == 'd') || (face == 4 && dir == 'l') || (face == 5 && dir == 'u')) {
						int[] s = side[1].getRow(loc);
						side[1].changeRow(loc, reverse(side[4].getCol(loc)));
						side[4].changeCol(loc, side[3].getRow(size - loc - 1));
						side[3].changeRow(size - loc - 1, reverse(side[5].getCol(size - loc - 1)));
						side[5].changeCol(size - loc - 1, s);
					}
					else {
						int[] s = side[1].getRow(loc);
						side[1].changeRow(loc, side[5].getCol(size - loc - 1));
						side[5].changeCol(size - loc - 1, reverse(side[3].getRow(size - loc - 1)));
						side[3].changeRow(size - loc - 1, side[4].getCol(loc));
						side[4].changeCol(loc, reverse(s));
					}
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private int[] reverse(int[] t) {
		int[] s = new int[t.length];
		for(int i = 0; i < t.length; i++)
			s[i] = t[t.length - i - 1];
		return s;
	}
	public int[][] report(int s) { return side[s-1].get(); }
}
