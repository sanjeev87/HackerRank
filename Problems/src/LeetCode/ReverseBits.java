package LeetCode;

public class ReverseBits {

	public int reverseBits(int n) {

		int result = 0;
		int digit = 0;
		
		for(int i = 0 ; i < 32 ; i++){
			
			result = result << 1;
			digit = n & 1;
			n = n >> 1;
			result = result | digit;
			
			
		}
		
		
<<<<<<< HEAD
		return 0;
=======
		return result;
>>>>>>> a876db7fac225a9bcd919b46f31dcb33a481db64
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
