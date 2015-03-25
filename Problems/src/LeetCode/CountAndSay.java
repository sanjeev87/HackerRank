package LeetCode;

public class CountAndSay {


	public String countAndSay(String input){

		input = input + ".";
		int count = 1;
		char prev = input.charAt(0);

		StringBuilder out = new StringBuilder();
		for(int i = 1 ; i < input.length() ; i++){
			if(input.charAt(i) == prev){
				count++;
			}else{
				out.append(count+ "" + prev);
				prev = input.charAt(i);
				count = 1;
			}
		}

		return out.toString();
	}

	public String countAndSay(int n) {

		String out = null;

		if(n < 1){
			return null;
		}

		out = 1 + "";
		
		if(n == 1){
			return out;
		}
		
		for(int i = 2 ; i <= n ; i++){
			out = countAndSay(out);
		}


		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay("21"));

	}

}
