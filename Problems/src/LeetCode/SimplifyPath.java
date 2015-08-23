package LeetCode;

import java.util.Stack;

public class SimplifyPath {


	public String simplifyPath(String path) {
		
		
		path = path.replaceAll("/+", "/");
		
		Stack<String> stack = new Stack<String>();
		
		String[] arr = path.split("/");
		
		stack.push("/");
		
		for(String s : arr){
			
			if(s.equals(".") || s.equals("")){
				continue;
			}else if(s.equals("..")){
				if(!stack.isEmpty())
					stack.pop();
				if(!stack.isEmpty())
					stack.pop();
			}else{
				stack.push(s);
				stack.push("/");
			}
			
		}
		

		if(!stack.isEmpty() && stack.peek().equals("/")){
			stack.pop();
		}
		if(stack.isEmpty()){
			stack.push("/");
		}
		
		StringBuilder out = new StringBuilder();
		
		for(String temp : stack){
			out.append(temp);
		}
		
		return out.toString();
	}

	public static void main(String[] args) {
		
		String path = "/..";
		
	//	path = path.replaceAll("/+", "/");
		
	//	System.out.println(path);
		
		SimplifyPath s = new SimplifyPath();
		String result = s.simplifyPath(path);
		System.out.println(result);

	}

}
