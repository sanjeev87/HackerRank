package LeetCode;

public class PalindromePartitioningII {


	public int minCut(String s) {
    

		
		if(s == null || s.isEmpty()||s.length() == 1){
		    return 0;
		}
		
		int n = s.length();
		
		boolean[][] isPalindrome = new boolean[n][n];
		
		for(int i = n - 1 ; i >= 0; i --){
			for(int j = i ; j < n ; j ++){
				if(s.charAt(i) == s.charAt(j)){
					if(j-i <= 1 || isPalindrome[i+1][j-1]){
						isPalindrome[i][j] = true;
					}
				}
			}
		}


		int[] minCut = new int[n+1];

		for(int i = n ; i >= 0 ; i --){
			minCut[i] = n - 1 - i;
		}

		for(int i = n - 1 ; i >= 0 ; i --){
			for(int j = i ; j < n ; j ++){
				if(isPalindrome[i][j]){
					minCut[i] = Math.min(minCut[i], minCut[j+1] + 1);
				}
			}
		}


		return minCut[0];
	
    }


	public static void main(String[] args) {


	}

}
