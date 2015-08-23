package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public void subsetsWithDup(int[] num, int start,
			List<List<Integer>> result, int size,
			List<Integer> out){

		if(out.size() == size){
			if(result.size() != 0 ){
				for(List<Integer> prev : result){
					boolean isDup = true;
					if(prev.size() == size){
						for(int i = 0 ; i < size ; i ++){
							if(prev.get(i) != out.get(i)){
							    isDup = false;
							    break;
							}
						}
					}else{
					    isDup = false;
					}
					if(isDup){
						return;
					}
				}
				result.add(new ArrayList<Integer>(out));
			}else{
				result.add(new ArrayList<Integer>(out));
			}
			return;
		}

		for(int i = start ; i < num.length ; i++){			
			out.add(num[i]);
			subsetsWithDup(num, i+1, result, size, out);
			out.remove(out.size()-1);
		}

	}

	public List<List<Integer>> subsetsWithDup(int[] num) {

		Arrays.sort(num);
		List<List<Integer>> result =  new ArrayList<List<Integer>>();

		// loop over subset sizes
		result = new ArrayList<List<Integer>>();
		for(int i = 0 ; i <= num.length ; i++){

			List<Integer> out = new ArrayList<Integer>();
			subsetsWithDup(num, 0, result,i,out);

		}

		return result;
	}

	public static void main(String[] args) {

		int num[] = {0};

		Subsets s = new Subsets();

		List<List<Integer>> result = s.subsetsWithDup(num);

		System.out.println(result);

	}

}
