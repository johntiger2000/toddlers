package jun.practice.nqueens;

import java.util.ArrayList;

public class Solution {
	
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        helper(n, 0, new int[n], res);
        return res;
    }
    
    public void helper(int n, int currentrow, int[] colforrow, ArrayList<ArrayList<String>> res) {
        if (currentrow == n) { //find a suitable solution, add to result list
            ArrayList<String> array = new ArrayList<String>(n);
            for (int k = 0; k < n; k++) {
                StringBuffer buff = new StringBuffer();
                for (int m = 0; m < n; m++) {
                    if (colforrow[k] == m) buff.append('Q');
                    else buff.append('.');
                }
                String st = buff.toString();
                array.add(k, st);
            }
            res.add(array);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            colforrow[currentrow] = i;
            if (check(currentrow, colforrow)) {
                helper(n, currentrow+1, colforrow, res);
            } 
        }
    }
    
    public boolean check(int currentrow, int[] colforrow) {
        for (int temp = 0; temp < currentrow; temp++) {
            if (colforrow[temp] == colforrow[currentrow] || Math.abs(colforrow[temp] - colforrow[currentrow]) == Math.abs(temp - currentrow))
                return false;
        }
        return true;
    }
}
