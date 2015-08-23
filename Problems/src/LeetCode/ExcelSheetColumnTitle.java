package LeetCode;

public class ExcelSheetColumnTitle {



	public String convertToTitle(int n) {
		
		StringBuilder out = new StringBuilder();
		while(n>0){
			n--;
			int num = n % 26;
			out.append((char)('A'+ num) );
			n = n/26;
		}
		return out.reverse().toString();
	}

	public static void main(String[] args) {

		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(26*26));

	}

}
