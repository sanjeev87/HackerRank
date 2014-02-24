package DynamicProgramming;

import java.util.Scanner;

public class OilWell {

	/*
	 * https://www.hackerrank.com/challenges/oil-well
	 */
	
	
	public static void main(String[] args){
		
		final int N = 52;
		
		
		int[][][][] score = new int[N][N][N][N];
		int[][] ow = new int[N][50];
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		for(int i = 0 ; i <= m-1 ; i ++){
			for(int j = 0 ; j <= n-1 ; j ++){
				ow[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i <= m-1 ; i ++){
			for(int j = 0 ; j <= n-1 ; j ++){
				for(int k = i ; k <= m-1 ; k ++ ){
					for(int h = j ; h <= n-1 ; h++){
						
					}
				}
			}
		}
		
		
		
	}
	
	
	
	
}
