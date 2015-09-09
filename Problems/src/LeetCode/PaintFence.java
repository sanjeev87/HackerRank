package LeetCode;

public class PaintFence {

	public int numWays(int n, int k) {
		
		
		if(k <= 1) return 0;
		if(n == 1) return k;
		
		int sameColor = k;
		int diffColor = k * (k - 1);
		
		for(int i = 3 ; i <= n ; i++){
			int temp = diffColor;
			diffColor = (diffColor + sameColor) * (k-1);
			sameColor = temp;
		}
		
		
		return diffColor + sameColor;
	}

}
