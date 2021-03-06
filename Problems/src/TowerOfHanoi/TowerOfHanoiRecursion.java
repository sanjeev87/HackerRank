package TowerOfHanoi;
/*
 * Input : given n starting discs and m pegs 
 * Output : print the state at the end of each move
 */
public class TowerOfHanoiRecursion {

	 public static void main(String[] args) {
	        playHanoi (3,"A","B","C");
	    }

	    //move n disks from position "from" to "to" via "other"
	    private static void playHanoi(int n, String from , String other, String to) {
	        if (n == 0)
	            return;

	        playHanoi(n-1, from, to, other);
	        System.out.printf("Move one disk from pole %s to pole %s \n ", from, to);
	        playHanoi(n-1, other, from, to);
	    }

}
