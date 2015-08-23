package Interview;

public class FindMinInRotatedSortedArrayII {
	
	// 0 1 2 3 4 5 6 7 8 
	// 1 2 3 4 5 6 7 8 0
	// 2 3 4 5 6 7 8 0 1
	// 5 6 7 8 0 1 2 3 4
	
	
	// O(log n) when no duplicates
	// worst case - if the first element is min and everything else is equal - then O(n)
	
    public int findMin(int[] num, int start, int end){
		
		int mid = (end + start) / 2;
		
		if(start > end){
			return Integer.MAX_VALUE;
		}
		
		if(mid == start){
			return Math.min(num[start], num[end]);
		}
		
		if(num[mid] > num[end]){
			return findMin(num, mid, end);
		}
		
		if(num[mid] < num[end]){
			return findMin(num, start, mid);
		}
		
		
		return Math.min(findMin(num, start, mid-1),findMin(num, mid+1, end));
	}
	

	public int findMin(int[] num) {

		
		if(num == null || num.length == 0){
			return 0;
		}
		
		return findMin(num, 0, num.length-1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
