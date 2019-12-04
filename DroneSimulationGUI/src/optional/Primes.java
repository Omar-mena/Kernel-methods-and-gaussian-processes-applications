package optional;

import java.util.ArrayList;

public class Primes {

	private int maxNum = 100;							// maximum number
	private boolean sieve[] = new boolean[maxNum];
	private  ArrayList <Integer> maxj = new ArrayList <Integer>();// sieve is array of booleans

	/**
	 * construct class, initialising the array
	 */
	public Primes()  {
		sieve[0] = false;
		sieve[99] = false;
		
		for(int i = 1; i < maxNum; i++ ) {
			sieve[i] = true;
		}
		
			// elements 0,1 set false, so not prime, 2..maxNum-1 are true - as possible primes
	}
	/**
	 * do the sieving algorithm
	 */
	public ArrayList<Integer> doSieving() {
		
		for(int i = 2; i<= maxNum; i++) { 
			if(sieve[i-1]) {
				  maxj.add(i);
			//System.out.println(i);
			}
		for(int j = i*i; j <=maxNum; j += i) {
			sieve[j -1] = false;
		}
		}
				// for each element in array
				// if true, then this number is prime
				// but all multiples are not, so set false
	return maxj;
	}
	
	/**
	 * return as a string a list of all prime numbers
	 * @return string
	 */
	public String toString() {
		
		String s = "Primes are";
		 for (int i=0; i <maxj.size(); i++) {
		    	s= s + "\n" + maxj.get(i); 
		    										// for each element in sieve
		 }							                // if it is prime, add to string
		return s;									// return result
	}

	public static void main(String[] args) {
		// main function to test algorithm
		Primes sieve = new Primes();				// create sieve
		sieve.doSieving();							// do the sieving process
		System.out.println(sieve.toString());		// get and print results
	}

}