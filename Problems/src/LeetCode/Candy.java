package LeetCode;


public class Candy {

	public int candy(int[] ratings) {
		
		int candies = 0;
		
		if(ratings.length < 2){
			return ratings.length;
		}
		
		int[] candy1 = new int[ratings.length];
		candy1[0] = 1;
		int[] candy2 = new int[ratings.length];
		candy2[0] = 1;
		
		
		
		for(int i = 1 ; i < ratings.length; i++){
			
			candy1[i] = (ratings[i] > ratings[i-1]) ? (candy1[i-1] + 1) : candy1[i-1];
			candy2[ratings.length - 1 - i] = (ratings[ratings.length - 1 - i ] > ratings[ratings.length - i]) ? 
					(candy1[ratings.length - i] + 1) : candy1[ratings.length - i];
			
		}
		
		
		for(int i = 0 ; i < ratings.length; i++){
			candies += Math.max(candy1[i], candy2[i]); 
		}
		
		
		return candies;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
