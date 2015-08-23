package LeetCode;

public class AddBinary {
	
	
	


	public String addBinary(String a, String b) {

		int carry = 0;
		
		int maxLen = Math.max(a.length(),b.length());
		
		StringBuilder out = new StringBuilder();
		
		for(int i = 0 ; i < maxLen;i++){
			
			int ca = Integer.parseInt(((a.length() - 1 - i < 0) ?  '0' : a.charAt(a.length() - 1 - i))+"");
			int cb = Integer.parseInt(((b.length() - 1 - i < 0) ?  '0' : b.charAt(b.length() - 1 - i))+ "");
			
			out.insert(0,(ca^cb)^carry);
			carry = ca+cb+carry > 1 ? 1 : 0;
			
		}
		
		if(carry == 1){
			out.insert(0, 1);
		}
		
		return out.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Integer.toBinaryString(3));
		
	}

}
