package Interview;

import java.util.Scanner;

// twitter 
public class Solution {
	
	   static int getNumberOfPrimes(int N) {
		   
		   boolean[] ar = new boolean[N];
		   
		   for(int i = 2 ; i <= Math.sqrt(N); i++){
			   
			   for(int j = i+1 ; j < N ; j++){
				   if(!ar[j] && j % i ==0 ){
					   ar[j] = true;
				   }
			   }
			   
		   }
		   
		   int result = 0;
		   
		   for(boolean r : ar){
			   if(!r){
				   result++;
			   }
		   }
		   
		   
		   return result;
	    }

	public static void main(String args[] ) throws Exception {
		
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i = 0 ; i < T ; i++){
			
			int n = s.nextInt();
			int result = 1;
			for(int j = 1 ; j <= n ; j++){
				if(j % 2 != 0){
					result <<= 1;
				}else{
					result += 1;
				}
			}
			System.out.println(result);
		}
		
	}
	
	
}
