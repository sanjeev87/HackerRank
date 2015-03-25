package LeetCode;

public class FactorialTrailingZeros {


	public int trailingZeroes(int n) {


		int fives = 0;

		while(n > 0){
			n = n / 5;
			fives += n;
		}

		return fives;

	}

	public static void main(String[] args) {

		FactorialTrailingZeros f = new FactorialTrailingZeros();
		int zeros = f.trailingZeroes(101);
		System.out.println(zeros);
	}

}
