package LeetCode;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] A, int target) {

		if(A == null || A.length == 0){
			return false;
		}

		return search(A, target, 0, A.length-1);
	}
    
    public boolean search(int[] A, int target, int start, int end) {

		if(start>end){
			return false;
		}
		
		int mid = (start + end)/2;
		
		if(mid == start){
			if(target == A[start]){
				return true;
			}else if(target == A[end]){
				return true;
			}else{
				return false;
			}
		}
		
		if(A[mid] == target){
			return true;
		}
		
		if(A[mid] > A[end]){
			if(target >  A[mid]){
				return search(A,target,mid,end);
			}
		}
		
		if(A[mid] < A[end]){
			if(target < A[mid]){
				return search(A,target,start,mid);
			}
		}
		

		return search(A, target, start, mid-1) || search(A, target, mid+1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
