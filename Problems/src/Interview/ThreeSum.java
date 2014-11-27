package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[13];
		array[0] = -1;
		array[1] = -2;
		array[2] = -5;
		array[3] = -1;
		array[4] = 2;
		array[5] = 3;
		array[6] = -4;
		array[7] = -5;
		array[8] = 6;
		array[9] = 7;
		array[10] = -5;
		array[11] = 2;
		array[12] = 3;
		
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i < array.length - 2 ; i++ ){
			
			if(i == 0 || array[i] > array[i-1]){
				
				int start = i + 1;
				int end = array.length-1;
				
				while(start < end){
					
					if(array[i] + array[start] + array[end] == 0){
						
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(array[i]);
						temp.add(array[start]);
						temp.add(array[end]);
						result.add(temp);
						start++;
						end--;
						
						while(start < end && array[start] == array[start - 1]){
							start++;
						}
						while(start<end && array[end] == array[end + 1] ){
							end--;
						}
						
						
					}else if(array[start] + array[end] < -array[i]){
						 start++;
					}else{
						end--;
					}
					
				}
				
			}
			
		}
		
		System.out.println(result);
		

	}

}
