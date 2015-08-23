package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	
	public double getSlope(Point p1, Point p2){
		
		double slope = 0.0 ;
		if((p2.x - p1.x) != 0){
			slope = (p2.y - p1.y)/(p2.x - p1.x) ;
		}else{
			slope = Math.E;
		}
		return slope;
		
	}

	public int maxPoints(Point[] points) {
		
		if(points.length <= 1){
			return points.length;
		}
		
		int maxCount = 0;
		
		for(int i = 0 ; i < points.length ;i++){
			int numI = 1;
			int max = 0;
			Map<Double,Integer> map = new HashMap<Double, Integer>();
			for(int j = i+1 ; j < points.length ; j++){
				double score = getSlope(points[i], points[j]);
				if(points[i].x == points[j].x && points[i].y == points[j].y){
					numI++;
				}else{
					if(!map.containsKey(score)){
						map.put(score, 1);
					}else{
						map.put(score,map.get(score)+1);
					}
				}
				
				
			}
			for(int numPoints : map.values()){
				if(max < numPoints){
					max = numPoints;
				}
			}
			
			if(maxCount < max + numI){
				maxCount = max + numI;
			}
			
		}
		
		return maxCount;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
