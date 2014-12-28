package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {


	public List<List<Integer>> threeSum(int[] num) {

		Arrays.sort(num);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for(int i = 0 ; i < num.length-2 ; i ++){

			if(i == 0 || num[i] != num[i-1]){

				int start = i+1;
				int end = num.length - 1;

				while(start<end){


					if(num[start] + num[end] > -num[i]){
						end--;
					}else if(num[start] + num[end] < -num[i]){
						start++;
					}else{

						List<Integer> out = new ArrayList<Integer>();
						out.add(num[i]);
						out.add(num[start]);
						out.add(num[end]);

						result.add(out);

						start++;
						end--;

						while(start < num.length && num[start - 1] == num[start]){
							start++;
						}

						while(end >= 0 && num[end+1] == num[end]){
							end--;
						}



					}



				}

			}

		}
		return result;
	}

	public static void main(String[] args) {

	}

}
