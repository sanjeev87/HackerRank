package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {


	public List<Integer> getMaxIndex(int[] height){
		int max = 0;
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < height.length ; i++){
			if(height[i] > max){
				max = height[i];
			}
		}
		for(int i = 0 ; i < height.length ; i++){
			if(height[i] == max){
				result.add(i);
			}
		}
		return result;
	}

	// this is an order of N^2 solution that does not pass leetcode
	// order N solution is below
	public int largestRectangleAreaON2(int[] height) {

		if(height.length == 0){
			return 0;
		}
		int maxArea = 0;
		for(int j : getMaxIndex(height)){
			int left = j ;
			int right = left;
			int minHeight = height[left];
			int area = height[left];
			while(left != 0 || right != height.length-1){
				if(left == 0){
					right++;
				}else if(right == height.length-1){
					left--;
				}else{
					if(height[left-1] > height[right+1]){
						left--;
					}else{
						right++;
					}
				}
				int width = right - left + 1;
				minHeight = Math.min(minHeight, Math.min(height[left], height[right]));
				if(area < minHeight*width){
					area = minHeight*width;
				}
			}
			if(maxArea < area){
				maxArea = area;
			}
		}
		return maxArea;
	}

	public int largestRectangleArea(int[] height){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int maxArea = 0;
		int i = 0;
		
		while(i <= height.length){
			
			int h = 0;
			
			if(i < height.length){
				h = height[i];
			}
			
			if(stack.isEmpty() || height[stack.peek()] < h){
				stack.push(i);
				i++;
			}else{
				int top = stack.pop();
				int area = height[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if(area > maxArea){
					maxArea = area;
				}
				
			}
			
		}
		
		
		
		return maxArea;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
