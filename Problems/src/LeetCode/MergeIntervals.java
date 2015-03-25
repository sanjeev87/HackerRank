package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	
	 public List<Interval> merge(List<Interval> intervals) {
		 
		 Collections.sort(intervals, comp);
		 
		 int i = 1; 
		 
		 while(i < intervals.size()){
			 
			 Interval first = intervals.get(i-1);
			 Interval second = intervals.get(i);
			 
			 if(first.end >= second.start){
				 second.start = first.start;
				 second.end = Math.max(first.end,second.end);
				 intervals.remove(first);
			 }else{
				 i++;
			 }
			 
		 }
		 
		return intervals; 
	 }
	 
	 
	
	 public static Comparator<Interval> comp = new Comparator<Interval>(){
		 public int compare(Interval i1, Interval i2) {
             return i1.start-i2.start;
         } 
	 };
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
