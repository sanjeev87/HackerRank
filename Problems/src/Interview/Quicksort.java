package Interview;

public class Quicksort {

	
	public static int partition(int[] input, int start, int end){
		
		int pivot = input[start];
		
		int swapIndex = start+1;
		
		for(int i = start+1 ; i <= end; i ++){
			if(input[i] < pivot){
			//	if(swapIndex < i){
					int temp = input[swapIndex];
					input[swapIndex] = input[i];
					input[i] = temp;
 			//	}
				swapIndex++;
			}
			
		}
		
		int temp = input[start];
		input[start] = input[swapIndex - 1];
		input[swapIndex-1] = temp;
		
		return swapIndex-1;
	}
	
	public static void sort(int[] input, int start, int end){
		
		if(start == end || start > end){
			return;
		}
		
		int pivotIndex = partition(input, start, end);
		
		sort(input,start,pivotIndex-1);
		
		sort(input,pivotIndex + 1,end);
		
		
		
	}
	
	public static void main(String[] args) {

		int[] arr = {0,1,5,2,3,0,7,8,4,6,0};
		
		sort(arr, 0, arr.length -1);
		
		for(int num : arr){
			System.out.println(num);
		}
		
	}

}
