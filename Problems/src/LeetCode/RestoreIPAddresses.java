package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
	
	
	public void restoreIpAddresses(String s,List<String> result, 
			int start, int numRemaing, StringBuilder out){
		
		if(numRemaing <= 0){
			if(start == s.length() && !result.contains(out.toString())){
				result.add(new String(out.toString()));
			}
			return;
		}
		
		if(start == s.length()){
			if(numRemaing != 0){
				return;
			}
		}

		for(int i = start+1 ; i <= start + 3 && i <= s.length() ; i++){
			
			String temp = s.substring(start, i);
			
			if(s.substring(start, start+1).equals("0") && i > start + 1){
				continue;
			}
			
			int num = Integer.parseInt(temp);
			
			if(num >= 0 && num <= 255){
				String suffix = "";
			    if(numRemaing != 1){
			        suffix = ".";
			    }
			    String appendStr = num+suffix;
				out.append(appendStr);
				restoreIpAddresses(s, result, i, numRemaing - 1, out);
				out.setLength(Math.max(out.length() - ( appendStr.length() ),0));
			}else{
				return;
			}
			
			
		}
		
		
	}
	

	public List<String> restoreIpAddresses(String s) {

		List<String> result = new LinkedList<String>();
		
		StringBuilder out = new StringBuilder();
		
		if(s == null || s.length() < 4){
			return result;
		}
		
		restoreIpAddresses(s, result, 0, 4, out);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestoreIPAddresses r = new RestoreIPAddresses();
		String s = "100456";
		List<String> result = r.restoreIpAddresses(s);
		System.out.println(result);
		
		
	}

}
