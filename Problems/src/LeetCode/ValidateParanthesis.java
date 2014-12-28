package LeetCode;

import java.util.Stack;

public class ValidateParanthesis {

	public boolean isValid(String s) {

		Stack<Character> stack1 = new Stack<Character>();

		for(int i = 0 ; i < s.length() ; i ++){

			if(s.charAt(i) == '('){
				stack1.push(s.charAt(i));
			}else if(s.charAt(i) == '{'){
				stack1.push(s.charAt(i));
			}else if(s.charAt(i) == '['){
				stack1.push(s.charAt(i));
			}else if(s.charAt(i) == ')'){
				if(!stack1.isEmpty() && stack1.peek()=='(')
					stack1.pop();
				else
					return false;
			}else if(s.charAt(i) == '}' ){
				if(!stack1.isEmpty()&& stack1.peek()=='{')
					stack1.pop();
				else
					return false;
			}else if(s.charAt(i) == ']'){
				if(!stack1.isEmpty()&& stack1.peek()=='[')
					stack1.pop();
				else
					return false;
			}

		}

		if(stack1.isEmpty()){
			return true;
		}else{

			return false;
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
