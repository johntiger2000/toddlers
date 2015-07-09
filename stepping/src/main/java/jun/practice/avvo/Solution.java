package jun.practice.avvo;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		int[][] input = {
				{1,1,0,1,0,1},
				{1,1,1,1,0,1},
				{0,0,0,0,1,1},
				{1,0,1,0,1,0}
			};
		new Solution().print(input);
	}
	
	public void print(int[][] input) {
		if (input == null || input[0] == null) return;
		int row = input.length;
		int col = input[0].length;
		Set<String> allOnes = new HashSet<String>();
		char group = 'A';
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (input[i][j] == 1) {
					String key = "("+i+","+j+")";
					if (!allOnes.contains(key)) {
						Set<String> current = new HashSet<String>();
						print(input, row, col, i, j, current);
						System.out.print(group++);
						System.out.print(": ");
						for (String str : current) {
							System.out.print(str);
						}
						System.out.println();
						allOnes.addAll(current);
					}
				}
			}
		}
	}
	
	private void print(int[][] input, int row, int col, int i, int j, Set<String> current) {
		if (i < 0 || i >= row) return;
		if (j < 0 || j >= col) return;
		if (input[i][j] == 0) return;
		String key = "("+i+","+j+")";
		if (current.contains(key)) return;
		current.add(key);
		print(input, row, col, i-1, j, current);
		print(input, row, col, i, j-1, current);
		print(input, row, col, i+1, j, current);
		print(input, row, col, i, j+1, current);
	}
}
