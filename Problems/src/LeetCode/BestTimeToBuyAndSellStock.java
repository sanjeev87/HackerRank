package LeetCode;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		
		if(prices ==null || prices.length <= 1){
			return 0;
		}
		
		int min = prices[0];
		int max = prices[0];
		int bestProfit = 0;
		
		for(int i = 1 ; i < prices.length ; i ++){
			if(prices[i] > max){
				max = prices[i];
				bestProfit = Math.max(bestProfit,Math.max(max - min,0));
			}else if(prices[i] < min){
				min = prices[i];
				max = Math.max(min,bestProfit - min);
			}
		}
		return bestProfit;
	}
	
	// solution from git hub
	public int maxProfitFromGitHub(int[] prices) {
        if (prices==null||prices.length<2){
            return 0;
        }
      
       int min=Integer.MAX_VALUE;
       int diff=0;
       
       for (int i=0; i<prices.length; i++){
           if (prices[i]<min){
               min=prices[i];
           }    
           
           if (diff<prices[i]-min){
               diff=prices[i]-min;
           }
       }
       
       return diff;
       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
