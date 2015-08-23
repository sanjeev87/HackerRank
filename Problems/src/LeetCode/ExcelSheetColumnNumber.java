package LeetCode;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {

		int num = 0;
		
		while(!s.isEmpty()){
			
			char c = s.substring(0,1).toCharArray()[0];
			num = num *26 + (c - 'A'+1);
			s = s.substring(1,s.length()) ;
		}
		
		return num;
	}

	public static void main(String[] args) {

		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("AZ"));
		
	}
	

}
