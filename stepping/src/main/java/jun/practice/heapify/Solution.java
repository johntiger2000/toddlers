package jun.practice.heapify;

public class Solution {
	
	public void heapifyUp(int[] A) {
		for (int i = 1; i < A.length; ++i) {
			siftUp(A, 0, i);
		}
		
	}

    private void siftUp(int[] A, int start, int end) {
    	int child = end;
    	while (start < child) {
    		int parent = (child-1) / 2;
    		if (A[parent] > A[child]) {
    			int temp = A[parent];
    			A[parent] = A[child];
    			A[child] = temp;
    			child = parent;
    		} else {
    			return;
    		}
    	}
    }
    
	public void heapifyDown(int[] A) {
		for (int i = A.length/2 - 1; i >= 0; --i) {
			siftDown(A, i, A.length - 1);
		}
		
	}

    private void siftDown(int[] A, int start, int end) {
    	int parent = start;
    	while (parent * 2 + 1 <= end) {
    		int child = parent * 2 + 1;
    		int swap = parent;
    		if (A[swap] > A[child]) {
    			swap = child;
    		}
    		if (child+1 <= end && A[swap] > A[child+1]) {
    			swap = child+1;
    		}
    		if (swap == parent) {
    			return;
    		} else {
    			int temp = A[swap];
    			A[swap] = A[parent];
    			A[parent] = temp;
    			parent = swap;
    		}
    	}
    }
}
