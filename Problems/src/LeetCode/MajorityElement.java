package LeetCode;

public class MajorityElement {
	
	public int majorityElement(int[] num) {
     
		int majInd = 0;
		int count = 1;
		
		for(int i = 1; i < num.length ; i ++){
			
			if(num[i] == num[majInd]){
				count++;
			}else{
				count--;
			}
			if(count == 0){
				majInd = i;
				count = 1;
			}
		}
		
		return num[majInd];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
