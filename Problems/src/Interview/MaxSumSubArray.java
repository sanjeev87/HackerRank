package Interview;

import java.util.Scanner;

public class MaxSumSubArray {
	
	public int maxSubArray(int[] A) {
        
		if(A== null || A.length == 0){
			return 0;
		}
		
		int max = A[0];
		int result = A[0];
		
		for(int i = 1 ; i < A.length ; i ++){
			
			max = Math.max(max + A[i], A[i]);
			
			if(max > result){
				result = max;
			}
			
		}
		
		return result;
    }
	
 public static int maxSubArraySum(int[] arr) {
        
		if(arr== null || arr.length == 0){
			return 0;
		}
		
		int max = arr[0];
		int result = arr[0];
		
		for(int i = 1 ; i < arr.length ; i ++){
			
			max = Math.max(max + arr[i], arr[i]);
			
			if(max > result){
				result = max;
			}
			
		}
		
		return result;
    }

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int L = s.nextInt();
		
		int[] arr = new int[L];
		
		int ones = 0;
		for(int i = 0 ; i < L ; i++){
			int next = s.nextInt();
			if(next == 1){
				ones++;
				next = -1;
			}else{
				next = 1;
			}
			arr[i] = next;
		}
		
		int maxSum = maxSubArraySum(arr);
		
		if(maxSum > 0){
			System.out.println(maxSum+ones);
		}else{
			System.out.println(ones);
		}
		
		
	}

}
