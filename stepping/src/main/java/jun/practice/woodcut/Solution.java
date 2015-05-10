package jun.practice.woodcut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		int[] L = {2147483644,2147483645,2147483646,2147483647};
		//int[] num = {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
		int[] num = {1,20,23,4,8};
		new Solution().largestNumber(num);
	}
	
    public String largestNumber(int[] num) {
        // write your code here
        if (num.length == 0) return "";
        
        ArrayList<String> ret = new ArrayList<String>();
        ret.add(""+num[0]);
        
        for (int i = 1; i < num.length; ++i) {
            String curr = concat(ret) + num[i];
            int index = ret.size();
            for (int j = 0; j < ret.size(); ++j) {
                String temp = concat(ret.subList(0, j)) + num[i]
                    + concat(ret.subList(j, ret.size()));
                if (curr.compareTo(temp) < 0) {
                    curr = temp;
                    index = j;
                }
            }
            if (index == ret.size()) ret.add(""+num[i]);
            else ret.add(index, ""+num[i]);
        }
        
        String str = concat(ret);
        if (str.length() == 0) return "0";
        return str;
    }
    
    private String concat(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); ++i) {
            if (sb.length() == 0 && arr.get(i).equals("0")) {
                continue;
            }
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
    
    private int compare(String a, String b) {
        int n = a.length() > b.length() ? a.length() : b.length();
        for (int i = 0; i < n; ++i) {
            if (i > a.length()-1) return 1;
            if (i > b.length()-1) return -1;
            if (a.charAt(i) > b.charAt(i)) return 1;
            if (a.charAt(i) < b.charAt(i)) return -1;
        }
        return 0;
    }

    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask = 0;
        for (int k = 0; k <= j-i; ++k) {
            mask = (mask << 1) + 1;
        }
        mask <<= i;
        mask = ~mask;
        n &= mask;
        return n | (m << i);
    }	

    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for (int i = 0; i < L.length; ++i) {
            if (L[i] > max) {
                max = L[i];
            }
        }
        int i = 1;
        int j = max;
        while (i < j) {
            int mid = i + (j-i)/2;
            if (woodCutOk(L, mid, k)) {
                i = mid+1;
            } else {
                j = mid;
            }
        }
        if (woodCutOk(L, i, k)) {
            return i;
        }
        return i-1;
    }
    
    private boolean woodCutOk(int[] L, int length, int k) {
        int total = 0;
        for (int i = 0; i < L.length; ++i) {
            total += L[i] / length;
        }
        return total >= k;
    }
}
