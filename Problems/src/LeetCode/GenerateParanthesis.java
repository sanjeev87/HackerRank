package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<String>();
		
		if(n == 0){
			result.add("");
			return result;
		}
		
		for(int i = 0 ; i < n ; i++){
			
			List<String> leftList = generateParenthesis(i);
			List<String> rightList = generateParenthesis(n - i - 1);
			
			for(String left : leftList){
				for(String right : rightList){
					result.add("("+ left +")" + right);
				}
			}
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
