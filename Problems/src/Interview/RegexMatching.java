package Interview;

public class RegexMatching {

	// match regex with support for . and * 
	public static boolean match(String inputStr, String regEx){
		
		if(regEx.length() == 0){
			return inputStr.length() == 0;
		}
		
		if(regEx.length() == 1 || regEx.charAt(1) != '*'){
			if(inputStr.length() < 1 || inputStr.charAt(0) != regEx.charAt(0)
					&& regEx.charAt(0) != '.' ){
				return false;
			}
			return match(inputStr.substring(1),regEx.substring(1));
		}
		
		int i = -1;
		while(i < inputStr.length() && ( i < 0 || inputStr.charAt(i) == regEx.charAt(0)
				|| regEx.charAt(0) == '.') ){
			if(match(inputStr.substring(i+1),regEx.substring(2))){
				return true;
			}
			i++;
		}
		
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "aaa";
		String regEx = "a*";
		
		System.out.println(match(input, regEx));
		//System.out.println(input.charAt(2));
		//System.out.println(regEx.substring(1));
	}

}
