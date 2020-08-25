
import java.util.*;
import java.util.Collections;

public class EvenOdds
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		long k;
		long n;

		n=sc.nextLong();
		k=sc.nextLong();
		long temp;
		if(n%2==0)
			temp=n/2;
		else
			temp=(n+1)/2;
		
		
		if(k<=temp)
			System.out.println(k*2-1);
		if(k>temp)
			System.out.println((k-temp)*2);
		
		sc.close();
	}
}

