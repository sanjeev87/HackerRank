package LeetCode;

public class NumberOf1Bits {

	
	public int hammingWeight(int n) {


		int result = 0;
    	for(int i = 0 ; i < 32 ; i++){
			
			result += n & 1;
			n = n >> 1;
			
		}
		
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOf1Bits alg = new NumberOf1Bits();
	}

}
