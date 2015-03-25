package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	
	public void permute(int[] num, boolean[] used,List<List<Integer>> result, List<Integer> out){
		
		if(out.size() == num.length){
			
			result.add(new ArrayList<Integer>(out));
			return;
			
		}
		
		for(int i = 0; i < num.length ; i++){
			
			if(used[i] || (i > 0 && !used[i-1]) && num[i] == num[i-1]){
				continue;
			}
			
			out.add(num[i]);
			used[i] = true;
			permute(num,used,result,out);
			used[i] = false;
			out.remove(out.size() -1);
			
		}
		
	}



	public List<List<Integer>> permuteUnique(int[] num) {
		
		boolean[] used = new boolean[num.length]; 
		
		Arrays.sort(num);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<Integer> out = new ArrayList<Integer>();
		
		permute(num,used,result,out);
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = new int[3];
		num[0] = 1;
		num[1] = 2;
		num[2] = 1;
		//num[3] = 4;
		
		PermutationsII p = new PermutationsII();
		
		List<List<Integer>> out =  p.permuteUnique(num);
		
		System.out.println(out);

	}


}
