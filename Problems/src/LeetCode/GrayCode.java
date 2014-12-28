package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public class Solution {
		public List<Integer> grayCode(int n) {

			List<Integer> result = new ArrayList<Integer>();

			

			result.add(0);
			if(n==0){
				return result;
			}
			result.add(1);

			if(n==1){
				return result;
			}

			int count = 2;

			while(count <= n){
				int numElement = (int) (Math.pow(2, count) - Math.pow(2, count-1));


				for(int i = 1; i <= numElement; i ++){

					result.add(numElement+result.get(numElement-1-(i-1)));

				}
				count++;

			}

			return result;

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
