/*
 * PRIME NUMBERS BY SIEVE OF ERATOSTHENES
 * 
 * TIME COMPLEXITY =  O(N log log N)
 * 
 */
import java.util.*;
import java.util.Collections;

public class SieveOfEratosthenes
{
	
	public static void checkPrime(int n) {
		boolean prime[]=new boolean[n+1];
		
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			for(int j=i*i;j<=n;j+=i) {
				prime[j]=false;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(prime[i]==true)
				System.out.println(i+" ");
		}
	}
	
	
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		checkPrime(n);
		sc.close();
	}
}
