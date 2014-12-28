package Interview;

public class MoveZerosToEnd {

	
	public static int MoveZerosToEnd(int[] input){
		
		int swapIndex = 0;
		
		for(int i = 0 ; i < input.length ; i++){
			
			if(input[i] != 0){
				if(swapIndex < i){
					input[swapIndex] =  input[i];
					input[i] = 0;
				}
				swapIndex++;
			}
			
		}
		return swapIndex;
	}
	
	public static void main(String[] args) {
		
			int[] arr = {7,0,0,8,2,1,0,3,0,4,0,0,5,0,0,0};
			
			int numNonZeroElements = MoveZerosToEnd(arr);
			
			for(int num : arr){
				System.out.println(num);
			}
		
			System.out.println("Num Non zero elements : " + numNonZeroElements );
			System.out.println("Num Zero elements : " + (arr.length - numNonZeroElements));
		
	}

}
