package LeetCode;

public class SearchInRotatedSortedArray {


	public int search(int[] A, int target, int start, int end) {

		if(start>end){
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(mid == start){
			if(target == A[start]){
				return start;
			}else if(target == A[end]){
				return end;
			}else{
				return -1;
			}
		}
		
		if(A[mid] == target){
			return mid;
		}
		
		if(A[mid] > A[end]){
			if(target >  A[mid]){
				return search(A,target,mid+1,end);
			}
		}
		
		if(A[mid] < A[end]){
			if(target < A[mid]){
				return search(A,target,start,mid-1);
			}
		}
		

		return Math.max(search(A, target, start, mid-1), search(A, target, mid+1, end));
	}

	public int search(int[] A, int target) {

		if(A == null || A.length == 0){
			return -1;
		}

		return search(A, target, 0, A.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
