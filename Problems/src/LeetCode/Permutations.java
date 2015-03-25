package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	

	public void permute(int[] num, boolean[] used,List<List<Integer>> result, List<Integer> out){
		
		if(out.size() == num.length){
			result.add(new ArrayList<Integer>(out));
			return;
		}
		
		for(int i = 0; i < num.length ; i++){
			
			if(used[i]){
				continue;
			}
			
			out.add(num[i]);
			used[i] = true;
			permute(num,used,result,out);
			used[i] = false;
			out.remove(out.size() -1);
		}
		
	}

	public List<List<Integer>> permute(int[] num) {
		
		boolean[] used = new boolean[num.length]; 
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<Integer> out = new ArrayList<Integer>();
		
		permute(num,used,result,out);
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = new int[4];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		num[3] = 4;
		
		Permutations p = new Permutations();
		
		List<List<Integer>> out =  p.permute(num);
		
		System.out.println(out);

	}

}
