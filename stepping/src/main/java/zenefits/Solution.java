package zenefits;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 */

class Solution {
	public static void main(String[] args) {
		int[] arr = {1,0,0,1,0,0,1,0};
		System.out.println(bitFlip(arr));
	}
  
	public static int bitFlip(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		int n = arr.length;
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] == 1) {
				++cnt;
			}
		}
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			int curr = 1;
			if (arr[i] == 1) {
				curr = -1;
			}
			sum = Math.max(curr, sum+curr);
			max = Math.max(max, sum);
		}
		return cnt + max;
	}
	
	static int countUneatenLeaves(int N, int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(A);
		for (int i = 0; i < A.length; ++i) {
			if (set.contains(A[i])) {
				continue;
			}
			for (int j = 1; j*A[i] <= N; ++j) {
				set.add(j*A[i]);
			}
		}
		return N-set.size();
    }
}

