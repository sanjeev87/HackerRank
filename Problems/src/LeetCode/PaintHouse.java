package LeetCode;

public class PaintHouse {
	
    public int minCost(int[][] costs) {
        
    	if(costs == null || costs.length == 0){
    		return 0;
    	}
    	
    	int[][] res = new int[costs.length+1][3];
    	res[1][0] = costs[0][0];
    	res[1][1] = costs[0][1];
    	res[1][2] = costs[0][2];
    	
    	for(int houseNum = 1 ; houseNum < costs.length ; houseNum++){
    		for(int color = 0 ; color < 3 ; color++){
    			res[houseNum+1][color] = costs[houseNum][color] + getMinCostWithoutColor(houseNum, color, res);
    		}
    	}
    	return Math.min(res[costs.length][0], Math.min(res[costs.length][1], res[costs.length][2]));
    }
    
    public int getMinCostWithoutColor(int house, int color, int[][] result){
    	
    	if(color == 0){
    		return Math.min(result[house][1], result[house][2]);
    	}
    	
    	if(color == 1){
    		return Math.min(result[house][0], result[house][2]);
    	}
    	
    	if(color == 2){
    		return Math.min(result[house][0], result[house][1]);
    	}
    	
    	return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
