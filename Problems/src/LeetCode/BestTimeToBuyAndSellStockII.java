package LeetCode;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
        

		if(prices ==null || prices.length <= 1){
			return 0;
		}
		
		int min = prices[0];
		int maxTotalProfit = 0;
		int profit = 0;
		
		for(int i = 1; i < prices.length ; i++){
			
			if(prices[i] < min){
				min = prices[i];
			}
			
			if(profit > 0 && prices[i] < min + profit){
				maxTotalProfit += profit;
				profit = 0;
				min = prices[i];
			}
			
			if(profit < prices[i] - min){
				profit = prices[i] - min;
			}
			
			
			
		}
		
		return maxTotalProfit + profit;
	
    }


	public static void main(String[] args) {

	}

}
