package LeetCode;

public class LongestPalindromeSubstring {


	public String expand(String s, int start, int end){

		int left = start ;
		int right = end;

		while(left >= 0 && right <= s.length() - 1 
				&& s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}


		return s.substring(left+1, right );
	}

	public String longestPalindrome(String s) {

		String longest = "";

		for(int i = 0 ; i < s.length() ; i ++){

			String s1 = expand(s, i, i);
			if(s1.length() > longest.length()){
				longest = s1;
			}

			String s2 = expand(s, i, i+1);
			if(s2.length() > longest.length()){
				longest = s2;
			}

		}


		return longest;
	}


	public static void main(String[] args) {

		String s = "High";

		System.out.println(s.substring(1, 1));
		System.out.println(s.substring(1, 2));

	}

}
