package LeetCode;

public class ReverseNumber {
	
	
	
	public int reverse2(int x) {
		
		int num = 0;
		
		while(x > 0){
			
            if(num > Integer.MAX_VALUE / 10 || num < Integer.MIN_VALUE / 10){
                return 0;
            }
			num = num*10 + x%10;
			x = x/10;
			
		}
		
		
		
		return num;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

public int reverse(int x) {
        
        int res = 0;
        
    
        while(x != 0){
            
            int mod = x % 10;
            x = x/10;
            
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10){
                    return 0;
            }
            
            res = res * 10 + mod;
            
        }
        
        return res;
    }
}
