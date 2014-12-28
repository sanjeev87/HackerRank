package LeetCode;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        

		if(strs == null || strs.length == 0){
			return "";
		}
		
		if(strs.length == 1){
			return strs[0];
		}
		
		String baseStr = strs[0];
		
		for(int i = 0 ; i < baseStr.length() ; i++){
			
			char c = baseStr.charAt(i);
			
			for(int j = 1; j < strs.length ; j++){
				
				if(strs[j].length() == i || strs[j].charAt(i) != c){
					return baseStr.substring(0, i);
				}
				
			}
			
		}
		
		
		return baseStr;
	
    }

	public static void main(String[] args) {

		String a = "HIBYEYOU";
		String b = "HIBYEME";
		
		String c = a.replaceAll("["+b+"]", "");
		System.out.println(c);
		
		
	}

}
