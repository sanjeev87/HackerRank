package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public String sortString(String str){
		char[] array = str.toCharArray();
		Arrays.sort(array);
		String out = new String(array);
		return out;
	}

	public List<String> anagrams(String[] strs) {

		Map<String,List<Integer>> StringToIndexMap = new HashMap<String, List<Integer>>();

		List<String> result = new ArrayList<String>();

		for(int i = 0 ; i < strs.length ; i ++){
			String sortedStr = sortString(strs[i]);
			if(!StringToIndexMap.containsKey(sortedStr)){
				StringToIndexMap.put(sortedStr, new ArrayList<Integer>());
			}
			StringToIndexMap.get(sortedStr).add(i);
		}

		for(String s : StringToIndexMap.keySet()){
			List<Integer> list = StringToIndexMap.get(s);
			if(list.size() > 1){
				for(int index : list){
					result.add(strs[index]);
				}
			}
		}

		return result;
	}


	public static void main(String[] args){
		
		Anagrams alg = new Anagrams();
		
		String[] input = {"",""};
		
		List<String> result = alg.anagrams(input);
		
		System.out.println(result);


	}



}
