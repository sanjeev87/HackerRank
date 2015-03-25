package LeetCode;

public class DungeonGame {


	public int calculateMinimumHP(int[][] dungeon) {         //USE THE ORIGINAL MATRIX TO STORE MIN INITIAL HP FOR A PATH THAT STARTS FROM CURRENT ROOM
	       for(int m = dungeon.length-1;m>=0;m--)
	           for(int n = dungeon[0].length-1;n>=0;n--){
	               if((m==dungeon.length-1)&&(n==dungeon[0].length-1)){           //AT [0,0]
	                       dungeon[m][n]=dungeon[m][n]>=0?0:-dungeon[m][n];
	               } else if(m==dungeon.length-1){                                  //AT THE RIGHT EDGE
	                       dungeon[m][n]=dungeon[m][n+1]-dungeon[m][n]>0?dungeon[m][n+1]-dungeon[m][n]:0;
	               } else if(n==dungeon[0].length-1) {                              //AT THE BOTTOM EGDE
	                       dungeon[m][n]=(dungeon[m+1][n]-dungeon[m][n])>0?dungeon[m+1][n]-dungeon[m][n]:0;
	               } else {                                                         //IN A ROOM WITH A PATH TO BE DECIDED
	                   if(dungeon[m+1][n]<dungeon[m][n+1]){
	                       dungeon[m][n]=(dungeon[m+1][n]-dungeon[m][n])>0?dungeon[m+1][n]-dungeon[m][n]:0;
	                   } else {
	                       dungeon[m][n]=(dungeon[m][n+1]-dungeon[m][n])>0?dungeon[m][n+1]-dungeon[m][n]:0;
	                   }
	               } 

	           }
	        return dungeon[0][0]+1;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][6];
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);

	}

}
