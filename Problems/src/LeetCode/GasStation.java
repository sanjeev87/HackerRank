package LeetCode;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		for(int i = 0 ; i < gas.length  ; i++){
			
	
			int gasBuffer = 0;
			for(int j = i,count = gas.length; count > 0 ; count--,j++){
				
				int index = j % gas.length;
				
				if((gas[index] - cost[index]) + gasBuffer < 0){
					i = j;
					break;

				}else{
					gasBuffer += (gas[index] - cost[index]);
				}
				
				if(count == 1){
					return i;
				}

			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GasStation g = new GasStation();
		
		int[] gas = {2,4};
		int[] cost = {3,4};
		
		System.out.println(g.canCompleteCircuit(gas, cost));

	}

}
