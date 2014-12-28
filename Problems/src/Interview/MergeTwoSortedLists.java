package Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MergeTwoSortedLists {
	public static List<Integer> merge(List<Integer> l1, List<Integer> l2){
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while( i < l1.size() && j < l2.size() ){
			if(l1.get(i) < l2.get(j)){
				result.add(l1.get(i++));
			}else{
				result.add(l2.get(j++));
			}
		}
		if(i < l1.size()){
			while(i < l1.size())
				result.add(i++);
		}
		if(j < l2.size()){
			while(j < l2.size())
				result.add(j++);
		}

		return result;
	}


	public void merge(int A[], int m, int B[], int n) {

		
		int i = 0;
		int j = 0;
		
		while(i< m -1 && j < n-1){
			
			if(A[i] < B[j]){
				i++;
			}else{
				System.arraycopy(A, i, A, i+1, m - i);
				A[i] = B[j];
				j++;
				i++;
			}
			
		}


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(8);
		l1.add(3);
		l1.add(44);
		l1.add(1100);

		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(-2);
		l2.add(5);
		l2.add(33);

		System.out.println("l1 :" + l1);
		System.out.println("l2 :" + l2);
		List<Integer> result = merge(l1, l2);
		System.out.println("result :" + result);


	}

}
