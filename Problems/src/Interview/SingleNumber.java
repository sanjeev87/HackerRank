package Interview;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[9];
		for(int i = 0 ; i < 9 ; i ++){
			input[i] = i/2;
		}
		
		int x = input[0];
		for(int i = 1 ; i < 9 ; i++ ){
			x = x ^ input[i];
			System.out.println(x);
		}
		
		System.out.println(x);
		
	}

}
