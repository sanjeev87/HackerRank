package LeetCode;

public class ConvertDecimalToHex {
	
	
	public static String getHex(int num){
		
		StringBuilder out = new StringBuilder();
		
		String[] digits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		
		while(num > 0){
			out.insert(0, digits[num%16]);
			num = num / 16;
		}
		
		return out.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 687;
		System.out.println(getHex(num));

	}

}
