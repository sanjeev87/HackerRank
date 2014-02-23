package String;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GameOfThronesII {
	
	/*
	 * problem can be found at https://www.hackerrank.com/challenges/game-of-throne-ii
	 */

    public static long modFact(long n, long mod){
        
        long fac = 1;
        
       for(long i = 1; i <= n ; i++ ){
           fac = (fac % mod) * (i%mod);
       }
        
        return fac;
        
    }
    
    public static long modFactInv(long n, long mod){
        
        long fac = 1;
        
       for(long i = 1; i <= n ; i++ ){
           //fac = (fac % mod) * (i%mod);
    	   fac = fac * modInv(i, mod);
       }
        
        return fac;
        
    }
    
   
    
    
    public static long modMult(long x, long y, long mod){
        
        return ( (x % mod) * (y % mod) ) % mod;
        
    }
    
    public static long modInv( long den,   long modulo) {
         long newNum = 1; 
        	long	 oldNum = 0;
        	long	 q = modulo; 
        	long	 r = 0; 
        	long	 h = 0;
        boolean pos = false;
        while (den > 0) {
            r = q%den;
            q = q/den;
            h = q*newNum + oldNum;
            oldNum = newNum;
            newNum = h;
            q = den;
            den = r;
            pos = !pos;
        }
        
        long ans =  (pos) ? oldNum : (modulo - oldNum);
        
        return ans;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        Scanner sc = new Scanner(System.in);
    	
    	//System.out.println(Solution.modInv(4, 25));
        
        String inputStr = sc.next();
    	
        int inputLength = inputStr.length();
        
        final long modulo = 1000000007;
        
        Map<Character,Integer> charToOccurMap = new TreeMap<Character,Integer>();
        
        for(int index = 0 ; index < inputLength ; index ++){
            
            char nextChar = inputStr.charAt(index);
            if(!charToOccurMap.containsKey(nextChar)){
                charToOccurMap.put(nextChar,1);
            }else{
                charToOccurMap.put(nextChar,charToOccurMap.get(nextChar) + 1);
            }
        }
        
        if(inputLength % 2 == 0){
            // when even 
            long numerator = 1;
            long denominator = 1;
            long totalHalfOccur = 0;
            for(char aChar : charToOccurMap.keySet()){
                totalHalfOccur += charToOccurMap.get(aChar) / 2;
                denominator = GameOfThronesII.modMult(denominator, GameOfThronesII.modFact( (long)  ( (charToOccurMap.get(aChar) ) / 2) ,modulo  ) , modulo);
            }
            numerator = GameOfThronesII.modFact(totalHalfOccur, modulo);
            System.out.println(GameOfThronesII.modMult(numerator,GameOfThronesII.modInv(denominator, modulo),modulo));
            
        }else{
            // when odd
            long numerator = 1;
            long denominator = 1;
            long totalHalfOccur = 0;
            for(char aChar : charToOccurMap.keySet()){
                if(charToOccurMap.get(aChar) % 2 == 1){
                   if(charToOccurMap.get(aChar) > 1){
                       totalHalfOccur += (charToOccurMap.get(aChar) - 1) / 2;
                       denominator = GameOfThronesII.modMult(denominator, GameOfThronesII.modFact( (long)  ( (charToOccurMap.get(aChar) - 1) / 2) ,modulo  ) , modulo);
                       
                   }else{
                       // do nothing
                   }
                    
                }else{
                   
                totalHalfOccur += charToOccurMap.get(aChar) / 2;
                denominator = GameOfThronesII.modMult(denominator, GameOfThronesII.modFact( (long)  ( (charToOccurMap.get(aChar)) / 2) ,modulo  ) , modulo);
                }
                
            }
            numerator = GameOfThronesII.modFact(totalHalfOccur, modulo);
            System.out.println(GameOfThronesII.modMult(numerator,GameOfThronesII.modInv(denominator, modulo),modulo));
            
            
        }
        
        
    }
}
