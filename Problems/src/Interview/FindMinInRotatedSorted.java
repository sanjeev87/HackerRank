package Interview;

public class FindMinInRotatedSorted {
	
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


	}

}
