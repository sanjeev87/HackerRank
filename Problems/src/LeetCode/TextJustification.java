package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
		
		List<String> result = new ArrayList<String>();
		List<String> line = new ArrayList<String>();

		if(words == null || words.length == 0 || L < 0){
			return result;
		}
		
		int len = 0,mod,div;
		StringBuilder out = new StringBuilder();
		
		for(String word : words){
			
			if(len + line.size() + word.length() <= L){
				 line.add(word);
				 len += word.length();
			}else{
				if(line.size() == 1){
					out.append(line.get(0));
					for(int j = L - len ; j > 0 ; j--){
						out.append(" ");
					}
				}else{
					// more than one word
					div = (L - len) / (line.size() - 1);
					mod = (L - len) % (line.size() - 1);
					out.append(line.get(0));
					for(int j = 1 ;  j < line.size() ; j ++){
						for(int k = 0 ; k < div ; k++){
							out.append(" ");
						}
						if(j <= mod){
							out.append(" ");
						}
						out.append(line.get(j));
					}
				}
				result.add(out.toString());
				out.setLength(0);
				line.clear();
				len = word.length();
				line.add(word);
				
			}
			
		}
		out.setLength(0);
		out.append(line.get(0));
		for(int i = 1 ; i < line.size() ; i++){
			out.append(" ");
			out.append(line.get(i));
		}
		
		for(int k = L - out.length() ; k > 0 ; k--){
			out.append(" ");
		}
		result.add(out.toString());
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
