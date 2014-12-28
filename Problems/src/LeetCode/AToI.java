package LeetCode;

public class AToI {


	public int atoi(String str) {

		double result = 0;
		int index = 0;

		//str = str.replaceAll("\\s+", "");
		//str.replaceAll("\\W", "");
        str = str.trim();
        
		if(str == null || str.isEmpty()){
			return 0;
		}

		boolean positive = true;
		//while(index < 1 && str.charAt(index) == '+' || str.charAt(index) == '-'){
			if(str.charAt(0) =='-'){
				positive = positive ? false : true;
				index++;
			}else if(str.charAt(0) == '+'){
				positive = positive ? true : false;
				index++;
			}
	//	}
		while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){

			if(result > Integer.MAX_VALUE ){
				result = Integer.MAX_VALUE;
				break;
			}
			
		    if(result < Integer.MIN_VALUE ){
				result =  Integer.MIN_VALUE ;
				break;
			}
			

			result = result * 10 + (str.charAt(index) - '0');
			index++;

		}

		return (int) (positive ? result : -result);


	}


	public static void main(String[] args) {

		String test = "      0108787999  777   ";
		test = test.replaceAll("\\s+", "");
		System.out.println(test);
		test = test.replaceAll("\\W", "");
		System.out.println(test);
		System.out.println(test.charAt(4));
		System.out.println((int)test.charAt(4));
		System.out.println(test.charAt(4) - '0' );
		System.out.println((int)'0');

	}

}
