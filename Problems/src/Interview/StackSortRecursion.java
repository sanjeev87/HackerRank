package Interview;

import java.util.*;

public class StackSortRecursion {

	private static boolean inserted = false;


	public static void stackSort(Stack<Integer> stack){

		if(stack == null || stack.isEmpty()){
			return;
		}
		int top = stack.pop();
		stackSort(stack);
		inserted = false;
		sortInsert(stack, top);

	}

	public static void sortInsert(Stack<Integer> stack , int num){

		if(stack.size() == 0){
			inserted = true;
			stack.push(num);
			return;
		}

		int top = stack.pop();
		if(inserted){
			stack.push(top);
		}else if(top >= num){
			sortInsert(stack,num);
			stack.push(top);
		}else if(top < num){
			stack.push(top);
			stack.push(num);
		}



	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(2);
		stack.push(-2);
		
		System.out.println("Original input stack :" + stack);
		
		stackSort(stack);
		
		System.out.println("Sorted output stack :" + stack);

	}

}
