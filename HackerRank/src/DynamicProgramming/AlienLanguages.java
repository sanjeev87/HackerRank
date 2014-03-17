
package DynamicProgramming;

import java.util.Scanner;

/*   https://www.hackerrank.com/contests/monthly/challenges/alien-languages
	
	Sophia has discovered several different alien languages. Suprisingly all of these languages have an alphabet, and each of them may contain thousands of characters! Also all words in a language have the same number of characters in it.
	
	However, these aliens enjoy having their words be aesthetically pleasing, which for them means that all words have the requirement that for the ith letter of an n letter alphabet (letters are indexed at 1):
	
	if 2*i > n
	
	the ith letter may be the last letter of a word, and it may be immediately followed by any letter including itself.
	
	if 2*i ≤ n
	
	the ith letter can not be the last letter of a word and also can only be immediately followed by jth letter iff j ≥ 2*i.
	
	Sophia wants to know how many different words there can be in this language. Since the result may be large, she wants it modulo 100000007.
	
	Input
	
	The first line contains t, the number of test cases. The first line is followed by t lines, each line denoting a test case. Each test case will have two space separated integers n,m which denote the number of letters in the language and the length of words in this language respectively.
	
	Output
	
	For each testcase output on its own line the number of possible words modulo 100000007.
	
	Constraints
	
	1 ≤ t ≤ 5
	1 ≤ n ≤ 105
	1 ≤ m ≤ 5*105
	
	Sample Input
	
	3
	1 3
	2 3
	3 2
	Sample Output
	
	1
	3
	6
	Explanation
	For the first test-case, there’s one letter and all the words consist of 3 letters. There’s only one possibility which is “aaa”
	
	For the second test-case, there are two letters (a & b) and all of the words are 3 letters. The possible ones are “abb”, “bab”, & “bbb”. The words can end only with ‘b’ since 2 * index(b) = 2 * 2 > 2 and for ‘a’, it’s 2 * index(a) = 2 * 1 <= 2. “aab” is not allowed because ‘a’ can not be followed immediately by ‘a’. For a word of length 4 and alphabet size 2, “abab” would be allowed.
	
	For the third test-case, there are three letters (a, b & c) and all of the words are 2 letters. The words can end only with ‘b’ or ‘c’. The possible words are “ab”, “ac”, “bb”, “cc”, “bc”, “cb”
	
*/


public class AlienLanguages {
	
	private static final int MODULO = 100000007;
	
	/*
	 * returns roundUp(LogBase2(x))
	 */
	public static int log2(int x){
		int result = 0;
		
		while(x > 0){
			x >>= 1;
			result ++;
		}
			
		return result;
	}
	
	
	/*
	 * This method builds the number of ways making special case words, i.e. words with an additional special condition
	 * special case words have only one letter in the second half of the alphabet in them
	 * this letter has to be the last letter of the word for it to be a legitimate word as defined in the problem
	 */
	public static int[][] buildNumSpecialCaseWords(int sizeOfAlphabet, int sizeOfWord){
		
		int maxSizeOfSpecialCaseWords = log2(sizeOfAlphabet);
		
		/*
		 * consider array[i][j]
		 * this 2d array holds the number of ways of making special case words starting with the ith letter of 
		 * the alphabet or some letter after it and having j more characters following it.
		 * 
		 * i is indexed from 1 to sizeOfAlphabet
		 * j is indexed from 0 to maxSizeOfSpecialCaseWords - 1, as it is the number of additional characters after the first character
		 */
		int[][] array = new int[sizeOfAlphabet+1][maxSizeOfSpecialCaseWords];
		
		for(int i = sizeOfAlphabet ; i > 0 ; i --){
			if(i == sizeOfAlphabet)
				array[i][0] = 1;
			else if(2*i > sizeOfAlphabet)
				array[i][0] = 1 + array[i+1][0];
			else
				array[i][0] = array[i+1][0];
		}
		
		for(int i = sizeOfAlphabet-1 ; i > 0 ; i --){
			
			for(int j= 1 ; j < maxSizeOfSpecialCaseWords ; j ++){
				
				/*
				 * we can never have a special case word of size 2 or more that 
				 * starts with a letter in the second half
				 */
				if(2*i > sizeOfAlphabet)
					array[i][j] = 0;
				else{
					// the word can either start with the i+1 th letter or the i th letter
					array[i][j] = array[i+1][j] + array[2*i][j-1];
					array[i][j] %= MODULO;
				}
				
			}
			
		}
		return array;
	}
	
	public static int computeNumPossibleWords(int sizeOfAlphabet, int sizeOfWord, int[][] array){
		
		int maxSizeOfSpecialCaseWords = log2(sizeOfAlphabet);
		
		/*
		 * 	consider numPossibleSpecialCaseWords[i],
		 *  stores num possible sp.case words starting with the first letter of the alphabet or later and 
		 *  containing i letters in it.
		 */
		int[] numPossibleSpecialCaseWords = new int[maxSizeOfSpecialCaseWords + 1];
		
		for(int i = 1 ; i <= maxSizeOfSpecialCaseWords ; i ++ ){
			numPossibleSpecialCaseWords[i] = array[1][i-1];
		}
		
		int[] numPossibleWords = new int[sizeOfWord + 1];
		// for ease of programming
		numPossibleWords[0] = 1;
		
		for(int i = 1 ; i <= sizeOfWord ; i ++){
			
			for(int j = 1 ; j <= maxSizeOfSpecialCaseWords ; j ++ ){
				
				if(j>i) break;
				
				long temp = (long) numPossibleSpecialCaseWords[j] ;
				temp %= MODULO ;
				temp *= numPossibleWords[i-j];
				temp %= MODULO ;
				
				numPossibleWords[i] += (int) temp;
				numPossibleWords[i] %= MODULO;
				
			}
		}
		
		return numPossibleWords[sizeOfWord];
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1 ;i <= T ; i ++){
			int sizeOfAlphabet = sc.nextInt();
			int sizeOfWord = sc.nextInt();
			
			System.out.println(computeNumPossibleWords(sizeOfAlphabet, sizeOfWord, buildNumSpecialCaseWords(sizeOfAlphabet, sizeOfWord)));
		}
	}

}
