package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * Problem can be found at https://www.hackerrank.com/challenges/vertical-sticks
 * 
 * Vertical Sticks

Given array of integers Y=y1,É,yn, we have n line segments such that endpoints of segment i are (i, 0) and (i, yi). Imagine that from the top of each segment a horizontal ray is shot to the left, and this ray stops when it touches another segment or it hits the y-axis. We construct an array of n integers, v1, É, vn, where vi is equal to length of ray shot from the top of segment i. We define V(y1, É, yn) = v1 + É + vn.

For example, if we have Y=[3,2,5,3,3,4,1,2], then v1, É, v8 = [1,1,3,1,1,3,1,2], as shown in the picture below:



For each permutation p of [1,É,n], we can calculate V(yp1, É, ypn). If we choose a uniformly random permutation p of [1,É,n], what is the expected value of V(yp1, É, ypn)?

Input Format

First line of input contains a single integer T (1 <=T<= 100). T test cases follow.

First line of each test-case is a single integer N (1 <= N <= 50). Next line contains positive integer numbers y1, É, yN separated by a single space (0 < yi <= 1000).

Output Format

For each test-case output expected value of V(yp1, É, ypn), rounded to two digits after the decimal point.

Sample Input

6

3

1 2 3

3

3 3 3

3

2 2 3

4

10 2 4 4

5

10 10 10 5 10

6

1 2 3 4 5 6

Sample Output

4.33

3.00

4.00

6.00

5.80

11.15

Explanation
 

Case 1: We have_ V(1,2,3) = 1+2+3 = 6, _V(1,3,2) = 1+2+1 = 4, V(2,1,3) = 1+1+3 = 5, V(2,3,1) = 1+2+1 = 4, V(3,1,2) = 1+1+2 = 4, V(3,2,1) = 1+1+1 = 3. Average of these values is 4.33.
Case 2: No matter what the permutation is, V(yp1, yp2, yp3) = 1+1+1 = 3, so the answer is 3.00.
Case 3: V(y1 ,y2 ,y3)=V(y2 ,y1 ,y3) = 5, V(y1, y3, y2)=V(y2, y3, y1) = 4, V(y3, y1, y2)=V(y3, y2, y1) = 3, and average of these values is 4.00.
 */

/*
 * Idea behind the solution ...
 * 
 * If we seat k ppl on a table with n seats , avg spacing = n+1/k+1 ... 
 * This is similar to seating  k+1 ppl on a circular table with n+1 slots where avg spacing = n+1/k+1.. Then break 
 * the circular table at any point where a person is seated .... 
 * 
 * avg spacing between k sticks of equal height in n slots when places randomly is n+1/k+1.. 
 * 
 * consider a stick, see how many are of equal or greater height , that is the value of k . N is the total number of sticks. get avg spacing between these sticks 
 * 
 * compute for each stick and sum it up
 * 
 */

public class VerticalSticks {
	
	public static int getNumOccurencesEqualToOrHigher(int m , List<Integer> list){
		int numEqualOrHigher = 0;
		
		for(int stickHeight : list){
			if(stickHeight >= m)
				numEqualOrHigher++;
		}
		
		return numEqualOrHigher;
	}
	
	public static String roundOffTo2DecPlaces(double val)
	{
	    return String.format("%.2f", val);
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; i ++){
			
			int N = sc.nextInt();
			List<Integer> list = new LinkedList<Integer>();
			
			for(int j = 0 ; j < N ; j ++)
				list.add(sc.nextInt());
			
			double expectedValue = 0.0; 
			for(int k : list)
				expectedValue +=  ( (double)  ( N + 1 ) ) / (VerticalSticks.getNumOccurencesEqualToOrHigher(k, list) + 1 )  ; 
			
			System.out.println( VerticalSticks.roundOffTo2DecPlaces(expectedValue));
			
		}
		
	}

}
