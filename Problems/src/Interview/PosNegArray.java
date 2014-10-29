package Interview;

public class PosNegArray {
	
	 public static void main(String[] args) {
	        int[] array = {1,2,4,-3,8,-5, 9, 6, -7};
	        int[] arranged = reArragePostiveNegative(array);
	        
	        System.out.println("Re-arranged array: ");
	        for(int i=0; i<arranged.length; i++) {
	            System.out.print(arranged[i] + " ");
	        }
	    }
	    
	    public static int[] reArragePostiveNegative(int[] array){
	    
	     int pIndex = -1;
	     int nIndex = -1;
	 
	     for(int element : array){
	         
	         if(pIndex == -1 && element > 0 ){
	             pIndex = array.indexOf(element);
	         }
	       
	         
	         if(nIndex == -1 && element < 0 ){
	             nIndex = array.IndexOf(element);
	         }
	         
	         if(pIndex != -1 && nIndex != -1)
	             break;
	                  
	     }
	     
	     
	     int[] reArranged = new int[array.length];
	     
	     if(pIndex == -1 || nIndex == -1){
	         return array;
	     }
	     
	     boolean pos = false;
	     
	     if(pIndex < nIndex){
	      
	      reArranged[0] = array[pIndex];
	      
	      reArranged[1] = array[nIndex];
	    
	      pos = true;
	      
	     }else{
	    
	      reArranged[0] = array[nIndex];
	      
	      reArranged[1] = array[pIndex];
	     
	     
	     }
	     
	    
	     
	     int curIndex = 2;
	     
	     while(getNextPosIndex(array,pIndex) !=-1 || getNextNegIndex(array,nIndex) != -1){
	     
	             nIndex = getNextNegIndex(array,nIndex);
	             pIndex = getNextPosIndex(array,pIndex);
	          
	           if(pos){
	           
	               if(pIndex != -1)
	                   reArranged[curIndex++] = array[pIndex];
	               if(nIndex != -1)
	                   reArranged[curIndex++] = array[nIndex];
	           }else{
	               if(nIndex != -1)
	                   reArranged[curIndex++] = array[nIndex];
	               if(pIndex != -1)
	                   reArranged[curIndex++] = array[pIndex];
	           }
	           
	     
	     }
	     
	     
	        return reArranged;
	    
	    }
	    
	    public static int getNextPosIndex(int[] array, int curIndex){
	    
	    //will return -1 if none exisits
	    
	        if(curIndex == -1) return -1;
	        
	        curIndex++;
	        while(curIndex < array.length - 1){
	            
	            if(array[curIndex++] > 0)
	                return curIndex;
	            
	        }
	        
	        return -1;
	    
	    
	    }
	    
	    public static int getNextNegIndex(int[] array, int curIndex){
	    
	        if(curIndex == -1) return -1;
	        
	        curIndex++;
	        while(curIndex < array.length - 1){
	            
	            if(array[curIndex++] < 0)
	                return curIndex;
	            
	        }
	        
	        return -1;
	    
	    }
	 

}
