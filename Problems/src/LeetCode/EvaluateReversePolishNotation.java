package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
     
    	Stack<Integer> stack = new Stack<Integer>();
    	int result = 0;
    	for(int i = 0 ; i < tokens.length ; i ++){
    		
    		try{
    			
    			int num = Integer.parseInt(tokens[i]);
    			stack.push(num);
    			
    		}catch(Exception e){
    			
    			int num2 = stack.pop();
    			int num1 = stack.pop();
    			
    			if(tokens[i].equals("+")){
    				result = num1 + num2;
    			}
    			else if(tokens[i].equals("-")){
    				result = num1 - num2;
    			}
    			else if(tokens[i].equals("*")){
    				result = num1 * num2;
    			}
    			else if(tokens[i].equals("/")){
    				result = num1 / num2;
    			}
    			stack.push(result);
    			
    		}
    		
    	}
    	
    	return stack.pop();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] tokens = {"4","5","+","3","*"};
		
		EvaluateReversePolishNotation p = new EvaluateReversePolishNotation();
		int result = p.evalRPN(tokens);
		System.out.println(result);
		
	}

}
