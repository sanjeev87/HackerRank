package LeetCode;

public class SortColors {
	
	public int sort(int[] A, int start, int pivot){
		
		int swapIndex = start;
		
		for(int i = start ; i < A.length ; i ++){
			
			if(A[i] <= pivot){
				int temp = A[i];
				A[i] = A[swapIndex];
				A[swapIndex] = temp;
				swapIndex++;
			}
			
		}
		
		return swapIndex;
	}


	public void sortColors(int[] A) {
		
		if(A== null || A.length == 0){
			return;
		}
		
		int index = sort(A, 0, 0);
		index = sort(A, index, 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
