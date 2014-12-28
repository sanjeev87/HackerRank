package LeetCode;

public class DecodeWays {
	
	public int decode(String s ,int start){
		
		if(start == s.length()){
			return 0;
		}
		
		if(start+1 == s.length()){
			return 1;
		}
		
		int oneCharResult = decode(s, start+1);
		int twoCharResult = 0;
		if(start+2 <= s.length() && Integer.parseInt(s.substring(start, start+2)) < 26){
			twoCharResult = decode(s, start+2);
		}
		
		return oneCharResult + twoCharResult+1;
	}
	
	
	

	public int numDecodings(String s) {
		
		int[] result = new int[s.length()];
		
		if(s.length() == 0){
			return 0;
		}
		result[0] = 1;
		for(int i = 1 ; i < s.length() ; i++){
			
			result[i] = result[i-1];
			if(Integer.parseInt(s.substring(i-1, i+1)) <= 26){
				result[i] += 1; 
			}
			
		}
		
		return result[s.length()-1];

	}

	public static void main(String[] args) {

		DecodeWays d = new DecodeWays();
		int result = d.decode("111", 0);
		System.out.println(result);
		
	}

}
