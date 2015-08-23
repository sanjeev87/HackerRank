package LeetCode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {

	public class BuildingComparator implements Comparator<int[]>{
		public int compare(int[] x, int[] y){
			if(x[2] > y[2]) return -1;
			else if(x[2] < y[2]) return 1;
			else if(x[1] >= y[1]) return 1;
			else return -1;
		}
	}
	
	public boolean checkIfValidCriticalPoint(int[] cPoint, List<int[]> result){
		
		if(result.isEmpty()){
			return true;
		}
		
		if(cPoint[1] == result.get(result.size()-1)[1]){
			return false;
		}
		
		return true;
	}

	public List<int[]> getSkyline(int[][] buildings) {
		Comparator<int[]> comparator = new BuildingComparator();
        int numBuildings = buildings.length;
		Queue<int[]> maxHeap = new PriorityQueue<int[]>(numBuildings+1,comparator);
		List<int[]> result = new ArrayList<int[]>();
		if(buildings == null || buildings.length == 0){
			return result;
		}
		int index = 0;
		while(index < numBuildings || !maxHeap.isEmpty()){
			int[] building = index < numBuildings ? buildings[index]: null;
			if(building != null){
				// if heap is empty 
				if(maxHeap.isEmpty()){
					maxHeap.add(building);
					int[] criticalPoint = {building[0],building[2]};
					if(checkIfValidCriticalPoint(criticalPoint, result)){
						result.add(criticalPoint);
					}
					
					index++;
				}else{
					//heap is non empty 
					int[] top = maxHeap.peek();
					// top has height higher  than next building
					if(top[2] >= building[2]){
						// top ends on or before the start of building
						// add building to heap, add end of top to result
						if(top[1] < building[0]){
							top = maxHeap.poll();
							int end = top[1];
							int height = 0;
							if(!maxHeap.isEmpty()){

								while(!maxHeap.isEmpty() && maxHeap.peek()[1] <= end ){
									maxHeap.poll();
								}

								if(!maxHeap.isEmpty()){
									height = maxHeap.peek()[2];
								}
							}
//							int height = maxHeap.isEmpty() ? 0 : maxHeap.peek()[1] > end ? maxHeap.peek()[2] : 0;
							int[] criticalPoint = {end,height};
							if(checkIfValidCriticalPoint(criticalPoint, result)){
								result.add(criticalPoint);
							}
//							maxHeap.add(building);
						}else if(top[1] == building[0]){
							// if top ends where the new one starts
							top = maxHeap.poll();
							maxHeap.add(building);
							int end = top[1];
							int height = maxHeap.isEmpty() ? 0 : maxHeap.peek()[2];
							int[] criticalPoint = {end,height};
							if(checkIfValidCriticalPoint(criticalPoint, result)){
								result.add(criticalPoint);
							}
							index++;
						}else{
							//top ends after start of building
							// add building to heap, nothing is added to result 
							maxHeap.add(building);
							index++;
						}
						// cur building has been processed
					
					}else{
						//top has a lower height than building
						//top ends before start of building
						if(top[1] < building[0]){
							top = maxHeap.poll();
							int end = top[1];
							int height = 0;
							if(!maxHeap.isEmpty()){

								while(!maxHeap.isEmpty() && maxHeap.peek()[1] <= end ){
									maxHeap.poll();
								}

								if(!maxHeap.isEmpty()){
									height = maxHeap.peek()[2];
								}
							}
							int[] criticalPoint = {end,height};
							if(checkIfValidCriticalPoint(criticalPoint, result)){
								result.add(criticalPoint);
							}
						}else if(top[1] == building[0]){
							top = maxHeap.poll();
							maxHeap.add(building);
							int end = top[1];
							int height = maxHeap.isEmpty() ? 0 : maxHeap.peek()[2];
							int[] criticalPoint = {end,height};
							if(checkIfValidCriticalPoint(criticalPoint, result)){
								result.add(criticalPoint);
							}
							index++;
						}else{
							maxHeap.add(building);
							int[] criticalPoint = {building[0],building[2]};
							if(checkIfValidCriticalPoint(criticalPoint, result)){
								result.add(criticalPoint);
							}
							index++;
						}
					}
				}
			}else{
				// if building is null
				if(!maxHeap.isEmpty()){
					int[] top = maxHeap.poll();
					int end = top[1];
					int height = 0;
					if(!maxHeap.isEmpty()){

						while(!maxHeap.isEmpty() && maxHeap.peek()[1] <= end ){
							maxHeap.poll();
						}

						if(!maxHeap.isEmpty()){
							height = maxHeap.peek()[2];
						}
					}
					int[] criticalPoint = {end,height};
					if(checkIfValidCriticalPoint(criticalPoint, result)){
						result.add(criticalPoint);
					}
				}
			}
		}
		

		return result;
	}



	public static void main(String[] args) {

//		int[][] builds = {{0,3,3},{1,5,3},{2,4,3},{3,7,3}};
//		int[][] builds = {{2,13,10},{10,17,25},{12,20,14}};
//		int[][] builds = {{0,2,3},{2,5,3}};
		int[][] builds = {{2,4,7},{2,4,5},{2,4,6}};
		SkylineProblem sp = new SkylineProblem();
		List<int[]> res = sp.getSkyline(builds);
		for(int[] i : res){
			for(int t : i)
				System.out.print(t+" ");
			System.out.println();
		}
		
	}

}
