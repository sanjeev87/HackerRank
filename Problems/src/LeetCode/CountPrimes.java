package LeetCode;

import java.util.Arrays;

public class CountPrimes {

	public int countPrimes(int n) {
		return countNumPrimes(n);
	}
	
	private boolean isPrime(int n){
		
		if(n <= 1){
			return false;
		}
		for(int i = 2 ; i*i <= n ; i ++){
			if(n % i == 0) return false;
		}
		return true;
	}
	
	private int countNumPrimes(int n){
		if(n <= 1){
		    return 0;
		}
		boolean[] primes = new boolean[n];
		
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2 ; i * i < n ; i++){
			if(!isPrime(i)) continue;
			for(int j = i*i ; j < n ; j = j + i){
				primes[j] = false;
			}
		}
		
		int count = 0;
		for(boolean prime : primes){
			if(prime) count++;
		}
		return count;
		
	}

}
