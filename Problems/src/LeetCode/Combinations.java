package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public void combine(int n, int k, int start,List<Integer> out,List<List<Integer>> result){

		if(out.size() == k){
			result.add(new ArrayList<Integer>(out));
			return;
		}
		
		for(int i = start ; i <= n ; i++){
			out.add(i);
			combine(n, k, i+1, out, result);
			out.remove(out.size()-1);
		}

	}


	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> out = new ArrayList<Integer>();
		
		if(n == 0 || k == 0){
			return result;
		}

		combine(n, k, 1, out,result);

		return result;
	}

	public static void main(String[] args) {

		Combinations c = new Combinations();
		
		List<List<Integer>> result = c.combine(4, 2);
		
		System.out.println(result);
		
	}

}
