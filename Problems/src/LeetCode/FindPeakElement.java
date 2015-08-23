package LeetCode;

public class FindPeakElement {

	public int findPeakElement(int[] num, int start , int end) {
		
		int mid = (start + end)/2;
		
		if(mid == start){
			return num[mid] > num[end] ? mid : end;
		}
		
		if(num[mid] > num[mid+1]){
			return findPeakElement(num, start, mid);
		}else{
			return findPeakElement(num, mid+1, end);
		}
		
	}


	public int findPeakElement(int[] num) {

		if(num.length <= 1){
			return 0;
		}
		
		return findPeakElement(num, 0, num.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[4];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		num[3] = 1;
		
		FindPeakElement f = new FindPeakElement();
		
		System.out.println(f.findPeakElement(num));

	}

}
