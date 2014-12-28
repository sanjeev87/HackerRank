package LeetCode;

public class IntegerToRoman {


	public String intToRoman(int num) {
        
		
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder out = new StringBuilder();
		int i = 0;
		while(num > 0){
			int q = num / values[i];
			num = num % values[i];
			for(int j = 0 ; j < q ; j ++){
				out.append(symbol[i]);
			}
			i++;
		}
		
		
		return out.toString();
	
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
