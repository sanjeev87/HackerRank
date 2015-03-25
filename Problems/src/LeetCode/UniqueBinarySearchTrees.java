package LeetCode;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		
		if(n == 0){
			return 0;
		}
		
		int[] result = new int[n+1];
		
		result[1] = 1;
		
		if(n == 1){
			return 1;
		}
		
		result[2] = 2;

		for(int i = 3 ; i <= n ; i++){
			
			for(int j = 1 ; j <= i ; j++ ){

				int left = Math.max(result[j-1],1);
				int right = Math.max(result[i-j],1);
				result[i] += left * right;
				
			}
			
		}
		
		return result[n];
	
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
