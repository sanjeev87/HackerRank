package Graph;

import java.io.*;
import java.util.*;

public class JourneyToTheMoon {
	
	/*
	 * Problem can be found at https://www.hackerrank.com/challenges/journey-to-the-moon
	 * 
	 * The member states of the UN are planning to send two people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts in such a way, that both are citizens of different countries.
		There are N astronauts numbered with identifiers from 0 to N-1. They are qualified and trained to be sent to the moon. But the trouble is that those in charge of the mission haven’t been directly informed about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

		Your task is to compute in how many ways they can pick a pair of astronauts satisfying the above criteria, to be sent to the moon. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if 1,2,3 are astronauts from the same country; it is sufficient to mention that (1,2) and (2,3) are pairs of astronauts from the same country without providing information about a third pair (1,3). 
		
		Input Format
		The first line contains two integers, N and I separated by a single space. I lines follow. each line contains 2 integers separated by a single space A and B such that
		
		0 ≤ A, B ≤ N-1
		
		and A and B are astronauts from the same country.
		
		Output Format
		An integer containing the number of permissible ways in which a pair of astronauts can be sent to the moon.
		
		Constraints
		1<=N<=105
		1<=I<=106
		
		Sample Input
		
		4 2
		0 1
		2 3
		Sample Output
		
		4
		Explanation
		As persons numbered 0 and 1 belong to same country and 2 and 3 belong to same country. So the UN can choose one person of 0,1 and one out of 2,3. So number of ways of choosing pair is 4.
*/
	
   public static long getNChoose2(int N){
	   if(N <= 1)
		   return 0;
	   
	   return (long)N*(N-1)/2;
   }
   
   public static long getNumCombos(Map<Integer,Set<Integer>> astroClassifiedMap , int N){
	   
	   long numWaysForSameCountryTeams = 0 ;
	   for(int astronaut : astroClassifiedMap.keySet()){
		   int numAstros = astroClassifiedMap.get(astronaut).size() + 1 ;
		   numWaysForSameCountryTeams += getNChoose2(numAstros);
	   }
	   
	  return getNChoose2(N) - numWaysForSameCountryTeams;
	   
   }
	
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
      
        Map<Integer,Set<Integer>> astroMap = new TreeMap<Integer, Set<Integer>>(); 
        Map<Integer,Set<Integer>> astroMapClassified = new TreeMap<Integer, Set<Integer>>(); 

        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
          // Store a and b in an appropriate data structure of your choice
            
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            
            if(!astroMap.containsKey(min)){
            	astroMap.put(min, new TreeSet<Integer>());
            }
            astroMap.get(min).add(max);
          
        }
        
       int seed = Collections.min(astroMap.keySet());
       
       boolean keyValuePairExists = true;
       
       while(keyValuePairExists){

    	   Set<Integer> values = astroMap.get(seed);
    	   astroMap.remove(seed);
    	   astroMapClassified.put(seed, values);

    	   boolean anotherKeyExist = true;
    	   Set<Integer> tempSet = new TreeSet<Integer>(values);

    	   while(anotherKeyExist ){

    		   Set<Integer> nextItrSet = new TreeSet<Integer>();
    		   for(int astronaut : tempSet){
    			   if(astroMap.containsKey(astronaut)){
    				   astroMapClassified.get(seed).addAll(astroMap.get(astronaut));
    				   nextItrSet.addAll(astroMap.get(astronaut));
    				   astroMap.remove(astronaut);
    			   }

    			   for(int ass : astroMap.keySet()){
    				   Set<Integer> assValue = astroMap.get(ass);
    				   if(assValue.contains(astronaut)){
    					   astroMapClassified.get(seed).add(ass);
    					   nextItrSet.add(ass);
    				   }
    			   }

    		   }

    		   if(nextItrSet.isEmpty()){
    			   anotherKeyExist = false;
    		   }else{
    			   tempSet = nextItrSet;
    		   }

    	   }


    	   if(!astroMap.isEmpty()){
    		   seed = Collections.min(astroMap.keySet());
    	   }else{
    		   keyValuePairExists = false;
    	   }

       }
       
		long combinations = getNumCombos(astroMapClassified, N);
        
        // Compute the final answer - the number of combinations
        System.out.println(combinations);

    }
}

 

