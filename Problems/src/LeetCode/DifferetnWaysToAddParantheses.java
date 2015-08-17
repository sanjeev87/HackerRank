package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DifferetnWaysToAddParantheses {

	public List<Integer> diffWaysToCompute(String input) {

		List<Integer> result = new ArrayList<Integer>();
		boolean isExpression = false;
		for(int i = 0 ; i < input.length() ; i++){
			if("+-*".indexOf(input.charAt(i)) != -1){
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				
				for(int l : left){
					for(int r : right){
						result.add(cal(l, r, input.charAt(i)));
					}
				}
				
 				isExpression = true;
			}
		}
		
		if(!isExpression){
			result.add(Integer.parseInt(input));
		}
		
		return result;
		
	}
	
	
	int cal(int l, int r, char op) {
	    int result = 0;
	    switch (op) {
	        case '+': result= l+r; break;
	        case '-': result = l-r; break;
	        case '*': result= l*r; break;
	        default: break;
	    }
	    return result;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
