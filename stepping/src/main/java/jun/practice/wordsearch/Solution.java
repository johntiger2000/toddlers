package jun.practice.wordsearch;

public class Solution {
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		new Solution().exist(board, word);
	}

    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if (isValidWord(board, i, j, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isValidWord(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
    	if (index >= word.length()) {
    		return true;
    	}
        char ch = word.charAt(index);
        if (isValidChar(board, i-1, j, ch, visited)) {
        	visited[i-1][j] = true;
        	if (isValidWord(board, i-1, j, word, index+1, visited)) {
        		return true;
        	} else {
            	visited[i-1][j] = false;
        	}
        }
        if (isValidChar(board, i, j-1, ch, visited)) {
        	visited[i][j-1] = true;
        	if (isValidWord(board, i, j-1, word, index+1, visited)) {
        		return true;
        	} else {
            	visited[i][j-1] = false;
        	}
        }
        if (isValidChar(board, i+1, j, ch, visited)) {
        	visited[i+1][j] = true;
        	if (isValidWord(board, i+1, j, word, index+1, visited)) {
        		return true;
        	} else {
            	visited[i+1][j] = false;
        	}
        }
        if (isValidChar(board, i, j+1, ch, visited)) {
        	visited[i][j+1] = true;
        	if (isValidWord(board, i, j+1, word, index+1, visited)) {
        		return true;
        	} else {
            	visited[i][j+1] = false;
        	}
        }
        return false;
    }
    
    private boolean isValidChar(char[][] board, int i, int j, char ch, boolean[][] visited) {
        if (i<0 || i >= board.length) return false;
        if (j<0 || j >= board[0].length) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != ch) return false;
        return true;
    }
}
