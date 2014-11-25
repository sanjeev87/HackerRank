package Interview;

import java.util.Scanner;
import java.io.*;

public class Solution {
	
	static int M = 0;
	static int N = 0;
	
	static int bestSolution = 0;
	
	public static int getNumMatchingRows(String[][] input){
		int score = 0;
		
		for(int i=0; i<input.length; i++){
			boolean matchingRow = true;
			 for(int j=0; j<input[i].length - 1; j++){
				 if(!input[i][j].equals(input[i][j+1])){
					 matchingRow = false;
				 }
			 }
			 if(matchingRow){
				 score++;
			 }
		}
	
		return score;
		
	}
	
	public static void flipColumn(int column, String[][] input){
		
		for(int i=0; i<input.length; i++){
			if(input[i][column].equals("P")){
				input[i][column] = "T";
			}else{
				input[i][column] = "P";
			}
		}
		
	}
	
	public static int match(int row, String[][] input){
		
		String[][] copy = new String[M][N];
		
		for(int i=0; i<input.length; i++){
			 for(int j=0; j<input[i].length; j++){
				 copy[i][j]=input[i][j];
			 }
		}
		
		for(int j=0; j<input[row].length; j++){
			
			if(input[row][j].equals("P")){
				continue;
			}else{
				flipColumn(j, copy);
			}
			
		}
			   
		int score = getNumMatchingRows(copy);
		
		return score;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		String[][] input = new String[M][N];
		
		for(int i=0; i<input.length; i++){
			String line = sc.nextLine();
			String[] arr = line.split("");
				 for(int j=0; j<input[i].length; j++){
					 input[i][j]= arr[j];
				 }
		}
		
		for(int i=0; i<input.length; i++){
			int score = match(i, input);
			if(score > bestSolution){
				bestSolution = score;
			}
		}
		
		
		
		System.out.println(bestSolution);

	}

}
