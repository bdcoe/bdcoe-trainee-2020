
/*
 * GCD
 * USING EUCLID'S ALGORITHM 
 * LCM
 * 
 * The time complexity is O(log(max(A, B))).
 */
import java.util.*;
import java.util.Collections;

public class EuclidsGCD
{
	
	public static int gcd (int a , int b) 
	{	
		if(b!=0) 
			return gcd (b , a%b);
		else
			return a;
	}
	
	public static int lcm(int a , int b) 
	{
		return (a * b)/gcd(a, b);
	}
	
	
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b;
		a=sc.nextInt();
		b=sc.nextInt();
		
		System.out.println("GCD = "+gcd(a,b));
		System.out.println("LCM = "+lcm(a,b));

		sc.close();
	}
}
