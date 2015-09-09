package LeetCode;

public class PaintHouseII {

	public int minCostII(int[][] costs) {

		if(costs==null || costs.length == 0 || costs[0].length == 0){
			return 0;
		}
		
		int houses = costs.length;
		int colors = costs[0].length;
		
		int curMax1 = 0, curMax2 = 0, prevMax1 = 0, prevMax2 = 0;
		
		int[] res = new int[colors];
		
		for(int house = 0 ; house < houses ; house ++){
			
			prevMax1 = curMax1;
			prevMax2 = curMax2;
			
			curMax1 = Integer.MAX_VALUE;
			curMax2 = Integer.MAX_VALUE;
			
			
			for(int color = 0 ; color < colors ; color++){
				res[color] = ((res[color] == prevMax1) ? 
						prevMax2 : prevMax1) + costs[house][color];
				
				if(res[color] < curMax1){
					curMax2 = curMax1;
					curMax1 = res[color];
				}else{
					if(res[color] < curMax2){
						curMax2 = res[color];
					}
				}
			}
			
		}

		return curMax1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] costs = {{1,5,3},{2,9,4}};
		
		PaintHouseII ph = new PaintHouseII();
		System.out.println(ph.minCostII(costs));

	}

}
