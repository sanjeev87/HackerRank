package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {


	


	public String largestNumber(int[] num) {
		
		
		Comparator<String> LargestNumComp = new Comparator<String>() {

			public int compare(String s1, String s2) {
				
				return -1 * (s1+s2).compareTo(s2+s1);
				
			}

		};
		

		String[] sArr = new String[num.length];
		
		for(int i = 0 ; i < num.length ; i++){
			sArr[i] = num[i]+""; 
		}
		
		Arrays.sort(sArr, LargestNumComp);
		
		if(sArr[0].charAt(0) == '0'){
			return 0+"";
		}
		
		StringBuilder out = new StringBuilder();
		
		for(int i = 0 ; i < sArr.length ; i++){
			out.append(sArr[i]); 
		}

		return out.toString();
	}

}
