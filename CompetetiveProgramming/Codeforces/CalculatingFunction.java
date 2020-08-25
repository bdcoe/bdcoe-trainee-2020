
import java.util.*;
import java.util.Collections;

public class CalculatingFunction
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		long n,sum;
		n=sc.nextLong();
		if(n%2==0)
			sum=n/2;
		else
			sum=-(n+1)/2;
	
		System.out.println(sum);

		sc.close();
	}
}
